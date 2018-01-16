package gekosem;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.Serializable;

import gekosem.painter.AndPainter;
import gekosem.painter.ElementPainter;

@SuppressWarnings("serial")
public class AndElement extends GraphicShape implements Serializable {

	public AndElement(Point2D pos, Dimension size, Stroke stroke, Paint color, Color strokeColor) {
		super(pos, size, stroke, color, strokeColor, 2, 1);
		setPainter(new AndPainter(this));
		
	}
	
	public AndElement(AndElement and){
		super(and);
		setName("klon");
		setPainter(new AndPainter(this));
	}

	public static GraphicShape defaultPaint(Point2D pos, int elemNo, Paint color){
		Point2D position = (Point2D) pos.clone();

		
		AndElement and = new AndElement(position, new Dimension(50, 50), 
				new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL), color, Color.BLACK);
		
		and.setName("AND " + elemNo);
		
		return and;
	}
	
	@Override
	public GraphicShape clone() {
		// TODO Auto-generated method stub
		return new AndElement(this);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName();
	}
	
	@Override
	public void setPosition(Point2D position) {
		super.setPosition(position);
		setPainter(new AndPainter(this));
	}

	@Override
	public Object getTransferData(DataFlavor arg0) throws UnsupportedFlavorException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
