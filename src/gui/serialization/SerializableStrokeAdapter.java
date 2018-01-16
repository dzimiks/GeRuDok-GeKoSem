package gui.serialization;

import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.Stroke;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


@SuppressWarnings("serial")
public class SerializableStrokeAdapter implements Stroke, Serializable {
	
	Stroke stroke;

	public SerializableStrokeAdapter(Stroke s) {
		this.stroke = s;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		if (stroke instanceof BasicStroke) {
			BasicStroke s = (BasicStroke) stroke;
			out.writeFloat(s.getLineWidth());
			out.writeInt(s.getEndCap());
			out.writeInt(s.getLineJoin());
			out.writeFloat(s.getMiterLimit());
			out.writeObject(s.getDashArray());
			out.writeFloat(s.getDashPhase());
		}
     }
	
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    	stroke = new BasicStroke(in.readFloat(), in.readInt(), in.readInt(), 
    							 in.readFloat(), (float[])in.readObject(), in.readFloat());
     }
	
	public Shape createStrokedShape(Shape p) {
		if(stroke == null){
			stroke = new BasicStroke();
		}
		return stroke.createStrokedShape(p);
	}
}