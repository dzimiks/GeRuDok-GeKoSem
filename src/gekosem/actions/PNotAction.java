package gekosem.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import gekosem.Gekosem;
import gui.model.Slot;
import gui.observer.NotificationObserver;

public class PNotAction extends AbstractAction{

	private Slot slot;

	
	public PNotAction(Slot slot) {
		super();
		this.slot = slot;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		slot.getSelectionModels().removeAllFromSelectionList();
		slot.notifyObservers(NotificationObserver.ADD, new JPanel());
		Gekosem.getStateManager().setNotState();
		
	}

}
