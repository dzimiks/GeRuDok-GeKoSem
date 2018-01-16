package gui.listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import gui.commands.Invoker;
import gui.commands.SaveProjectCommand;
import gui.commands.SaveWorkspaceCommand;
import gui.model.MainModel;
import gui.model.Project;
import gui.model.Workspace;
import gui.model.tree.Node;

public class CloseApplicationListener implements WindowListener {

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		JOptionPane savePane = new JOptionPane();
		JOptionPane closePane = new JOptionPane();
		JFrame frame = (JFrame) e.getComponent();

		int answer = savePane.showConfirmDialog(null, "Do you want to save workspace?");

		if(answer == JOptionPane.YES_OPTION){
			Workspace w = (Workspace)MainModel.getInstance().getTreeModel().getRoot();
			
			Invoker.getInstance().executeCommand(new SaveWorkspaceCommand(MainModel.getInstance()));
			
				
			int answer2 = closePane.showConfirmDialog(frame, "Do you want to exit aplication ?", "Exit", JOptionPane.YES_NO_OPTION);
				if(answer == JOptionPane.YES_OPTION)
					frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
				else
					frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		}	
		else{
			int answer3 = closePane.showConfirmDialog(null, "Do you want to exit application?");
			if(answer3 == JOptionPane.YES_OPTION)
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
			else
				frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
