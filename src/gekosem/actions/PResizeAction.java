package gekosem.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import gekosem.Gekosem;
import gui.model.Slot;

public class PResizeAction extends AbstractAction{
	 
		private Slot slot;
		
		public PResizeAction(Slot slot) {
			super();
			this.slot = slot;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			Gekosem.getStateManager().setResizeState();
			
		}

}
