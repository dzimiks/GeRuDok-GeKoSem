package gekosem.commands;

import java.util.ArrayList;

import gui.view.PaletteView;

public class GekosemCommandMannager {

	private PaletteView p;
	
	private ArrayList<ElementCommand> commands = new ArrayList<>();
	
	private int currentCommand = 0;
	
	public GekosemCommandMannager(PaletteView p) {
		super();
		this.p = p;
	}

	public void addCommand(ElementCommand command){
		while(currentCommand < commands.size()){
			commands.remove(currentCommand);
		}
		commands.add(command);
		doCommand();
	}
	
	
	public void doCommand(){
		if(currentCommand < commands.size()){
			commands.get(currentCommand++).doCommand();
			//undo
			p.getUndo().setEnabled(true);
		}
		if(currentCommand==commands.size()){
			//redo
			p.getRedo().setEnabled(false);
		}
	}
	
	public void undoCommand(){
		if(currentCommand > 0){
			//redo
			p.getRedo().setEnabled(true);
			commands.get(--currentCommand).undoCommand();
		}
		if(currentCommand==0){
			//undo
			p.getRedo().setEnabled(false);
		}
	}
}