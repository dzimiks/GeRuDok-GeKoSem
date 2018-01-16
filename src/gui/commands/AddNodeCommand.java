package gui.commands;

import gui.model.MainModel;
import gui.model.Slot;
import gui.model.tree.Node;

/**
 * Komanda koja dodaje novo dete cvoru i osvezava stablo.
 * 
 * @author Vanja Paunovic
 *
 */
public class AddNodeCommand extends Command {

	private Node node;
	
	public AddNodeCommand(MainModel model, Node node) {
		this.model = model;
		this.node = node;
	}
	
	@Override
	public void doCommand() {
		if (node instanceof Slot)
			return;

		Node child = this.node.addNewChild();
		model.getTreeModel().reload();
		Invoker.getInstance().executeCommand(new TreeSelectCommand(model, child));
	}
}