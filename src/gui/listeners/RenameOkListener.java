package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.view.tree.dialogs.RenameDialog;

public class RenameOkListener implements ActionListener{

	private RenameDialog dialog;
	
	public RenameOkListener(RenameDialog dialog) {
		this.dialog = dialog;
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		dialog.getElement().setName(dialog.getTfName());
		dialog.setVisible(false);
	}

}
