package gui.model;

import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

import gui.model.tree.Node;

/**
 * Cvor u stablu koji sadrzi slotove.
 * 
 * @author Vanja Paunovic
 *
 */
public class Page extends Node implements Serializable {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;

	private static int newChildCount = 1;
	private Color color;
	
	public Page(String name) {
		super(name);
		this.color = new Color(231,226,226);
	}

	@Override
	public Node addNewChild() {
		Slot child = new Slot("Slot " + newChildCount);
		newChildCount++;
		this.addChild(child);
		
		return child;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}