package gui.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import gekosem.Gekosem;
import gui.Main;
import gui.view.MainView;
import state.StateManager;

public class PaletteController extends MouseAdapter implements MouseMotionListener{

	private AffineTransform transform;
	private StateManager currentStateManager;
	
	
	public PaletteController(AffineTransform transform, StateManager currentStateManager) {
		super();
		this.transform = transform;
		this.currentStateManager = currentStateManager;
	}


	public void mousePressed(MouseEvent e){
		//Point2D lastPosition = e.getPoint();
		//transformToUser();
		//MainView.getInstance().getStatusBar().setElementName(currentStateManager.getCurrentState().getName());
		//MainView.getInstance().getStatusBar().setState(currentStateManager.getCurrentState().getStateName());
		currentStateManager.getCurrentState().mousePressed(e);

	}

	public void mouseReleased(MouseEvent e){
		currentStateManager.getCurrentState().mouseReleased(e);
	}
	
	public void mouseDragger(MouseEvent e){
		currentStateManager.getCurrentState().mouseDragged(e);
	}
	
	
	public void mouseWheelMoved(MouseWheelEvent e){
		
	}
	
	
	public void transformToUser(Point2D p){
		try {
			transform.inverseTransform(p, p);
		} catch (NoninvertibleTransformException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ActionListener getChangeStatusBarListener(int button){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (button) {
				case 1:
					MainView.getInstance().getStatusBar().setState("Select element");
					MainView.getInstance().getStatusBar().setElementType("Action");
					break;
				case 2:
					MainView.getInstance().getStatusBar().setState("Move element");
					MainView.getInstance().getStatusBar().setElementType("Action");
					break;
				case 3:
					MainView.getInstance().getStatusBar().setState("Select multiple elements");
					MainView.getInstance().getStatusBar().setElementType("Action");
					break;
				case 4:
					MainView.getInstance().getStatusBar().setState("Add AND Gate");
					MainView.getInstance().getStatusBar().setElementType("AND Gate");
					break;
				case 5:
					MainView.getInstance().getStatusBar().setState("Add OR Gate");
					MainView.getInstance().getStatusBar().setElementType("OR Gate");
					break;
				case 6:
					MainView.getInstance().getStatusBar().setState("Add NOR Gate");
					MainView.getInstance().getStatusBar().setElementType("NOT Gate");
					break;
				case 7:
					MainView.getInstance().getStatusBar().setState("Add LINK");
					MainView.getInstance().getStatusBar().setElementType("LINK");
					break;
				default:
					break;
				}
			}
		};
	}


	
}
