package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.commands.Invoker;
import gui.commands.SaveProjectCommand;
import gui.model.MainModel;
import gui.view.tree.TreePopupMenu;


public class SaveProjectListener implements ActionListener {

	private MainModel model;
	private TreePopupMenu popupMenu;
	
	public SaveProjectListener(MainModel model, TreePopupMenu popupMenu) {
		this.model = model;
		this.popupMenu = popupMenu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Invoker.getInstance().executeCommand(new SaveProjectCommand(model, popupMenu.getSelectedNode()));
	}
}