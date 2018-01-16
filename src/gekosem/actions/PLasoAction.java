package gekosem.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import gekosem.Gekosem;

public class PLasoAction extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Gekosem.getStateManager().setLassoState();
		
	}

}
