package gui.commands;

import gui.model.MainModel;

/**
 * Apstraktna klasa Command. Superklasa za sve komande.
 * 
 * @author Vanja Paunovic
 *
 */
public abstract class Command {

	protected MainModel model;
	
	public abstract void doCommand();
}