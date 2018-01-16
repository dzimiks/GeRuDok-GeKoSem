package gekosem;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import gekosem.painter.LinkPainter;

@SuppressWarnings("serial")
public class LinkElement extends GraphicElement implements Serializable {
	
	private GraphicShape start;
	private GraphicShape end;
	private InputOutputElement in;
	private InputOutputElement out;
	
	private ArrayList<Point2D> points = new ArrayList<>();
	
	
	public LinkElement(GraphicShape gs, InputOutputElement input, Stroke stroke, Paint paint, Color strokeColor) {
		super(stroke, paint, strokeColor);
		// TODO Auto-generated constructor stub
		this.start = gs;
		this.out = input;
		addPoint(new Point2D.Double(out.getPosition().getX(), out.getPosition().getY()));
		
		this.painter = new LinkPainter(this);
		
	}

	
	public LinkElement(LinkElement linkElement) {
		super( linkElement.getStroke(), linkElement.getPaint(), linkElement.getStrokeColor());
		for(int i = 0 ; i < linkElement.getPoints().size() ; i++){
			this.points.add((Point2D)linkElement.getPoints().get(i).clone());
		}
		setName("klon");
	}


	public static GraphicElement defaultPaint(GraphicShape gs, InputOutputElement in, int elemNo){
		
		LinkElement link = new LinkElement(gs, in, new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL), Color.GREEN, Color.BLACK);
		link.setName("LINK " + elemNo);
		
		return link;
		
	}
	@Override
	public GraphicElement clone() {
		
		return new LinkElement(this);
	}
	
	public void addPoint(Point2D p){
		points.add(p);
	}
	
	public Point2D getLastPoint(){
		return points.get(points.size()-1);
	}
	
	public GraphicShape getStart() {
		return start;
	}

	public void setStart(GraphicShape start) {
		this.start = start;
	}

	public GraphicShape getEnd() {
		return end;
	}

	public void setEnd(GraphicShape end) {
		this.end = end;
		points.remove(getLastPoint());
	}

	public InputOutputElement getIn() {
		return in;
	}

	public void setIn(InputOutputElement in) {
		this.in = in;
	}

	public InputOutputElement getOut() {
		return out;
	}

	public void setOut(InputOutputElement out) {
		this.out = out;
	}

	public ArrayList<Point2D> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<Point2D> points) {
		this.points = points;
	}
	
	public void update(){
		this.painter = new LinkPainter(this);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return start.getName() + " " + this.getName() + " " + end.getName();
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
