package gui.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import gui.files.ProjectFile;
import gui.model.MainModel;
import gui.model.Project;
import gui.model.Workspace;
import gui.model.tree.Node;
import gui.view.MainView;


public class LoadProjectCommand extends Command {

	private String loadFilePath;

	public LoadProjectCommand(MainModel model) {
		this.model = model;
		this.loadFilePath = null;
	}

	public LoadProjectCommand(MainModel model, String loadFilePath) {
		this.model = model;
		this.loadFilePath = loadFilePath;
	}

	@Override
	public void doCommand() {
		if (loadFilePath == null) {
			JFileChooser jfc = new JFileChooser();
			
			jfc.setFileFilter(new ProjectFile());
			jfc.setAcceptAllFileFilterUsed(false);

			if (jfc.showOpenDialog(MainView.getInstance()) == JFileChooser.APPROVE_OPTION) 
				loadProject(jfc.getSelectedFile());
		}
		else {
			File file = new File(loadFilePath);
		
			if (file.exists()) 
				loadProject(file);
		}
	}

	private void loadProject(File file) {

		for (Node p : Workspace.getInstance().getChildren()) {
			if (file.getAbsolutePath().equals(((Project) p).getProjectFile().getAbsolutePath())) {
				JOptionPane.showMessageDialog(MainView.getInstance(), "Project already opened!");
				return;
			}
		}

		try {
			ObjectInputStream os = new ObjectInputStream(new FileInputStream(file));
			Project p = null;

			try {
				p = (Project) os.readObject();
				p.initObserverList();
				p.setProjectFile(file);
			} 
			catch (ClassNotFoundException ee) {
				JOptionPane.showMessageDialog(MainView.getInstance(), "Error in file.");
			}

			Workspace.getInstance().addChild(p);
			model.getTreeModel().reload();
			Invoker.getInstance().executeCommand(new TreeSelectCommand(model, p));
			os.close();
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
