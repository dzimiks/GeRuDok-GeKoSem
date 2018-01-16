package state;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import gekosem.AndElement;
import gekosem.Gekosem;
import gekosem.Gekosem.Handle;
import gekosem.GraphicElement;
import gekosem.GraphicShape;
import gekosem.NotElement;
import gekosem.OrElement;
import gui.Main;
import gui.commands.Invoker;
import gui.commands.TreeSelectCommand;
import gui.model.Element;
import gui.model.MainModel;
import gui.observer.NotificationObserver;
import gui.view.MainView;

public class SelectState extends State {

	private Gekosem med;
	private Handle handleInMotion = null;
	private int elementInMotion = -1;
	private int mouse = 0;
	private Color color;

	public SelectState(Gekosem med) {
		super();
		this.med = med;
		// this.color = med.getColor();
	}

	@Override
	public void mousePressed(MouseEvent e) {

		mouse = e.getButton();
		Point position = e.getPoint();
		med.transformToUserSpace(position);

		if (mouse == MouseEvent.BUTTON1) {
			handleInMotion = med.getDeviceAndHandleForPoint(position);

			if (handleInMotion == null) {
				if (!e.isControlDown()) {
					med.getSlot().getSelectionModels().removeAllFromSelectionList();
				}

				elementInMotion = med.getSlot().getElementAtPosition(position);
				if (elementInMotion != -1) {
					// pogodjen je element, ukoliko je selektovan treba ga
					// ukloniti iz liste,
					// ako nije treba ga dodati u listu
//					System.out.println("AAAA");
					Element element = (Element) med.getSlot().getChildAt(elementInMotion);

					MainView.getInstance().getStatusBar().setDimension(((GraphicShape) element).getDimension());
					MainView.getInstance().getStatusBar().setElementName(element.getName());

					if (med.getSlot().getSelectionModels().isElementSelected(element)) {
						med.getSlot().getSelectionModels().removeFromSelectionList(element);
					} else {
						med.getSlot().getSelectionModels().addSelectionList(element);
					}
					med.getSlot().notifyObservers(NotificationObserver.ADD, null);
				} else {
					// nije pogodjen nijedan element
					med.getSlot().getSelectionModels().removeAllFromSelectionList();
					med.getSlot().notifyObservers(NotificationObserver.ADD, null);

				}
			} else {
				// pogodjen je handl nad nekim elementom, potrebno je raditi
				// resize elementa
				med.startResizeState();
			}

		}

		try {
			Invoker.getInstance().executeCommand(new TreeSelectCommand(MainModel.getInstance(), 
					med.getSlot().getSelectionModels().getSelectionList().get(0)));
			
		}
		catch (IndexOutOfBoundsException ex1) {
			
		}
		catch (NullPointerException ex2) {
			
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		MainView.getInstance().getStatusBar().setPosition("X:" + e.getX() + " Y: " + e.getY());

		if (mouse == MouseEvent.BUTTON1) {
			// vrši se povlačenje sa levim tasterom miša
			// provera da li je selektovan handle elementa, tada se radi resize
			// elementa
			Point position = e.getPoint();
			med.transformToUserSpace(position);
			handleInMotion = med.getDeviceAndHandleForPoint(position);
			if (handleInMotion != null) {
				med.startResizeState();
			} else {
				// nije selektovan handle, da li je selektovan element
				elementInMotion = med.getSlot().getElementAtPosition(position);
				if (elementInMotion != -1) {
					// selektovan je element ili grupa elemenata
					// preci u MoveState
					med.startMoveState();
					return;

				} else // nije pogodjen element, prelazimo u Laso stanje
					med.startLassoState();
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		Point2D position = e.getPoint();
		med.transformToUserSpace(position);
		med.setMouseCursor(position);
		MainView.getInstance().getStatusBar().setPosition("X:" + e.getX() + " Y: " + e.getY());

	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
