package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.commands.AddLinkNodeCommand;
import gui.commands.Invoker;
import gui.model.MainModel;
import gui.model.tree.Node;
import gui.view.tree.dialogs.ChooseProjectDialog;

public class ProjectBtnOkListener implements ActionListener {

	private MainModel model;
	private ChooseProjectDialog view;
	
	public ProjectBtnOkListener(MainModel model, ChooseProjectDialog view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		for (Node node : view.getSelected()) 
			Invoker.getInstance().executeCommand(new AddLinkNodeCommand(model, node, view.getShared()));

		view.dispose();
	}
}