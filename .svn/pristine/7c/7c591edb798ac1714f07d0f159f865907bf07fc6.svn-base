package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.commands.Invoker;
import gui.commands.SwitchWorkspaceCommand;
import gui.model.MainModel;

public class SwitchWorkspaceListener implements ActionListener {

	private MainModel model;
	
	public SwitchWorkspaceListener(MainModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Invoker.getInstance().executeCommand(new SwitchWorkspaceCommand(model));
	}
}