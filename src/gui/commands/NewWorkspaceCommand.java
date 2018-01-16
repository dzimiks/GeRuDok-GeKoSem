package gui.commands;

import java.io.File;

import javax.swing.JFileChooser;

import gui.constants.Constants;
import gui.files.WorkspaceFile;
import gui.model.MainModel;
import gui.model.Workspace;
import gui.view.MainView;

public class NewWorkspaceCommand extends Command {

	public NewWorkspaceCommand(MainModel model) {
		this.model = model;
	}
	
	@Override
	public void doCommand() {
		
		JFileChooser jfc = new JFileChooser();
		Workspace workspace = Workspace.getInstance();
		
		jfc.setFileFilter(new WorkspaceFile());
		jfc.setAcceptAllFileFilterUsed(false);
		
		if (jfc.showSaveDialog(MainView.getInstance()) == JFileChooser.APPROVE_OPTION) {
			workspace.clearChildren();
			model.getTreeModel().reload();
			
			File workspaceFile = jfc.getSelectedFile();
			String output = workspaceFile.getPath();
			
			if (!output.endsWith(Constants.WORKSPACE_EXTENSION)) {
				output += Constants.WORKSPACE_EXTENSION;
				workspaceFile.delete();
				workspaceFile = new File(output);
			}
			
			workspace.setWorkspaceFile(workspaceFile);
		}
	}
}