package gui.listeners.tree;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.commands.AddLinkNodeCommand;
import gui.commands.Invoker;
import gui.model.MainModel;
import gui.view.tree.dialogs.ChooseProjectDialog;

public class ProjectDoubleClickListener implements MouseListener {

	private MainModel model;
	private ChooseProjectDialog view;
	
	public ProjectDoubleClickListener(MainModel model, ChooseProjectDialog view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() >= 2) {
			Invoker.getInstance().executeCommand(new AddLinkNodeCommand(model, view.getSelected().get(0), view.getShared()));
			view.dispose();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}