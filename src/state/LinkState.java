package state;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

import gekosem.Gekosem;
import gekosem.GraphicElement;
import gekosem.GraphicShape;
import gekosem.InputOutputElement;
import gekosem.LinkElement;
import gekosem.NotElement;
import gekosem.painter.LinkPainter;
import gui.model.MainModel;
import gui.observer.NotificationObserver;
import gui.view.MainView;
import gui.view.SlotView;

public class LinkState extends State {

	private Gekosem med;
	private LinkElement link;
	GraphicShape startDevice;
	GraphicShape endDevice;


	public LinkState(Gekosem med) {
		super();
		this.med = med;
	}


	@Override
	public void mousePressed(MouseEvent e) {
		
		MainView.getInstance().getStatusBar().setPosition("X:" + e.getX() + " Y: "+ e.getY());

		java.awt.Point position = e.getPoint();
		med.transformToUserSpace(position);
		if (e.getButton() == 1) {

			if (link == null) {
				int devicePos = med.getSlot().getElementAtPosition(position);
				if (devicePos != -1) {
					startDevice = (GraphicShape) med.getSlot().getChildAt(devicePos);

					InputOutputElement output = startDevice.getOut();

					link = ((LinkElement) LinkElement.defaultPaint(startDevice, output, med.getSlot().getChildCount()));

					med.getSlot().addChild(link);
					startDevice.setOutOk(true);
					// med.getDiagram().getModel().addDiagramElement(link);
				}
			} else {
				int devicePos = med.getSlot().getElementAtPosition(position);
				if (devicePos != -1) {
					endDevice = (GraphicShape) med.getSlot().getChildAt(devicePos);
					InputOutputElement input = null;
					if (endDevice == startDevice)
						return; // E pa ne moze na isti
					if (endDevice.isIn1Ok()) {
						input = endDevice.getIn1();
						endDevice.setIn1Ok(false);
					} else if (endDevice.isIn2ok() && !(endDevice instanceof NotElement)) {
						input = endDevice.getIn2();
						endDevice.setIn2ok(false);
					}else{
						return;
					}

					link.setEnd(endDevice);
					if (input != null) {
						link.setIn(input);
					}
					link.setPainter(new LinkPainter(link));
					MainModel.getInstance().getTreeModel().reload();
					med.getSlot().notifyObservers(NotificationObserver.ADD, null);
					link = null;
				} else {
					link.addPoint(position);
				}

			}
		} else if (e.getButton() == 3) {

			if (link != null) {
				med.getSlot().getChildren().remove(link);
				med.getSlot().notifyObservers(NotificationObserver.ADD, null);
				link = null;
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		MainView.getInstance().getStatusBar().setPosition("X:" + e.getX() + " Y: "+ e.getY());
		
		if (link != null) {
			
			Point position = e.getPoint();
			med.transformToUserSpace(position);

			link.getLastPoint().setLocation(position);
			link.setPainter(new LinkPainter(link));
			med.getSlot().notifyObservers(NotificationObserver.ADD, null);
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Point position = e.getPoint();
		med.transformToUserSpace(position);
		if (link == null) {
			return;
		}

		if (e.getButton() == 1) {
			int devicePos = med.getSlot().getElementAtPosition(position);
			if (devicePos != -1) {
				endDevice = (GraphicShape) med.getSlot().getChildAt(devicePos);

				InputOutputElement input;
				if (endDevice == startDevice)
					return; // E pa ne moze na isti
				if (endDevice.isIn1Ok()) {
					input = endDevice.getIn1();
					endDevice.setIn1Ok(false);
				} else if (endDevice.isIn2ok() && !(endDevice instanceof NotElement)) {
					input = endDevice.getIn2();
					endDevice.setIn2ok(false);
				}else{
					return;
				}
				link.setEnd(endDevice);
				if (input != null) {
					link.setIn(input);
				}
				link.setPainter(new LinkPainter(link));
				med.getSlot().notifyObservers(NotificationObserver.ADD, null);
				link = null;
			} else {
			link.addPoint(position);
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		MainView.getInstance().getStatusBar().setPosition("X:" + e.getX() + " Y: "+ e.getY());
		
		if (link != null) {
			Point position = e.getPoint();
			med.transformToUserSpace(position);

			link.getLastPoint().setLocation(position);
			link.setPainter(new LinkPainter(link));
			med.getSlot().notifyObservers(NotificationObserver.ADD, null);
		}

	}



}
