package gekosem.commands;

import java.awt.Color;
import java.util.ArrayList;

import gekosem.AndElement;
import gekosem.Gekosem;
import gekosem.GraphicShape;
import gekosem.NotElement;
import gekosem.OrElement;
import gekosem.painter.AndPainter;
import gekosem.painter.NotPainter;
import gekosem.painter.OrPainter;
import gui.model.Element;
import gui.model.Slot;

public class ChangeColorCommand extends ElementCommand {

	private Slot slot;
	private Color color;
	private Color prevColor;
	private Gekosem g;
	private ArrayList<Element> elements = new ArrayList<>();
	
	public ChangeColorCommand(Slot slot, Color color, Color prevColor, Gekosem g) {
		//System.out.println("Prev color in constructor" + prevColor.toString());

		this.slot = slot;
		this.color = color;
		this.prevColor = prevColor;
		this.g = g;
		
		for(Element e: slot.getSelectionModels().getSelectionList()){
			elements.add(e);
		}
	}
	@Override
	public void doCommand() {
		for(Element e:elements){
			if(((GraphicShape)e) instanceof AndElement){
				((AndElement)((GraphicShape)e)).setPaint(color);
				((AndElement)((GraphicShape)e)).setPainter(new AndPainter(((AndElement)e)));
				g.getSlot().notifyObservers(null, g);
			}
			if(((GraphicShape)e) instanceof OrElement){
				((OrElement)((GraphicShape)e)).setPaint(color);
				((OrElement)((GraphicShape)e)).setPainter(new OrPainter(((OrElement)e)));
				g.getSlot().notifyObservers(null, g);				}
			if(((GraphicShape)e) instanceof NotElement){
				((NotElement)((GraphicShape)e)).setPaint(color);
				((NotElement)((GraphicShape)e)).setPainter(new NotPainter(((NotElement)e)));
				g.getSlot().notifyObservers(null, g);		
			}
		}
		//g.setColor(color);
	}

	@Override
	public void undoCommand() {
		System.out.println("Prev color " + prevColor.toString());
		for(Element e:elements){
			if(((GraphicShape)e) instanceof AndElement){
				((AndElement)((GraphicShape)e)).setPaint(prevColor);
				((AndElement)((GraphicShape)e)).setPainter(new AndPainter(((AndElement)e)));
				g.getSlot().notifyObservers(null, g);
			}
			if(((GraphicShape)e) instanceof OrElement){
				((OrElement)((GraphicShape)e)).setPaint(prevColor);
				((OrElement)((GraphicShape)e)).setPainter(new OrPainter(((OrElement)e)));
				g.getSlot().notifyObservers(null, g);				}
			if(((GraphicShape)e) instanceof NotElement){
				((NotElement)((GraphicShape)e)).setPaint(prevColor);
				((NotElement)((GraphicShape)e)).setPainter(new NotPainter(((NotElement)e)));
				g.getSlot().notifyObservers(null, g);		
			}
		}

	}
}
