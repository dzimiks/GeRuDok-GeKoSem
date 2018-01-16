package state;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import gekosem.AndElement;
import gekosem.Gekosem;
import gekosem.commands.AddCommand;
import gui.model.Element;
import gui.observer.NotificationObserver;
import gui.view.MainView;

public class AndState extends State {

	private Gekosem med;
	private Paint color;

	public AndState(Gekosem med) {
		super();
		this.med = med;
	}


	@Override
	public void mousePressed(MouseEvent e) {
		
		Point position = e.getPoint();

		med.transformToUserSpace(position);

		if (e.getButton() == MouseEvent.BUTTON1) {
			if (med.getSlot().getElementAtPosition(position) == -1) {
				Element newElement = AndElement.defaultPaint(position, med.getSlot().getChildCount(), color);
				
				med.getGkm().addCommand(new AddCommand(newElement, med.getSlot()));
			}
			med.getSlot().notifyObservers(NotificationObserver.ADD, null);

		}
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		MainView.getInstance().getStatusBar().setPosition("X:" + e.getX() + " Y: "+ e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		MainView.getInstance().getStatusBar().setPosition("X:" + e.getX() + " Y: "+ e.getY());
		
	}
	
	
	public Paint getColor() {
		return color;
	}


	public void setColor(Color c) {
		this.color = c;
	}

}
