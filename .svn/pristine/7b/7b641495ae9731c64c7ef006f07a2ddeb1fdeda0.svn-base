package gui.commands;

import gekosem.Gekosem;
import gui.model.ElementType;
import gui.model.MainModel;
import gui.model.Slot;

public class AddGraphicElementCommand extends Command {

	public AddGraphicElementCommand(MainModel model) {
		this.model = model;
	}
	
	@Override
	public void doCommand() {
		try {
			Slot selected = (Slot) model.getSelectedObject();
			Gekosem graphicEditor = new Gekosem((Slot) model.getSelectedObject());

			selected.setType(ElementType.GRAPHIC);
			graphicEditor.setVisible(true);
			model.getTreeModel().reload();
			Invoker.getInstance().executeCommand(new TreeSelectCommand(model, selected));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}