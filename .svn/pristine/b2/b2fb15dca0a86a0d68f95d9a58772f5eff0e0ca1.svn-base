package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.commands.CloseProjectCommand;
import gui.commands.Invoker;
import gui.commands.OpenProjectCommand;
import gui.model.MainModel;
import gui.model.Project;
import gui.view.tree.TreePopupMenu;


public class OpenOrCloseProjectListener implements ActionListener {

	private MainModel model;
	private TreePopupMenu popupMenu;
	
	public OpenOrCloseProjectListener(MainModel model, TreePopupMenu popupMenu) {
		this.model = model;
		this.popupMenu = popupMenu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Project project = (Project) popupMenu.getSelectedNode();
		
		if (project.isOpened()) 
			Invoker.getInstance().executeCommand(new CloseProjectCommand(model, project));
		else 
			Invoker.getInstance().executeCommand(new OpenProjectCommand(model, project));

		//model.getTreeModel().reload();
	}
}