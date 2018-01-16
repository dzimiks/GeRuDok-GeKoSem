package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.model.MainModel;
import gui.model.tree.Node;
import gui.view.tree.dialogs.ChooseProjectDialog;

public class ShareDocumentListener implements ActionListener {

	private MainModel model;
	
	public ShareDocumentListener(MainModel model) {
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ChooseProjectDialog sd = new ChooseProjectDialog(model, (Node) model.getSelectedObject());
		sd.setVisible(true);
	}
}