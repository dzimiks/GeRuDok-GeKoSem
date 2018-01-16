package gui.controller.tree;

import gui.listeners.tree.ProjectBtnOkListener;
import gui.listeners.tree.ProjectDoubleClickListener;
import gui.listeners.tree.ProjectSelectionChangedListener;
import gui.model.MainModel;
import gui.view.tree.dialogs.ChooseProjectDialog;


public class ChooseProjectDialogController {

	private MainModel model;
	private ChooseProjectDialog view;

	public ChooseProjectDialogController(MainModel model, ChooseProjectDialog view) {
		this.model = model;
		this.view = view;

		this.view.addSelectionChangedListener(new ProjectSelectionChangedListener(view));
		this.view.addBtnOkListener(new ProjectBtnOkListener(model, view));
		this.view.addDoubleClickListener(new ProjectDoubleClickListener(model, view));
	}
}