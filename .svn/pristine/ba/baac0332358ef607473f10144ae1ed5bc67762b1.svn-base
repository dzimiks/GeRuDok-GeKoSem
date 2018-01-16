package gui.commands;

import gui.model.MainModel;
import gui.model.Project;
import gui.model.tree.Node;

public class CloseProjectCommand extends Command {

	public Node node;
	
	public  CloseProjectCommand(MainModel model, Node node) {
		this.model = model;
		this.node = node;
	}
	
	@Override
	public void doCommand() {
		// TODO Auto-generated method stub
		try{
			Project project = (Project) model.getSelectedObject();
			project.doProjectClose();
			project.setOpened(false);
			this.model.getTreeModel().reload();
		}
		catch (NullPointerException e) {
			
		}
	}

}
