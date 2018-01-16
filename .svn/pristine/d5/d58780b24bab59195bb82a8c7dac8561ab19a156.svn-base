package gekosem.painter;

import java.awt.geom.GeneralPath;

import gekosem.GraphicElement;
import gekosem.InputOutputElement;

@SuppressWarnings("serial")
public class InputOutputPainter extends ShapePainter {

	public InputOutputPainter(GraphicElement element) {
		super(element);
		// TODO Auto-generated constructor stub
		
		shape = new GeneralPath();
		
		if(((InputOutputElement)element).getType() == 1){
			((GeneralPath)shape).moveTo(((InputOutputElement)element).getPosition().getX() + 5, ((InputOutputElement)element).getPosition().getY());
			((GeneralPath)shape).lineTo(((InputOutputElement)element).getPosition().getX() - 5, ((InputOutputElement)element).getPosition().getY());
			
		}else{
			((GeneralPath)shape).moveTo(((InputOutputElement)element).getPosition().getX() - 5, ((InputOutputElement)element).getPosition().getY());
			((GeneralPath)shape).lineTo(((InputOutputElement)element).getPosition().getX() + 5, ((InputOutputElement)element).getPosition().getY());
		
		}
		
		
	}

}
