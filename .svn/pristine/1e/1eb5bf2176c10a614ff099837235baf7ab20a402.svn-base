package gekosem.select;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultSingleSelectionModel;

import gekosem.GraphicShape;
import gekosem.LinkElement;
import gekosem.painter.LinkPainter;
import gui.model.Element;
import gui.model.tree.Node;

public class SlotSelectionModel extends DefaultSingleSelectionModel {

	private ArrayList<Element> selectionList = new ArrayList<>();
	
	
	public void addSelectionList(Element e) {
		selectionList.add(e);
	}

	public void addToSelectionList(ArrayList<Element> lista) {
		selectionList.addAll(lista);
	}

	public int getSelectionListSize() {
		return selectionList.size();
	}

	public Element getElementFromSelectionListAt(int index) {
		return (Element) selectionList.get(index);
	}

	public int getIndexByObject(Element element) {
		return selectionList.indexOf(element);
	}

	public void removeFromSelectionList(Element element) {
		selectionList.remove(element);
	}

	public void removeAllFromSelectionList() {
		selectionList.clear();
	}

	public boolean isElementSelected(Element element) {
		return selectionList.contains(element);

	}
	
	public ArrayList<Element> getSelectionList() {
		return selectionList;
	}
	

	public void selectElements(Rectangle2D rec, List<Node> list) {

		for (Node e : list) {
			if (e instanceof GraphicShape) {
				GraphicShape device = (GraphicShape) e;
				if (rec.intersects(device.getPosition().getX(), device.getPosition().getY(),
						device.getSize().getWidth(), device.getSize().getHeight())) {
					if (!isElementSelected(device))
						selectionList.add(device);
				}

			} else {
				LinkElement link = (LinkElement) e;
				if (rec.contains(LinkPainter.findRectangle(link))) {
					if (!isElementSelected(link))
						selectionList.add(link);

				}
			}
		}
	}

}
