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
import gui.view.MainView;

public class SaveProjectAsCommand extends Command {

	private Project project;
	
	public SaveProjectAsCommand(MainModel model) {
		this(model, model.getSelectedObject());
	}
	
	public SaveProjectAsCommand(MainModel model, Object object) {
		this.model = model;
		this.project = (object instanceof Project) ? (Project) object : null;
	}
	
	@Override
	public void doCommand() {
		Object object = model.getSelectedObject();
		Project project = (object instanceof Project) ? (Project) object : null;
		
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new ProjectFile());
		jfc.setAcceptAllFileFilterUsed(false);
		
		if (project != null) {
			
			File projectFile;
			
			if (jfc.showSaveDialog(MainView.getInstance()) == JFileChooser.APPROVE_OPTION) {
				projectFile = jfc.getSelectedFile();
				String o = projectFile.getPath();
				
				if (!o.endsWith(Constants.PROJECT_EXTENSION)) {
					o += Constants.PROJECT_EXTENSION;
					projectFile.delete();
					projectFile = new File(o);
				}
			} else {
				return;
			}
			ObjectOutputStream os;
			try {
				os = new ObjectOutputStream(new FileOutputStream(projectFile));
				
				os.writeObject(project);
				
				project.setProjectFile(projectFile);
				os.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

}
