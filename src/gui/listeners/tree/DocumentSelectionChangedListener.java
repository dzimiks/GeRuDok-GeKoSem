package gui.listeners.tree;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.view.tree.dialogs.ChooseDocumentDialog;

public class DocumentSelectionChangedListener implements ListSelectionListener {

	private ChooseDocumentDialog view;
	
	public DocumentSelectionChangedListener(ChooseDocumentDialog view) {
		this.view = view;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		view.enableBtnOk();
	}
}