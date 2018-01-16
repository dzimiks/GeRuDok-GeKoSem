package gui.listeners.tree;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.commands.Invoker;
import gui.commands.TreeSelectCommand;
import gui.model.MainModel;
import gui.view.DocumentView;

public class TabChangeListener implements ChangeListener {

	private MainModel model;
	
	public TabChangeListener(MainModel model) {
		this.model = model;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
		DocumentView documentView = (DocumentView) tabbedPane.getSelectedComponent();
		
		if (documentView != null) 
			Invoker.getInstance().executeCommand(new TreeSelectCommand(model, documentView.getDocument()));
	}
}