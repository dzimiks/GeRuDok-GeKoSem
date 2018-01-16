package gui.commands;

import gui.model.ElementType;
import gui.model.MainModel;
import gui.model.Slot;
import textEditor.EditorView;

public class AddTextElementCommand extends Command {

	public AddTextElementCommand(MainModel model) {
		this.model = model;
	}
	
	@Override
	public void doCommand() {
		try {
			Slot selected = (Slot) model.getSelectedObject();
			EditorView textEditor = new EditorView(selected);

			selected.setType(ElementType.TEXT);
			textEditor.setVisible(true);
			model.getTreeModel().reload();
			Invoker.getInstance().executeCommand(new TreeSelectCommand(model, selected));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}