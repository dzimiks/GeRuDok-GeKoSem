package gui.commands;

import gui.model.MainModel;
import gui.model.Project;
import gui.model.tree.Node;

public class OpenProjectCommand extends Command {

	public Node node;
	
	public  OpenProjectCommand(MainModel model, Node node) {
		this.model = model;
		this.node = node;
	}
	
	@Override
	public void doCommand() {
		try{
			Project project = (Project) model.getSelectedObject();
			project.doProjectOpen();
			project.setOpened(true);
			this.model.getTreeModel().reload();
		}
		catch (NullPointerException e) {
			
		}
	}
}
