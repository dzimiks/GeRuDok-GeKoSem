package gekosem.actions;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;

import gekosem.Gekosem;
import gekosem.GraphicElement;
import gekosem.select.SlotELemenetsSelection;
import gui.model.Element;
import gui.model.Slot;

public class PCopyAction extends AbstractAction{
	Gekosem g;
	Slot slot;
	public PCopyAction(Gekosem g, Slot slot) {
		this.g = g;
		this.slot = slot;
		//System.out.println(g.getClipboard());
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//SlotELemenetsSelection ses = new SlotELemenetsSelection(slot.getSelectionModels().getSelectionList());
		//g.getClipboard().setContents(ses, g);
		g.getGekosemClipboard().setElements(null);
		ArrayList<Element> elementi = slot.getSelectionModels().getSelectionList();
		ArrayList<Element> newList = new ArrayList<>();
		for(int i = 0 ; i < elementi.size() ; i++){
			newList.add(elementi.get(i));
			//g.getGekosemClipboard().addElement(elementi.get(i));
		}
		//g.getGekosemClipboard().setElements(slot.getSelectionModels().getSelectionList());
		g.getGekosemClipboard().setElements(newList);
		System.out.println(g.getGekosemClipboard().getElements().size());
	}

}
