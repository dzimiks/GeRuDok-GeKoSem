package gui.view.tree;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import gui.constants.Constants;
import gui.model.Document;
import gui.model.Element;
import gui.model.Page;
import gui.model.Project;
import gui.model.Slot;
import gui.model.Workspace;

/**
 * Klasa koja renderuje i setuje ikonice Node-ova u WorkspaceTree.
 * 
 * @author Vanja Paunovic
 *
 */
public class TreeCellRendered extends DefaultTreeCellRenderer {

	/**
	 * VersionUID za serijalizaciju.
	 */
	
	private static final long serialVersionUID = 1;

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, 
												  boolean expanded, boolean leaf, int row, boolean hasFocus) {

		super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		
		String iconPath = null;
		Icon icon = null;
		
		// TODO zasto ovo ne radi kako treba
		if (value instanceof Workspace)
			iconPath = "/menu-icons/new-workspace.png";
		else if (value instanceof Project)
			iconPath = ((Project) value).isOpened() ? "/menu-icons/new-project-opened.png" : "/menu-icons/new-project-closed.png";
		else if (value instanceof Document)
			iconPath = "/menu-icons/new-document.png";
		else if (value instanceof Page)
			iconPath = "/menu-icons/new-page.png";
		else if (value instanceof Slot)
			iconPath = "/menu-icons/new-slot.png";
		else if (value instanceof Element)
			iconPath = "/menu-icons/new-element.png";

		try {
			if (iconPath != null) {
				icon = new ImageIcon(this.getClass().getResource(iconPath));
				this.setIcon(icon);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		this.setText(value.toString());
		
		return this;
	}
}