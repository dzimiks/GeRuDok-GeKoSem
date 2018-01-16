package gui.listeners.tree;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.view.tree.dialogs.ChooseProjectDialog;


public class ProjectSelectionChangedListener implements ListSelectionListener {

	private ChooseProjectDialog view;
	
	public ProjectSelectionChangedListener(ChooseProjectDialog view) {
		this.view = view;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		view.enableBtnOk();
	}
}