package gui.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import gui.constants.Constants;
import gui.controller.ToolBarController;
import gui.model.MainModel;

public class ToolBarView extends JToolBar {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;
	
	public MainModel model;
	public ToolBarController toolBarControler;

	public ToolBarView(MainModel model) {
		
		this.model = model;
		toolBarControler = new ToolBarController(model, this);
		
		JButton newWorkspace = new JButton();
		newWorkspace.setToolTipText("New workspace");
		newWorkspace.setIcon(new ImageIcon("images/menu-icons/workspace.png"));
		newWorkspace.addActionListener(toolBarControler.getNewWorkspaceActionListener());
		
		JButton switchWorkspace = new JButton();
		switchWorkspace.setToolTipText("Switch workspace");
		switchWorkspace.setIcon(new ImageIcon(Constants.SWITCH_WORKSPACE));
		switchWorkspace.addActionListener(toolBarControler.getSwitchWorkspaceListener());
		
		JButton openProject = new JButton();
		openProject.setToolTipText("Open project");
		openProject.setIcon(new ImageIcon(Constants.OPEN_PROJECT));
		openProject.addActionListener(toolBarControler.getOpenProjectActionListener());
		
		JButton addNode = new JButton();
		addNode.setToolTipText("Add");
		addNode.setIcon(new ImageIcon(Constants.ADD_ICON));
		addNode.addActionListener(toolBarControler.getAddChildListener());
		addNode.setEnabled(true);
		
		JButton renameNode = new JButton();
		renameNode.setToolTipText("Rename");
		renameNode.setIcon(new ImageIcon(Constants.RENAME_ICON));
		renameNode.addActionListener(toolBarControler.getRenameActionListener());
		
		JButton deleteNode = new JButton();
		deleteNode.setToolTipText("Delete");
		deleteNode.setIcon(new ImageIcon(Constants.DELETE_ICON));
		deleteNode.addActionListener(toolBarControler.getDeleteActionListener());
		
		JButton saveWorkspace = new JButton();
		saveWorkspace.setToolTipText("Save workspace");
		saveWorkspace.setIcon(new ImageIcon(Constants.SAVE_WORKSPACE));
		saveWorkspace.addActionListener(toolBarControler.getSaveWorkspaceListener());
		
		JButton saveProject = new JButton();
		saveProject.setToolTipText("Save project");
		saveProject.setIcon(new ImageIcon(Constants.SAVE_PROJECT));
		saveProject.addActionListener(toolBarControler.getSaveProjectActionListener());
		
		JButton closeProject = new JButton();
		closeProject.setToolTipText("Close project");
		closeProject.setIcon(new ImageIcon(Constants.CLOSE_PROJECT));
		closeProject.addActionListener(toolBarControler.getCloseProjectActionListener());
		
		JButton closeAll = new JButton();
		closeAll.setToolTipText("Close all");
		closeAll.setIcon(new ImageIcon(Constants.CLOSE_ALL_ICON));
		closeAll.addActionListener(toolBarControler.getCloseAllListener());
		
		JButton shareDocument = new JButton();
		shareDocument.setToolTipText("Share document");
		shareDocument.setIcon(new ImageIcon(Constants.SHARE_DOCUMENT));
		shareDocument.addActionListener(toolBarControler.getShareDocumentListener());
		
		JButton loadProject = new JButton();
		loadProject.setToolTipText("Load project");
		loadProject.setIcon(new ImageIcon(Constants.LOAD_PROJECT_ICON));
		loadProject.addActionListener(toolBarControler.getLoadProjectActionListener());
		
		/*
		JButton undo = new JButton();
		undo.setToolTipText("Undo");
		undo.setIcon(new ImageIcon(Constants.UNDO_ICON));
		
		JButton redo = new JButton();
		redo.setToolTipText("Redo");
		redo.setIcon(new ImageIcon(Constants.REDO_ICON));
		
		JButton cut = new JButton();
		cut.setToolTipText("Cut");
		cut.setIcon(new ImageIcon(Constants.CUT_ICON));
		
		JButton copy = new JButton();
		copy.setToolTipText("Copy");
		copy.setIcon(new ImageIcon(Constants.COPY_ICON));
		
		JButton paste = new JButton();
		paste.setToolTipText("Paste");
		paste.setIcon(new ImageIcon(Constants.PASTE_ICON));
		
		JButton rotateLeft = new JButton();
		rotateLeft.setToolTipText("Rotate left");
		rotateLeft.setIcon(new ImageIcon(Constants.ROTATE_LEFT_ICON));
		
		JButton rotateRight = new JButton();
		rotateRight.setToolTipText("Rotate right");
		rotateRight.setIcon(new ImageIcon(Constants.ROTATE_RIGHT_ICON));
		
		JButton zoomIn = new JButton();
		zoomIn.setToolTipText("Zoom in");
		zoomIn.setIcon(new ImageIcon(Constants.ZOOM_IN_ICON));
		
		JButton zoomOut = new JButton();
		zoomOut.setToolTipText("Zoom out");
		zoomOut.setIcon(new ImageIcon(Constants.ZOOM_OUT_ICON));
		
		JButton bestFitZoom = new JButton();
		bestFitZoom.setToolTipText("Best fit zoom");
		bestFitZoom.setIcon(new ImageIcon(Constants.BEST_FIT_ZOOM_ICON));
		*/
		JButton cascade = new JButton();
		cascade.setToolTipText("Cascade");
		cascade.setIcon(new ImageIcon(Constants.CASCADE_ICON));
		cascade.addActionListener(toolBarControler.getCascadeActionListener());
		
		JButton tileVerticaly = new JButton();
		tileVerticaly.setToolTipText("Tile verticaly");
		tileVerticaly.setIcon(new ImageIcon(Constants.TILE_VERTICALLY_ICON));
		tileVerticaly.addActionListener(toolBarControler.getTileVerticallyActionListener());
		
		JButton tileHorizontaly = new JButton();
		tileHorizontaly.setToolTipText("Tile horizontaly");
		tileHorizontaly.setIcon(new ImageIcon(Constants.TILE_HORIZONTALLY_ICON));
		tileHorizontaly.addActionListener(toolBarControler.getTileHorizontallyActionListener());
		
		add(newWorkspace);
		add(switchWorkspace);
		add(loadProject);
		addSeparator();
		add(addNode);
		add(renameNode);
		add(deleteNode);
		addSeparator();
		add(saveWorkspace);
		add(saveProject);
		add(shareDocument);
		addSeparator();
		add(openProject);
		add(closeProject);
		add(closeAll);
		addSeparator();
		/*add(undo);
		add(redo);
		addSeparator();
		add(cut);
		add(copy);
		add(paste);
		addSeparator();
		add(rotateLeft);
		add(rotateRight);
		addSeparator();
		add(zoomIn);
		add(zoomOut);
		add(bestFitZoom);
		addSeparator();*/
		add(cascade);
		add(tileVerticaly);
		add(tileHorizontaly);
		
		setFloatable(false);
		setBackground(new Color(192, 192, 192));
	}
}