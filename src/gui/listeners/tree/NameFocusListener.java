package gui.listeners.tree;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import gui.view.tree.TreeCellEditor;

/**
 * Listener za promenu imena cvora iz stabla pri promeni fokusa.
 * 
 * @author Vanja Paunovic
 *
 */
public class NameFocusListener implements FocusListener {

	private TreeCellEditor view;
	
	public NameFocusListener(TreeCellEditor view) {
		this.view = view;
	}
	
	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		view.getNode().setName(view.getNameText());
	}
}