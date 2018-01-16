package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.commands.SaveWorkspaceCommand;
import gui.commands.SwitchWorkspaceCommand;
import gui.commands.LoadProjectCommand;
import gui.commands.AddNodeCommand;
import gui.commands.CloseAllCommand;
import gui.commands.CloseProjectCommand;
import gui.commands.DeleteNodeCommand;
import gui.commands.Invoker;
import gui.commands.OpenProjectCommand;
import gui.commands.NewWorkspaceCommand;
import gui.commands.RenameNodeCommand;
import gui.commands.SaveProjectCommand;
import gui.model.Document;
import gui.model.MainModel;
import gui.model.Project;
import gui.model.tree.Node;
import gui.view.ToolBarView;
import gui.view.tree.dialogs.ChooseProjectDialog;
import gui.view.MainView;

/**
 * Controller ToolBar-a.
 * 
 * @author Vanja Paunovic
 *
 */
public class ToolBarController {

	public MainModel model;
	public ToolBarView toolBarView;
	
	public ToolBarController(MainModel model, ToolBarView toolBarView) {
		super();
		this.model = model;
		this.toolBarView = toolBarView;
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
	
	public ActionListener getCloseAllListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Invoker.getInstance().executeCommand(new CloseAllCommand(model));
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
}