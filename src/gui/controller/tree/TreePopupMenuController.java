package gui.controller.tree;

import gui.listeners.tree.AddFromFreeListener;
import gui.listeners.tree.AddGraphicElementListener;
import gui.listeners.tree.AddNodeListener;
import gui.listeners.tree.AddTextElementListener;
import gui.listeners.tree.DeleteNodeListener;
import gui.listeners.tree.EditElementListener;
import gui.listeners.tree.LoadProjectListener;
import gui.listeners.tree.OpenOrCloseProjectListener;
import gui.listeners.tree.RenameNodeListener;
import gui.listeners.tree.SaveProjectListener;
import gui.listeners.tree.SaveWorkspaceListener;
import gui.listeners.tree.ShareDocumentListener;
import gui.listeners.tree.SwitchWorkspaceListener;
import gui.model.MainModel;
import gui.view.tree.TreePopupMenu;

/**
 * Controller TreePopupMenu-a.
 * 
 * @author Vanja Paunovic
 *
 */
public class TreePopupMenuController {

	protected MainModel model;
	private TreePopupMenu popupMenu;
	
	public TreePopupMenuController(MainModel model, TreePopupMenu popupMenu) {
		this.model = model;
		this.popupMenu = popupMenu;
		
		this.popupMenu.setAddListener(new AddNodeListener(model, popupMenu));
		this.popupMenu.setDeleteListener(new DeleteNodeListener(model, popupMenu));
		this.popupMenu.setRenameListener(new RenameNodeListener(model, popupMenu));
		this.popupMenu.setOpenOrCloseProjectListener(new OpenOrCloseProjectListener(model, popupMenu));
		this.popupMenu.setShareDocumentListener(new ShareDocumentListener(model));
		this.popupMenu.setSaveProjectListener(new SaveProjectListener(model, popupMenu));
		this.popupMenu.setSaveWorkspaceListener(new SaveWorkspaceListener(model));
		this.popupMenu.setLoadProjectListener(new LoadProjectListener(model));
		this.popupMenu.setAddGraphicElementListener(new AddGraphicElementListener(model));
		this.popupMenu.setTextElementListener(new AddTextElementListener(model));
		this.popupMenu.setAddFromFreeListener(new AddFromFreeListener(model, popupMenu));
		this.popupMenu.setSwitchWorkspaceListener(new SwitchWorkspaceListener(model));
		this.popupMenu.setElementEditListener(new EditElementListener(model, popupMenu));
	}
}