package gekosem.select;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

import gui.model.Element;


public class SlotELemenetsSelection implements Transferable, ClipboardOwner{
	
	static public DataFlavor elementFlavor;
	
	private DataFlavor[] suportedFlavors = {elementFlavor};
	
	public ArrayList<Element> graphicElements = new ArrayList<>();
	
	
	public SlotELemenetsSelection(ArrayList<Element> graphicElements) {
		super();
		this.graphicElements = graphicElements;
		try {

			elementFlavor = new DataFlavor(Class.forName("java.util.ArrayList"), "Elements");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void lostOwnership(Clipboard arg0, Transferable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getTransferData(DataFlavor arg0) throws UnsupportedFlavorException, IOException {
		// TODO Auto-generated method stub
		//if (arg0.equals(elementFlavor))
			return (graphicElements);
		//else
			//throw new UnsupportedFlavorException(elementFlavor);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		// TODO Auto-generated method stub
		return suportedFlavors;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor arg0) {
		// TODO Auto-generated method stub
		return (arg0.equals(elementFlavor));
	}

}
