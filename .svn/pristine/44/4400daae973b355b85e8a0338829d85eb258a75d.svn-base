package gui.commands;

import gui.model.MainModel;
import gui.model.tree.Node;

public class AddLinkNodeCommand extends Command {

	private Node node;
	private Node sharedNode;
	
	public AddLinkNodeCommand(MainModel model, Node node, Node sharedNode) {
		this.model = model;
		this.node = node;
		this.sharedNode = sharedNode;
	}
	
	@Override
	public void doCommand() {
		Node child = node.addNewLinkChild(sharedNode);
		model.getTreeModel().reload();
		Invoker.getInstance().executeCommand(new TreeSelectCommand(model, child));
	}
}