package gekosem.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.KeyStroke;

import gekosem.Gekosem;
import gui.observer.NotificationObserver;

public class PRedoAction extends AbstractAction {
	
	Gekosem g;
	public PRedoAction(Gekosem g){
		this.g = g;
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_R);
		putValue(NAME, "Redo");
		putValue(SHORT_DESCRIPTION, "Redo");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		g.getSlot().getSelectionModels().removeAllFromSelectionList();
		g.getSlot().notifyObservers(NotificationObserver.NODE_RENAME, new Integer(0));
		g.getGkm().doCommand();
		
		
	}

}
