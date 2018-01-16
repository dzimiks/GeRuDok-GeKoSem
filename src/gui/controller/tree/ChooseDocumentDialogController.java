package gui.controller.tree;

import gui.listeners.tree.DocumentBtnOkListener;
import gui.listeners.tree.DocumentDoubleClickListener;
import gui.listeners.tree.DocumentSelectionChangedListener;
import gui.model.MainModel;
import gui.view.tree.dialogs.ChooseDocumentDialog;

public class ChooseDocumentDialogController {

	private MainModel model;
	private ChooseDocumentDialog view;

	public ChooseDocumentDialogController(MainModel model, ChooseDocumentDialog view) {
		this.model = model;
		this.view = view;
		
		this.view.addSelectionChangedListener(new DocumentSelectionChangedListener(view));
		this.view.addBtnOkListener(new DocumentBtnOkListener(model, view));
		this.view.addDoubleClickListener(new DocumentDoubleClickListener(model, view));
	}
}