package gekosem.commands;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import gekosem.AndElement;
import gekosem.GraphicShape;
import gekosem.NotElement;
import gekosem.OrElement;
import gekosem.painter.AndPainter;
import gekosem.painter.NotPainter;
import gekosem.painter.OrPainter;
import gekosem.select.SlotSelectionModel;
import gui.model.Element;
import gui.model.Slot;

public class ResizeCommand extends ElementCommand {

	private Slot slot;
	boolean first;
	// reference na elemente modela koji su pomerani
	private ArrayList<Point2D> newElementsPositions = new ArrayList<>();
	private ArrayList<Point2D> oldElementsPositions = new ArrayList<>();
	private ArrayList<Double> newElementsScale = new ArrayList<>();
	private ArrayList<Double> oldElementsScale = new ArrayList<>();
	private ArrayList<Dimension> newDimensions = new ArrayList<>();
	private ArrayList<Dimension> oldDimensions = new ArrayList<>();

	// referenca na selekcioni model dijagrama služi za osvežavanje prikaza
	// view-a
	SlotSelectionModel tempSelectionModel = new SlotSelectionModel();
	// reference na elemente modela koji su pomerani
	ArrayList<Element> movedElements = new ArrayList<>();

	public ResizeCommand(Slot slot, ArrayList<Point2D> oldEP, ArrayList<Point2D> newEP, ArrayList<Double> oldES,
			ArrayList<Double> newES, ArrayList<Dimension> oldDi, ArrayList<Dimension> newDi) {
		this.slot = slot;
		for (int i = 0; i < slot.getSelectionModels().getSelectionListSize(); i++) {
			this.movedElements.add(slot.getSelectionModels().getElementFromSelectionListAt(i));

		}
		this.tempSelectionModel = slot.getSelectionModels();
		this.first = true;
		oldElementsPositions = (ArrayList<Point2D>) oldEP.clone();
		newElementsPositions = (ArrayList<Point2D>) newEP.clone();
		oldElementsScale = (ArrayList<Double>) oldES.clone();
		newElementsScale = (ArrayList<Double>) newES.clone();
		newDimensions = (ArrayList<Dimension>) newDi.clone();
		oldDimensions = (ArrayList<Dimension>) oldDi.clone();
		/*
		 * for(Point2D point : oldElementsPositions){ System.out.print("( " +
		 * point.getX() + "," + point.getY()+ " ) " ); } for(Point2D point :
		 * newElementsPositions){ System.out.print("( " + point.getX() + "," +
		 * point.getY()+ " ) " ); }
		 */
		// System.out.println(movedElements.size() + " " +
		// oldElementsPositions.size() + " " + newElementsPositions.size());
	}

	@Override
	public void doCommand() {
		if (first) {
			first = false;
			return;
		}
		tempSelectionModel.addToSelectionList((ArrayList<Element>) movedElements.clone());
		for (int i = 0; i < newElementsPositions.size(); i++) {
			Element element = tempSelectionModel.getElementFromSelectionListAt(i);
			if (element instanceof GraphicShape) {
				GraphicShape device = (GraphicShape) element;
				device.setPosition(newElementsPositions.get(i));
				device.setScale(newElementsScale.get(i));
				device.setSize(newDimensions.get(i));
				restart(device);
			}
		}
		tempSelectionModel.removeAllFromSelectionList();

	}

	@Override
	public void undoCommand() {
		tempSelectionModel.addToSelectionList((ArrayList<Element>) movedElements.clone());
		System.out.println("UNDOOOO");
		for (int i = 0; i < oldElementsPositions.size(); i++) {
			Element element = tempSelectionModel.getElementFromSelectionListAt(i);
			if (element instanceof GraphicShape) {
				GraphicShape device = (GraphicShape) element;
				device.setPosition(oldElementsPositions.get(i));
				device.setScale(oldElementsScale.get(i));
				device.setSize(oldDimensions.get(i));
				restart(device);
			}
		}
		tempSelectionModel.removeAllFromSelectionList();
	}
	private void restart(GraphicShape device){
		if(device instanceof AndElement){
			device.setPainter(new AndPainter(device));
		}else if (device instanceof NotElement){
			device.setPainter(new NotPainter(device));
		}else if (device instanceof OrElement){
			device.setPainter(new OrPainter(device));
		}
		if(device.getInput() == 2){
			 Point2D pos = new Point2D.Double(device.getPosition().getX(), device.getPosition().getY()+(device.getSize().getHeight()/3));
			 device.getIn1().setPosition(pos);
			 pos = new Point2D.Double(device.getPosition().getX(), device.getPosition().getY()+(2*device.getSize().getHeight()/3));
			 device.getIn2().setPosition(pos);
		 }else{
			 Point2D pos = new Point2D.Double(device.getPosition().getX(), device.getPosition().getY()+(device.getSize().getHeight()/3));
			 device.getIn1().setPosition(pos);
		 }
		 
		 Point2D pos = new Point2D.Double(device.getPosition().getX()+device.getSize().getWidth(), device.getPosition().getY()+(device.getSize().getHeight()/2));
		 device.getOut().setPosition(pos);
	}
}
