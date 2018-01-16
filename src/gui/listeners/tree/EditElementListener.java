package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gekosem.Gekosem;
import gui.commands.Invoker;
import gui.commands.TreeSelectCommand;
import gui.model.ElementType;
import gui.model.MainModel;
import gui.model.Slot;
import gui.view.tree.TreePopupMenu;
import textEditor.EditorView;

public class EditElementListener implements ActionListener {

	private MainModel model;
	private TreePopupMenu popupMenu;
	
	public EditElementListener(MainModel model, TreePopupMenu popupMenu) {
		this.model = model;
		this.popupMenu = popupMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Slot node = (Slot) model.getSelectedObject();
			ElementType currentSlotType = node instanceof Slot ? ((Slot) node).getType() : null;
			Gekosem graphicEditor;
			EditorView textEditor;
			
			if (currentSlotType == null) {
				popupMenu.setEdit(false);
				model.getTreeModel().reload();
			}
			else if (currentSlotType.equals(ElementType.GRAPHIC)) {
				popupMenu.setEdit(true);
				graphicEditor = new Gekosem(node);
				graphicEditor.setVisible(true);
				model.getTreeModel().reload();
				Invoker.getInstance().executeCommand(new TreeSelectCommand(model, node));
			}
			else if (currentSlotType.equals(ElementType.TEXT)) {
				popupMenu.setEdit(true);
				textEditor = new EditorView(node);
				textEditor.setVisible(true);
				model.getTreeModel().reload();
				Invoker.getInstance().executeCommand(new TreeSelectCommand(model, node));
			}
		}
		catch (ClassCastException ex1) {
			ex1.printStackTrace();
		}
		catch (NullPointerException ex2) {
			ex2.printStackTrace();
		}
	}
}