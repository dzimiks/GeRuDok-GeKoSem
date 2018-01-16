package gui.model;

import java.io.Serializable;

import gui.model.tree.Node;

public abstract class Element extends Node implements Serializable {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;
	
	private String name;
	
	public Element() {
		super();
	}
	
	public Element(String name) {
		super(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}