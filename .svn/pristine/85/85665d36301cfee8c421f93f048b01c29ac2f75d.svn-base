package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.commands.Invoker;
import gui.commands.LoadProjectCommand;
import gui.model.MainModel;

public class LoadProjectListener implements ActionListener {

	private MainModel model;
	
	public LoadProjectListener(MainModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Invoker.getInstance().executeCommand(new LoadProjectCommand(model));
	}
}