package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.commands.AddTextElementCommand;
import gui.commands.Invoker;
import gui.model.MainModel;

public class AddTextElementListener implements ActionListener {

	private MainModel model;
	
	public AddTextElementListener(MainModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Invoker.getInstance().executeCommand(new AddTextElementCommand(model));
	}
}