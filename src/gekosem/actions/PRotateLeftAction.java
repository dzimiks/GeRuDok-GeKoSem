package gekosem.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import gekosem.Gekosem;
import gekosem.commands.RotateCommand;
import gui.observer.NotificationObserver;

public class PRotateLeftAction extends AbstractAction{

	private Gekosem gek;
	private boolean gde;
	
	public PRotateLeftAction(Gekosem gek, boolean gde){
		this.gek = gek;
		this.gde = gde;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//Odkomentarisati za undo/redo
//		(new RotateCommand(gek, gde)).doCommand();
//		gek.getSlot().notifyObservers(NotificationObserver.ADD, null);
//		gek.getGkm().addCommad(new RotateCommand(gek, gde));
	}
}

