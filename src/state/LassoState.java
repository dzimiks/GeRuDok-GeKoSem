package state;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import gekosem.Gekosem;
import gui.observer.NotificationObserver;
import gui.view.MainView;

public class LassoState extends State {

	private Gekosem med;


	private Rectangle2D rect = new Rectangle2D.Double();

	public LassoState(Gekosem med) {
		super();
		this.med = med;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//if(e.getButton() == 3){
			med.getSlot().getSelectionModels().removeAllFromSelectionList();
	//	}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		MainView.getInstance().getStatusBar().setPosition("X:" + e.getX() + " Y: "+ e.getY());
		
		Point2D position = e.getPoint();
		med.transformToUserSpace(position);

		if (!e.isControlDown()) {
			med.getSlot().getSelectionModels().removeAllFromSelectionList();
		}

		double width = position.getX() - med.getLastPosition().getX();
		double height = position.getY() - med.getLastPosition().getY();
		if ((width < 0.0D) && (height < 0.0D)) {
			rect.setRect(position.getX(), position.getY(), Math.abs(width), Math.abs(height));
		} else if ((width < 0.0D) && (height >= 0.0D)) {
			rect.setRect(position.getX(), med.getLastPosition().getY(), Math.abs(width), Math.abs(height));
		} else if ((width > 0.0D) && (height < 0.0D)) {
			rect.setRect(med.getLastPosition().getX(), position.getY(), Math.abs(width), Math.abs(height));
		} else {
			rect.setRect(med.getLastPosition().getX(), med.getLastPosition().getY(), Math.abs(width), Math.abs(height));
		}
		med.getSlot().getSelectionModels().selectElements(rect, med.getSlot().getChildren());
		med.setSelectionRectangle(rect);
		med.getSlot().notifyObservers(NotificationObserver.ADD, null);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		med.setSelectionRectangle(new Rectangle2D.Double(0.0D, 0.0D, 0.0D, 0.0D));
		med.getSlot().notifyObservers(NotificationObserver.ADD, null);
		med.startSelectState();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		MainView.getInstance().getStatusBar().setPosition("X:" + e.getX() + " Y: "+ e.getY());
		
		med.getSlot().notifyObservers(NotificationObserver.ADD, null);

	}

}
