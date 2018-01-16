package gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

public class CloseTabbedPaneAction implements ActionListener{

	private String tabName;

    public CloseTabbedPaneAction(String tabName) {
        this.tabName = tabName;
    }

    public String getTabName() {
        return tabName;
    }
    
	public void actionPerformed(ActionEvent arg0, JTabbedPane tabPane) {

        int index = tabPane.indexOfTab(getTabName());
        if (index >= 0) {

            tabPane.removeTabAt(index);
        }

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}