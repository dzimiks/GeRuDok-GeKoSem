package gekosem;

import java.util.ArrayList;

import gui.model.Element;

public class GekosemClipboard {
	ArrayList<Element> elements;
	public GekosemClipboard() {
		elements = new ArrayList<Element>();
	}
	public ArrayList<Element> getElements() {
		return elements;
	}
	public void setElements(ArrayList<Element> elements) {
		this.elements = elements;
	}
	
	public void addElement(Element element){
		elements.add(element);
	}
	
}
