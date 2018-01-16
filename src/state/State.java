package state;

import java.awt.Color;
import java.awt.event.MouseEvent;

public abstract class State {
	
	public Color color;
	public abstract void mousePressed(MouseEvent e);
	public abstract void mouseDragged(MouseEvent e);
	public abstract void mouseReleased(MouseEvent e);
	public abstract void mouseMoved(MouseEvent e);
}