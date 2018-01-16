package gekosem.commands;

import javax.swing.JPanel;

import gekosem.LinkElement;
import gui.commands.DeleteElementCommand;
import gui.commands.DeleteNodeCommand;
import gui.commands.Invoker;
import gui.model.Element;
import gui.model.MainModel;
import gui.model.Slot;
import gui.observer.NotificationObserver;

public class AddCommand extends ElementCommand {

	private Element element;
	private Slot slot;
	
	public AddCommand(Element element, Slot slot){
		this.element = element;
		this.slot = slot;
	}
	@Override
	public void doCommand() {
		// TODO Auto-generated method stub
		slot.addChild(element);
		slot.notifyObservers(NotificationObserver.ADD, new JPanel());

	}

	@Override
	public void undoCommand() {
		// TODO Auto-generated method stub
		//Bolje je invoker komanda za brisanje elementa, da bi obrisao i link
		Invoker.getInstance().executeCommand(new DeleteElementCommand(element));
		slot.notifyObservers(NotificationObserver.ADD, null);
	}

}
