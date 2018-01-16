package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.commands.Invoker;
import gui.commands.SaveWorkspaceCommand;
import gui.model.MainModel;


public class SaveWorkspaceListener implements ActionListener {

	private MainModel model;
	
	public SaveWorkspaceListener(MainModel model) {
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Invoker.getInstance().executeCommand(new SaveWorkspaceCommand(model));
	}
}