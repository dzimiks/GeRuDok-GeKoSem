package textEditor;

import java.awt.Color;

import gui.model.Element;
import gui.observer.MainObserver;
import gui.observer.Observable;
import gui.observer.ObserverList;

public class TextElement extends Element{
	private String text;
	private int fontSize;
	private boolean fontBold;
	private boolean fontItalic;
	private String fontStyle;
	private Color color;
	private int x;
	private int y;
	private static int no = 1;

	public TextElement() {
		super();
		no++;
		text = "";
		x = 20;
		y = 40;
		fontSize = 14;
		fontBold = false;
		fontItalic = false;
		fontStyle = "Arial";
		color = Color.BLACK;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		System.out.println(text);
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public boolean isFontBold() {
		return fontBold;
	}

	public void setFontBold(boolean fontBold) {
		this.fontBold = fontBold;
	}

	public boolean isFontItalic() {
		return fontItalic;
	}

	public void setFontItalic(boolean fontItalic) {
		this.fontItalic = fontItalic;
	}

	public String getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(String fontStyle) {
		this.fontStyle = fontStyle;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "TextElement" + no;
	}
	
}
