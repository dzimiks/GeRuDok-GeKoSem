package gui.model;

import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;

import gekosem.GraphicElement;
import gekosem.select.SlotSelectionModel;
import gui.model.tree.Node;
import gui.observer.Observable;

/**
 * Cvor u stablu koji sadrzi elemente.
 * 
 * @author Vanja Paunovic
 *
 */
public class Slot extends Node implements Serializable, Transferable{

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;
	
	private ElementType type;
	
	private SlotSelectionModel selectionModels = null;
	
	public int getElementAtPosition(Point point){
		int i = 0;
		for(Node p : children){
			GraphicElement g = (GraphicElement)p;
			if(g.getPainter().isElementAt(point)){
				return i;
			}
			i++;
		}
		return -1;
		
	}
	
	public Slot(String name) {
		super(name);
	}
	
	public Slot(String name, ElementType type) {
		super(name);
		this.type = type;
	}

	public ElementType getType() {
		return type;
	}

	public void setType(ElementType type) {
		this.type = type;
	}

	public SlotSelectionModel getSelectionModels() {
		if(selectionModels == null){
			selectionModels = new SlotSelectionModel();
		}
		return selectionModels;
		
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		return selectionModels;
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		// TODO Auto-generated method stub
		return false;
	}

	
}