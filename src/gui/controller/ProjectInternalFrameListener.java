package gui.controller;

import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import gui.commands.Invoker;
import gui.commands.TreeSelectCommand;
import gui.model.MainModel;
import gui.view.ProjectView;

public class ProjectInternalFrameListener implements InternalFrameListener {

	private MainModel model;
	private ProjectView projectView;
	
	public ProjectInternalFrameListener(MainModel model, ProjectView projectView) {
		this.model = model;
		this.projectView = projectView;
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		Invoker.getInstance().executeCommand(new TreeSelectCommand(model, projectView.getProject()));
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {

	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {

	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {

	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		projectView.getProject().setOpened(true);
		model.getTreeModel().reload();
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		projectView.getProject().setOpened(false);
		model.getTreeModel().reload();
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {

	}
}