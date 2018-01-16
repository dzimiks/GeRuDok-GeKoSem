package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.view.tree.dialogs.RenameDialog;


public class RenameDialogCancelListener implements ActionListener {

	private RenameDialog dialog;
	
	public RenameDialogCancelListener(RenameDialog dialog) {
		this.dialog = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dialog.setVisible(false);
	}
}