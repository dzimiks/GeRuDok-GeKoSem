package gekosem.painter;

import java.awt.Shape;
import java.awt.geom.GeneralPath;

import gekosem.AndElement;
import gekosem.GraphicElement;
import gekosem.NotElement;

@SuppressWarnings("serial")
public class NotPainter extends ShapePainter {

	public NotPainter(GraphicElement element) {
		super(element);
		// TODO Auto-generated constructor stub
		
		NotElement not = (NotElement)element;
		shape = new GeneralPath();
		
		((GeneralPath)shape).moveTo(not.getPosition().getX(), not.getPosition().getY());
		((GeneralPath)shape).lineTo(not.getPosition().getX() + not.getSize().getWidth(),  not.getPosition().getY() + not.getSize().getHeight()/2);
		((GeneralPath)shape).lineTo(not.getPosition().getX(), not.getPosition().getY() + not.getSize().getHeight());
		
		((GeneralPath)shape).closePath();
	}

}
