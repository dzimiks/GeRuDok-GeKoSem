package gekosem.commands;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import gekosem.Gekosem;
import gekosem.GraphicElement;
import gekosem.GraphicShape;
import gekosem.LinkElement;
import gekosem.select.SlotSelectionModel;
import gui.model.Element;
import gui.model.Slot;
import gui.observer.NotificationObserver;

public class MoveCommand extends ElementCommand {

	private Gekosem gek;

	private Slot slot;

	private ArrayList<Element> moved = new ArrayList<>();

	private SlotSelectionModel r = new SlotSelectionModel();

	private double x;
	private double y;
	private boolean firstAction;

	public MoveCommand(Gekosem gek, Slot slot, SlotSelectionModel r, double x, double y) {
		super();
		this.gek = gek;
		this.slot = slot;
		for (Element e : slot.getSelectionModels().getSelectionList()) {
			moved.add(e);
		}
		r = slot.getSelectionModels();
		this.r = r;
		this.x = x;
		this.y = y;
		firstAction = true;
	}

	@Override
	public void undoCommand() {
		// TODO Auto-generated method stub
		r.addToSelectionList(moved);
		for(Element e: moved){
			if (e instanceof GraphicShape ){
				GraphicShape device=(GraphicShape) e;
				Point2D newPosition = (Point2D)device.getPosition().clone();
				newPosition.setLocation(newPosition.getX() - x,newPosition.getY() - y); 
				device.setPosition(newPosition);

			}else if (e instanceof LinkElement) {
				LinkElement link = (LinkElement)e;
				
				for(int i = 0; i < link.getPoints().size(); i++){
					link.getPoints().get(i).setLocation(link.getPoints().get(i).getX() - x, link.getPoints().get(i).getY()-y);
				}
				link.update();
			}
		}
		r.removeAllFromSelectionList();
		gek.getSlot().notifyObservers(NotificationObserver.DELETE, null);

	}

	@Override
	public void doCommand() {
		if (firstAction) {
			firstAction = false;
		}else{
			r.addToSelectionList(moved);
			for(Element e: moved){
				if (e instanceof GraphicShape ){
					GraphicShape device=(GraphicShape) e;
					Point2D newPosition = (Point2D)device.getPosition().clone();
					newPosition.setLocation(newPosition.getX() + x,newPosition.getY() + y); 
					device.setPosition(newPosition);

				}else if (e instanceof LinkElement) {
					LinkElement link = (LinkElement)e;
					
					for(int i = 0; i < link.getPoints().size(); i++){
						link.getPoints().get(i).setLocation(link.getPoints().get(i).getX() + x, link.getPoints().get(i).getY()+y);
					}
					link.update();
				}
			}
			r.removeAllFromSelectionList();
			gek.getSlot().notifyObservers(NotificationObserver.DELETE, null);
		}
	}

}
