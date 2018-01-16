package gui.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;

import gui.constants.Constants;
import gui.files.ProjectFile;
import gui.model.MainModel;
import gui.model.Project;
import gui.model.tree.Node;
import gui.view.MainView;

public class SaveProjectCommand extends Command {

	private Project project;
	
	public SaveProjectCommand(MainModel model) {
		this(model, model.getSelectedObject());
	}
	
	public SaveProjectCommand(MainModel model, Object object) {
		this.model = model;
		this.project = (object instanceof Project) ? (Project) object : null;
	}
	
	 public SaveProjectCommand(Node node) {
		 if(node instanceof Project)
			 this.project = (Project)node;
		 else
			 this.project = null;
	 }
	 
	@Override
	public void doCommand() {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new ProjectFile());
		jfc.setAcceptAllFileFilterUsed(false);
		
		if (project != null) {
			File projectFile = project.getProjectFile();
		
			if (projectFile == null) {
				if (jfc.showSaveDialog(MainView.getInstance()) == JFileChooser.APPROVE_OPTION) {
					projectFile = jfc.getSelectedFile();
					String output = projectFile.getPath();
					
					if (!output.endsWith(Constants.PROJECT_EXTENSION)) {
						output += Constants.PROJECT_EXTENSION;
						projectFile.delete();
						projectFile = new File(output);
					}
				} 
				else return;
			}
			
			ObjectOutputStream os;
			
			try {
				os = new ObjectOutputStream(new FileOutputStream(projectFile));
				os.writeObject(project);
				project.setProjectFile(projectFile);
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