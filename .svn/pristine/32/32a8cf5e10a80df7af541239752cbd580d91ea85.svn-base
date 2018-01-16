package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.commands.AddGraphicElementCommand;
import gui.commands.Invoker;
import gui.model.MainModel;

public class AddGraphicElementListener implements ActionListener {

	private MainModel model;
	
	public AddGraphicElementListener(MainModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Invoker.getInstance().executeCommand(new AddGraphicElementCommand(model));
	}
}