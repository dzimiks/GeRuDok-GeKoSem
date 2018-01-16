package textEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gui.model.ElementType;
import gui.model.MainModel;
import gui.model.Slot;
import gui.observer.NotificationObserver;
import gui.view.SlotView;

/**
 * @author uSER
 *
 */
public class EditorView extends JDialog{
	
	private Slot slot;
	private TextElement textElement;
	
	JTextArea textArea;
	
	public EditorView(Slot slot) {
		
		this.slot = slot;
		slot.setType(ElementType.TEXT);
		
		if(slot.isLeaf()){
			
			textElement = new TextElement();
			MainModel.getInstance().getTreeModel().reload();
			slot.addChild(textElement);
			
		}else{
			textElement = (TextElement)slot.getChildAt(0);
		}
		
		MainModel.getInstance().getTreeModel().reload();
		
		textArea = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		textArea.setText(textElement.getText());
		
		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);
		
		ToolbarView toolbar = new ToolbarView(textElement, slot, this);
		
		this.add(toolbar, BorderLayout.BEFORE_FIRST_LINE);
		this.setSize(new Dimension(700, 550));
		this.setLocationRelativeTo(null);
		this.toFront();
		
		textArea.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				textElement.setText(textArea.getText());
				slot.notifyObservers(NotificationObserver.ADD, new JPanel());
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				textElement.setText(textArea.getText());
				slot.notifyObservers(NotificationObserver.ADD, new JPanel());
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				textElement.setText(textArea.getText());
				slot.notifyObservers(NotificationObserver.ADD, new JPanel());
			}
		});
	}
	public JTextArea getTextArea() {
		return textArea;
	}
}
