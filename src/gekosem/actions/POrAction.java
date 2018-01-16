package gekosem.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import gekosem.Gekosem;
import gui.model.Slot;
import gui.observer.NotificationObserver;

public class POrAction extends AbstractAction{
	private Slot slot;
 
	public POrAction(Slot slot) {
		super();
		this.slot = slot;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		slot.getSelectionModels().removeAllFromSelectionList();
		slot.notifyObservers(NotificationObserver.ADD, new JPanel());
		Gekosem.getStateManager().setOrState();
		
	}

}
