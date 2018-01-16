package gui.model;

import java.io.Serializable;

import gui.model.tree.Node;

/**
 * Cvor u stablu koji sadrzi stranice.
 * 
 * @author Vanja Paunovic
 *
 */
public class Document extends Node implements Serializable {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;
	
	private static int newChildCount = 1;
	private String name;

	public Document(String name) {
		super(name);
	}

	@Override
	public Node addNewChild() {
		Page child = new Page("Page " + newChildCount);
		newChildCount++;
		this.addChild(child);
		return child;
	}
}