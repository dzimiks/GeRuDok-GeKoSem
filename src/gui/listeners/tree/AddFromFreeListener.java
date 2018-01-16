package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.model.MainModel;
import gui.view.tree.TreePopupMenu;
import gui.view.tree.dialogs.ChooseDocumentDialog;

public class AddFromFreeListener implements ActionListener {

	private MainModel model;
	private TreePopupMenu popupMenu;
	
	public AddFromFreeListener(MainModel model, TreePopupMenu popupMenu) {
		this.model = model;
		this.popupMenu = popupMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ChooseDocumentDialog sd = new ChooseDocumentDialog(model, popupMenu.getSelectedNode());
		sd.setVisible(true);
	}
}