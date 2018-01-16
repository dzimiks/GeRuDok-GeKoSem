package gekosem.painter;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.io.Serializable;

import gekosem.GraphicElement;

@SuppressWarnings("serial")
public abstract class ElementPainter implements Serializable {
	
	protected Shape shape;
	
	private GraphicElement element;
	
	public ElementPainter(GraphicElement element){
		this.element = element;
	}
	
	public abstract void paint(Graphics2D g2, GraphicElement element);
	
	public abstract boolean isElementAt(Point pos);
	
	public Shape getShape(){
		return shape;
	}

	public GraphicElement getElement() {
		return element;
	}
	
	
}
