package gui.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import gui.model.MainModel;
import gui.model.Slot;
import gui.observer.NotificationObserver;
import gui.view.SlotView;
import textEditor.EditorView;
import textEditor.TextElement;
import textEditor.ToolbarView;

public class TextEditorTollbarController {
	private TextElement textElement;
	private ToolbarView toolbar;
	private Slot slot;
	private EditorView editor;
	public TextEditorTollbarController(TextElement textElement, ToolbarView toolbarView, Slot slot, EditorView editor) {
		this.textElement = textElement;
		this.toolbar = toolbarView;
		this.slot = slot;
		this.editor = editor;
	}
	
	public ActionListener getBoldTextListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textElement.isFontBold()){
					textElement.setFontBold(false);
				}else{
					textElement.setFontBold(true);
				}
				chageTextProperties();
				slot.notifyObservers(NotificationObserver.ADD, new JPanel());
			}
		};
	}
	
	public ActionListener getItalicTextActionListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textElement.isFontItalic()){
					textElement.setFontItalic(false);
				}else{
					textElement.setFontItalic(true);
				}
				chageTextProperties();
				slot.notifyObservers(NotificationObserver.ADD, new JPanel());
			}
		};
	}
	
	public ActionListener getFontSizeActionListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textElement.setFontSize(toolbar.getSelectedFontSize());
				chageTextProperties();
				slot.notifyObservers(NotificationObserver.ADD, new JPanel());
			}
		};
	}
	
	public ActionListener getFontStyleActionListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textElement.setFontStyle(toolbar.getSelectedFontStyle());
				chageTextProperties();
				slot.notifyObservers(NotificationObserver.ADD, new JPanel());
			}
		};
	}
	
	public ActionListener getFontColorActionListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String c = toolbar.getSelectedFontColor();
				if(c.equals("Black")){
					textElement.setColor(Color.BLACK);
				}else if(c.equals("Red")){
					textElement.setColor(Color.RED);
				}else if(c.equals("Green")){
					textElement.setColor(Color.GREEN);
				}else if(c.equals("Blue")){
					textElement.setColor(Color.BLUE);
				}else if(c.equals("Yellow")){
					textElement.setColor(Color.YELLOW);
				}else if(c.equals("Orange")){
					textElement.setColor(Color.ORANGE);
				}else if(c.equals("Pink")){
					textElement.setColor(Color.PINK);
				}
				chageTextProperties();
				slot.notifyObservers(NotificationObserver.ADD, new JPanel());
			}
		};
	}
	
	public ActionListener getUndoActionListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	public ActionListener getRedoActionListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	public ActionListener getCutActionListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	public ActionListener getCopyActionListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	public ActionListener getPasteActionListener(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}
	private void chageTextProperties(){
		if(textElement.isFontBold()){
			if(textElement.isFontItalic()){
				editor.getTextArea().setFont(new Font(textElement.getFontStyle(), Font.BOLD+Font.ITALIC
				, textElement.getFontSize()));
			}else{
				editor.getTextArea().setFont(new Font(textElement.getFontStyle(), Font.BOLD
						, textElement.getFontSize()));
			}
		}else if(textElement.isFontItalic()){
			editor.getTextArea().setFont(new Font(textElement.getFontStyle(), Font.ITALIC
						, textElement.getFontSize()));
		}else{
			editor.getTextArea().setFont(new Font(textElement.getFontStyle(), Font.PLAIN, textElement.getFontSize()));
		}
		editor.getTextArea().setForeground(textElement.getColor());
	}
}
