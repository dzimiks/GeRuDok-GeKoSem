package gekosem.painter;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.io.Serializable;

import gekosem.GraphicElement;
import gekosem.GraphicShape;
import gekosem.InputOutputElement;
import gekosem.NotElement;

@SuppressWarnings("serial")
public class ShapePainter extends ElementPainter implements Serializable {

	public ShapePainter(GraphicElement element) {
		super(element);
	}

	@Override
	public void paint(Graphics2D g2, GraphicElement element) {

		if (element instanceof GraphicShape) {
			if (element instanceof NotElement) {
				((NotElement) element).getIn1().getPainter().paint(g2, ((GraphicShape) element).getIn1());
			} else {
				((GraphicShape) element).getIn1().getPainter().paint(g2, ((GraphicShape) element).getIn1());
				((GraphicShape) element).getIn2().getPainter().paint(g2, ((GraphicShape) element).getIn2());
			}
			if(element instanceof InputOutputElement){
				
			}else{
				((GraphicShape)element).getOut().getPainter().paint(g2, ((GraphicShape) element).getOut());
			}
			
			
		}
		g2.setPaint(element.getStrokeColor());
		g2.setStroke(element.getStroke());
		g2.draw(getShape());
		
		g2.setPaint(element.getPaint());
		g2.fill(getShape());

	}

	@Override
	public boolean isElementAt(Point pos) {
		// TODO Auto-generated method stub
		return getShape().contains(pos);
	}
	
	public void setShape(Shape shape){
		this.shape = shape;
	}
}
