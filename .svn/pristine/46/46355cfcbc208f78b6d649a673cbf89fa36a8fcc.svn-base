package gekosem.commands;

import java.util.ArrayList;

import javax.swing.JPanel;

import gekosem.Gekosem;
import gekosem.GraphicElement;
import gekosem.GraphicShape;
import gui.model.Element;
import gui.observer.NotificationObserver;

public class RotateCommand extends ElementCommand {

	private Gekosem gekosem;
	private ArrayList<Element> rotatedElements;
	private boolean direction;
	
	public RotateCommand(Gekosem gekosem, boolean direction) {
		this.gekosem = gekosem;
		this.direction = direction;
		this.rotatedElements = gekosem.getSlot().getSelectionModels().getSelectionList();
	}

	@Override
	public void doCommand() {
		GraphicShape shape;
		
		for (Element element : rotatedElements) {
			shape = (GraphicShape) element;
			
			if (direction)
				shape.setRotation(shape.getRotation() + Math.PI / 2);
			else
				shape.setRotation(shape.getRotation() - Math.PI / 2);
		}
		gekosem.repaint();
		gekosem.getSlot().notifyObservers(NotificationObserver.ADD, null);
	}

	@Override
	public void undoCommand() {
		GraphicShape shape;
		
		for (Element element : rotatedElements) {
			shape = (GraphicShape) element;
			
			if (direction)
				shape.setRotation(shape.getRotation() - Math.PI / 2);
			else
				shape.setRotation(shape.getRotation() + Math.PI / 2);
		}
		gekosem.repaint();
		gekosem.getSlot().notifyObservers(NotificationObserver.ADD, null);
	}
}