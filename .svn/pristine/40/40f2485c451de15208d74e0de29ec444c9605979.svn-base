package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.commands.AddNodeCommand;
import gui.commands.Invoker;
import gui.model.MainModel;
import gui.view.tree.TreePopupMenu;

/**
 * Listener za dodavanje novog cvora u stablo.
 * 
 * @author Vanja Paunovic
 *
 */
public class AddNodeListener implements ActionListener {

	private MainModel model;
	private TreePopupMenu popupMenu;
	
	public AddNodeListener(MainModel model, TreePopupMenu popupMenu) {
		this.model = model;
		this.popupMenu = popupMenu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Invoker.getInstance().executeCommand(new AddNodeCommand(model, popupMenu.getSelectedNode()));
	}
}