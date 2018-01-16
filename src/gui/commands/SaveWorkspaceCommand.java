package gui.commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import gui.constants.Constants;
import gui.files.WorkspaceFile;
import gui.model.MainModel;
import gui.model.Project;
import gui.model.Workspace;
import gui.model.tree.Node;
import gui.view.MainView;


public class SaveWorkspaceCommand extends Command {

	public SaveWorkspaceCommand(MainModel model) {
		this.model = model;
	}

	@Override
	public void doCommand() {
		
		Workspace workspace = Workspace.getInstance();
		JFileChooser jfc = new JFileChooser();
		
		jfc.setFileFilter(new WorkspaceFile());
		jfc.setAcceptAllFileFilterUsed(false);
		
		if (workspace != null) {
			File workspaceFile = workspace.getWorkspaceFile();
		
			if (workspaceFile == null) {
				if (jfc.showSaveDialog(MainView.getInstance()) == JFileChooser.APPROVE_OPTION) {
					workspaceFile = jfc.getSelectedFile();
					String o = workspaceFile.getPath();
					
					if (!o.endsWith(Constants.WORKSPACE_EXTENSION)) {
						o += Constants.WORKSPACE_EXTENSION;
						workspaceFile.delete();
						workspaceFile = new File(o);
					}
				} 
				else return;
			}

			for (Node p : workspace.getChildren()) {
				if (((Project) p).getProjectFile() == null) 
					JOptionPane.showMessageDialog(MainView.getInstance(),
							"Unsaved project " + p.getName() + ". You must save it first.");
				
				Invoker.getInstance().executeCommand(new SaveProjectCommand(model, p));
			}

			BufferedWriter os;
			try {
				os = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(workspaceFile)));
				
				for (Node p : workspace.getChildren()) {
					if (((Project) p).getProjectFile() != null) 
						os.write(((Project) p).getProjectFile().getAbsolutePath());
					
					os.newLine();
				}
				
				workspace.setWorkspaceFile(workspaceFile);
				os.close();
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
