package gekosem.painter;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import gekosem.GraphicElement;
import gekosem.OrElement;

@SuppressWarnings("serial")
public class OrPainter extends ShapePainter {

	public OrPainter(GraphicElement element) {
		super(element);
		// TODO Auto-generated constructor stub
		OrElement or = (OrElement) element;
		shape =new Ellipse2D.Double(Math.abs(or.getPosition().getX()), Math.abs(or.getPosition().getY()), Math.abs(or.getSize().getWidth()), Math.abs(or.getSize().getHeight()));
		
	}
}
