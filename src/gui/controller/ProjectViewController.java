package gui.controller;

import gui.listeners.tree.TabChangeListener;
import gui.model.MainModel;
import gui.view.ProjectView;

public class ProjectViewController {

	private MainModel model;
	private ProjectView projectView;
	
	public ProjectViewController(MainModel model, ProjectView projectView) {
		this.model = model;
		this.projectView = projectView;
		projectView.addProjectInternalFrameListener(new ProjectInternalFrameListener(model, projectView));
		projectView.addTabChangeListener(new TabChangeListener(model));
	}

}