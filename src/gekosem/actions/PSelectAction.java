package gekosem.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import gekosem.Gekosem;
import gui.model.Slot;
import gui.observer.NotificationObserver;

public class PSelectAction extends AbstractAction{

    private Slot slot;
	
    
	public PSelectAction(Slot slot) {
		super();
		this.slot = slot;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		slot.getSelectionModels().removeAllFromSelectionList();
		slot.notifyObservers(NotificationObserver.ADD, new JPanel());
		Gekosem.getStateManager().setSelectState();
		
	}

	
}
