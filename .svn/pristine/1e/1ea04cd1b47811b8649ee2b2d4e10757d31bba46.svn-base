package gui.commands;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;

import gui.files.WorkspaceFile;
import gui.model.MainModel;
import gui.model.Workspace;
import gui.view.MainView;


public class SwitchWorkspaceCommand extends Command {

	public SwitchWorkspaceCommand(MainModel model) {
		this.model = model;
	}

	@Override
	public void doCommand() {
		JFileChooser jfc = new JFileChooser();
		Workspace workspace = Workspace.getInstance();
		
		jfc.setFileFilter(new WorkspaceFile());
		jfc.setAcceptAllFileFilterUsed(false);
		
		if (jfc.showOpenDialog(MainView.getInstance()) == JFileChooser.APPROVE_OPTION) {
			workspace.clearChildren();
			model.getTreeModel().reload();
			BufferedReader br;
			
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(jfc.getSelectedFile())));
				String line;
			
				while ((line = br.readLine()) != null) 
					Invoker.getInstance().executeCommand(new LoadProjectCommand(model, line.trim()));
				
				workspace.setWorkspaceFile(jfc.getSelectedFile());
				br.close();
			}
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
}