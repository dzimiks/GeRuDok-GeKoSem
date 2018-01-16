package gekosem.painter;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.io.Serializable;

import gekosem.AndElement;
import gekosem.GraphicElement;

@SuppressWarnings("serial")
public class AndPainter extends ShapePainter {

	public AndPainter(GraphicElement element) {
		super(element);
		// TODO Auto-generated constructor stub
		AndElement and = (AndElement)element;
		shape = new GeneralPath();
		
		((GeneralPath)shape).moveTo(and.getPosition().getX(), and.getPosition().getY());
		((GeneralPath)shape).lineTo(and.getPosition().getX() + and.getSize().getWidth(), and.getPosition().getY());
		((GeneralPath)shape).lineTo(and.getPosition().getX() + and.getSize().getWidth(), and.getPosition().getY() + and.getSize().getHeight());
		((GeneralPath)shape).lineTo(and.getPosition().getX(), and.getPosition().getY() + and.getSize().getHeight());
		
		((GeneralPath)shape).closePath();
	}

}
