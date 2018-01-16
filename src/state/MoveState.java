package state;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

import gekosem.Gekosem;
import gekosem.GraphicElement;
import gekosem.GraphicShape;
import gekosem.LinkElement;
import gekosem.commands.MoveCommand;
import gekosem.painter.ShapePainter;
import gui.model.Element;
import gui.model.tree.Node;
import gui.observer.NotificationObserver;
import gui.view.MainView;

public class MoveState extends State {

	private Gekosem med;
	private double x = 0;
	private double y = 0;
	private String stateName;
	
	public MoveState(Gekosem med) {
		super();
		this.med = med;
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		MainView.getInstance().getStatusBar().setPosition("X:" + e.getX() + " Y: "+ e.getY());
		
		med.getSlotView().setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		Point2D lastPosition = e.getPoint();
		med.transformToUserSpace(lastPosition);

		double xx = lastPosition.getX() - med.getLastPosition().getX();
		double yy = lastPosition.getY() - med.getLastPosition().getY();

		for (Element e1 : med.getSlot().getSelectionModels().getSelectionList()) {
			GraphicElement element = (GraphicElement) e1;
//			System.out.println(element.getName());
			if (element instanceof GraphicShape) {
				GraphicShape device = (GraphicShape) element;

				Point2D newPosition = (Point2D) device.getPosition().clone();
				newPosition.setLocation(newPosition.getX() + xx, newPosition.getY() + yy);
				for (Node n : med.getSlot().getChildren()) {
					if (n == device) {
						((GraphicShape) n).setPosition(newPosition);
					}
				}

			} else if (element instanceof LinkElement) {
				LinkElement link = (LinkElement)element;
				
				for(int i = 0; i < link.getPoints().size(); i++){
					link.getPoints().get(i).setLocation(link.getPoints().get(i).getX() + xx, link.getPoints().get(i).getY()+yy);
				}
				link.update();
			}
		}
		x = x + xx;
		y = y + yy;
		med.setLastPosition(lastPosition);
		med.getSlot().notifyObservers(NotificationObserver.ADD, null);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		med.getGkm().addCommand(new MoveCommand(med, med.getSlot(), med.getSlot().getSelectionModels(), x, y));
		med.getSlotView().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		x = 0;
		y = 0;
		Point2D lastPosition = e.getPoint();
		med.transformToUserSpace(lastPosition);
		med.setLastPosition(lastPosition);
		med.startSelectState();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

		MainView.getInstance().getStatusBar().setPosition("X:" + e.getX() + " Y: "+ e.getY());		
	}


}
