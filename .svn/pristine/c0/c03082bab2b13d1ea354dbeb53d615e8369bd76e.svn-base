package gui.commands;

import java.util.ArrayList;

import gui.model.Element;
import gui.model.MainModel;
import gui.model.Slot;
import gui.view.tree.dialogs.RenameDialog;

public class RenameElementCommand extends Command {

	private MainModel model;
	private Slot slot;
	
	public RenameElementCommand(MainModel model, Slot slot) {
		this.model = model;
		this.slot = slot;
	}
	
	@Override
	public void doCommand() {
		
		ArrayList<Element> elements = new ArrayList<>();
		for(Element e: slot.getSelectionModels().getSelectionList()){
			elements.add(e);
		}
		
		for(Element e: elements){
			RenameDialog renameDialog = new RenameDialog(model, e);
			renameDialog.setVisible(true);
		}
		
//		model.getTreeModel().reload();
	}

}
