package gui.commands;

import javax.swing.JInternalFrame;

import gui.model.MainModel;
import gui.view.MainView;

public class CloseAllCommand extends Command {

	public CloseAllCommand(MainModel model) {
		this.model = model;
	}
	
	@Override
	public void doCommand() {
		JInternalFrame[] frames = MainView.getInstance().getDesktopView().getAllFrames();
		
		for (JInternalFrame frame : frames)
			frame.setVisible(false);
	}
}