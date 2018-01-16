package gui.listeners.tree;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.commands.Invoker;
import gui.commands.TreeSelectCommand;
import gui.model.MainModel;
import gui.model.tree.Node;
import gui.view.tree.dialogs.ChooseDocumentDialog;

public class DocumentDoubleClickListener implements MouseListener {

	private MainModel model;
	private ChooseDocumentDialog view;
	
	public DocumentDoubleClickListener(MainModel model, ChooseDocumentDialog view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() >= 2) {
			Node selected = view.getSelected().get(0);
			
			model.getFreeDocuments().remove(selected);
			model.doReloadFreeDocuments();
			view.getParentNode().addChild(selected);
			model.getTreeModel().reload();
			
			Invoker.getInstance().executeCommand(new TreeSelectCommand(model, selected));
			view.dispose();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}