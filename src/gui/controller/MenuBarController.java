package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.commands.AddNodeCommand;
import gui.commands.CloseAllCommand;
import gui.commands.CloseProjectCommand;
import gui.commands.DeleteNodeCommand;
import gui.commands.Invoker;
import gui.commands.LoadProjectCommand;
import gui.commands.OpenProjectCommand;
import gui.commands.NewWorkspaceCommand;
import gui.commands.RenameNodeCommand;
import gui.commands.SaveProjectAsCommand;
import gui.commands.SaveProjectCommand;
import gui.commands.SaveWorkspaceCommand;
import gui.commands.SwitchWorkspaceCommand;
import gui.model.Document;
import gui.model.MainModel;
import gui.model.Project;
import gui.model.tree.Node;
import gui.view.AboutFrame;
import gui.view.MainView;
import gui.view.MenuBarView;
import gui.view.tree.dialogs.ChooseProjectDialog;

/**
 * Controller MenuBar-a.
 * 
 * @author Vanja Paunovic
 *
 */
public class MenuBarController {

	public MainModel model;
	public MenuBarView menuBarView;
	public AboutFrame aboutFrame;
	
	public MenuBarController(MainModel model, MenuBarView menuBarView) {
		super();
		this.model = model;
		this.menuBarView = menuBarView;
		this.aboutFrame = AboutFrame.getInstance();
	}
	
	public ActionListener getAddChildListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = model.getSelectedObject();
				
				if (obj != null)
					Invoker.getInstance().executeCommand(new AddNodeCommand(model, (Node) obj));
			}
		};
	}
	
	public ActionListener getDeleteActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = model.getSelectedObject();
				Invoker.getInstance().executeCommand(new DeleteNodeCommand(model, (Node) obj));
			}
		};
	}
	
	public ActionListener getRenameActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = model.getSelectedObject();
				Invoker.getInstance().executeCommand(new RenameNodeCommand(model, (Node) obj));
			}
		};
	}
	
	public ActionListener getAboutActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				aboutFrame.setVisible(true);
			}
		};
	}
	
	public ActionListener getCloseAllListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Invoker.getInstance().executeCommand(new CloseAllCommand(model));
			}
		};
		
	}
	
	public ActionListener getCloseProjectActionListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = model.getSelectedObject();
				if(obj instanceof Project)
					Invoker.getInstance().executeCommand(new CloseProjectCommand(model, (Node) obj));
			}
		};
		
	}
	
	public ActionListener getNewWorkspaceActionListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Invoker.getInstance().executeCommand(new NewWorkspaceCommand(model));
			}
		};
	}
	
	public ActionListener getSwitchWorkspaceListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Invoker.getInstance().executeCommand(new SwitchWorkspaceCommand(model));
			}
		};
	}
	
	public ActionListener getSaveWorkspaceListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Invoker.getInstance().executeCommand(new SaveWorkspaceCommand(model));
			}
		};
	}
	
	public ActionListener getOpenProjectActionListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = model.getSelectedObject();
				if(obj instanceof Project)
					Invoker.getInstance().executeCommand(new OpenProjectCommand(model, (Node) obj));
			}
		};
		
	}
	
	public ActionListener getShareDocumentListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Object obj = model.getSelectedObject();
				
				if (obj instanceof Document) {
					ChooseProjectDialog sd = new ChooseProjectDialog(model, (Node) obj);
					sd.setVisible(true);
				}
			}
		};
	}
	
	public ActionListener getTileVerticallyActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainView.getInstance().getDesktopView().tileVertically();
			}
		};
	}
	
	public ActionListener getTileHorizontallyActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainView.getInstance().getDesktopView().tileHorizontally();
			}
		};
	}
	
	public ActionListener getCascadeActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainView.getInstance().getDesktopView().cascade();
			}
		};
	}
	
	public ActionListener getSaveProjectActionListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = model.getSelectedObject();
				if(obj instanceof Project)
					Invoker.getInstance().executeCommand(new SaveProjectCommand(model, (Node) obj));
			}
		};
	}
	
	public ActionListener getLoadProjectActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Invoker.getInstance().executeCommand(new LoadProjectCommand(model));
			}
		};
	}

	public ActionListener getSaveProjectAsActionListener() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Invoker.getInstance().executeCommand(new SaveProjectAsCommand(model));
			}
		};
	}
}