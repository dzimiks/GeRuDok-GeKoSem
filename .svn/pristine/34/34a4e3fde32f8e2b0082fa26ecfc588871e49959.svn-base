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
import gekosem.painter.OrPainter;

@SuppressWarnings("serial")
public class OrElement extends GraphicShape implements Serializable {

	public OrElement(Point2D pos, Dimension size, Stroke stroke, Paint paint, Color strokeColor) {
		super(pos, size, stroke, paint, strokeColor, 2, 1);
		setPainter(new OrPainter(this));
	}
	
	public OrElement(OrElement or){
		super(or);
		setName("klon");
		setPainter(new OrPainter(this));
	}
	
	@Override
	public GraphicShape clone() {
		// TODO Auto-generated method stub
		return new OrElement(this);
	}
	
	public static GraphicShape defaultPaint(Point2D pos, int elemNo, Paint color){
		Point2D position = (Point2D) pos.clone();

		OrElement or = new OrElement(position, new Dimension(50, 50), 
				new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL), color, Color.BLACK);
		
		or.setName("OR " + elemNo);
		
		return or;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName();
	}
	
	@Override
	public void setPosition(Point2D position) {
		super.setPosition(position);
		setPainter(new OrPainter(this));
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		// TODO Auto-generated method stub
		return null;
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

