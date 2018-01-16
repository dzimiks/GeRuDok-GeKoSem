package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import gui.commands.Invoker;
import gui.commands.TreeSelectCommand;
import gui.model.MainModel;
import gui.model.tree.Node;
import gui.view.tree.dialogs.ChooseDocumentDialog;

public class DocumentBtnOkListener implements ActionListener {

	private MainModel model;
	private ChooseDocumentDialog view;
	
	public DocumentBtnOkListener(MainModel model, ChooseDocumentDialog view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		List<Node> selected = view.getSelected();

		for (Node node : selected) {
			model.getFreeDocuments().remove(node);
			model.doReloadFreeDocuments();
			view.getParentNode().addChild(node);
			model.getTreeModel().reload();
		}

		Invoker.getInstance().executeCommand(new TreeSelectCommand(model, selected.get(0)));
		view.dispose();
	}
}