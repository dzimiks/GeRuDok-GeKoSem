package gekosem;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.datatransfer.Transferable;

import gekosem.painter.ElementPainter;
import gui.model.Element;
import gui.serialization.SerializableStrokeAdapter;

@SuppressWarnings("serial")
public abstract class GraphicElement extends Element implements Transferable{
	
	private Paint paint;
	protected SerializableStrokeAdapter stroke;
//	private Stroke stroke;
	private Color strokeColor;
	private String name;
	
	protected ElementPainter painter;
	
	public abstract GraphicElement clone();
	
	public GraphicElement(Stroke stroke, Paint paint, Color strokeColor){
		setStroke(stroke);
		this.paint = paint;
		this.strokeColor = strokeColor;
	}
	
	public GraphicElement(GraphicElement element){
		this.stroke = element.stroke;
		this.paint = element.getPaint();
		this.name = element.getName();
		this.painter = element.getPainter();
		this.strokeColor = element.getStrokeColor();

	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = new SerializableStrokeAdapter(stroke);
	}
	
	public Color getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ElementPainter getPainter() {
		return painter;
	}

	public void setPainter(ElementPainter painter) {
		this.painter = painter;
	}
	
	
}
