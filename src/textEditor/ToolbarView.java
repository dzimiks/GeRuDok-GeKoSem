package textEditor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import gui.constants.Constants;
import gui.controller.TextEditorTollbarController;
import gui.model.Slot;

public class ToolbarView extends JToolBar{
	private String sizes[] = {"8", "9", "10", "11", "12", "14",
			"16", "18", "20", "24", "36", "48", "72"
	};
	
	private String styles[] = {"Serif", "Agency FB", "Arial", 
			"Calibri", "Century Gothic", 
			"Comic Sans MS", "Courier New", "Forte", 
			"Garamond", "Monospaced", "Segoe UI", 
			"Times New Roman", "Trebuchet MS", "Serif"};
	
	private String colors[] = {"Black", "Red", "Green",
			"Blue", "Orange", "Pink"
	};
	
	private JComboBox<String> size;
	private JComboBox<String> style;
	private JComboBox<String> color;
	private TextEditorTollbarController toolbarController;
	
	public ToolbarView(TextElement textElement, Slot slot, EditorView editor) {
		
		toolbarController = new TextEditorTollbarController(textElement, this, slot, editor);
		
//		JButton cut = new JButton();
//		cut.setIcon(new ImageIcon(Constants.CUT));
//		cut.setToolTipText("Cut");
//		cut.addActionListener(toolbarController.getCutActionListener());
//		this.add(cut);
//		
//		JButton copy = new JButton();
//		copy.setIcon(new ImageIcon(Constants.COPY));
//		copy.setToolTipText("Copy");
//		copy.addActionListener(toolbarController.getCopyActionListener());
//		this.add(copy);
//		
//		JButton paste = new JButton();
//		paste.setIcon(new ImageIcon(Constants.PASTE));
//		paste.setToolTipText("Paste");
//		paste.addActionListener(toolbarController.getPasteActionListener());
//		this.add(paste);
//		
//		this.addSeparator();
		
//		JButton undo = new JButton();
//		undo.setIcon(new ImageIcon(Constants.UNDO));
//		undo.setToolTipText("Undo");
//		undo.addActionListener(toolbarController.getUndoActionListener());
//		this.add(undo);
//		
//		JButton redo = new JButton();
//		redo.setIcon(new ImageIcon(Constants.REDO));
//		redo.setToolTipText("Redo");
//		redo.addActionListener(toolbarController.getRedoActionListener());
//		this.add(redo);
//		
//		this.addSeparator();
		
		JButton bold = new JButton();
		bold.setIcon(new ImageIcon(Constants.BOLD));
		bold.setToolTipText("Bold");
		bold.addActionListener(toolbarController.getBoldTextListener());
		this.add(bold);
		
		JButton italic = new JButton();
		italic.setIcon(new ImageIcon(Constants.ITALIC));
		italic.setToolTipText("Italic");
		italic.addActionListener(toolbarController.getItalicTextActionListener());
		this.add(italic);
		
		this.addSeparator();
		
		JLabel sizeLabel = new JLabel();
		sizeLabel.setIcon(new ImageIcon(Constants.FONT_SIZE));
		this.add(sizeLabel);		
		size = new JComboBox<>(sizes);
		size.setSelectedItem(sizes[5]);
		size.setEditable(false);
		size.setToolTipText("Select font size");
		size.addActionListener(toolbarController.getFontSizeActionListener());
		this.add(size);
		
		this.addSeparator();
		
		JLabel styleLabel = new JLabel();
		styleLabel.setIcon(new ImageIcon(Constants.FONT_STYLE));
		this.add(styleLabel);
		style = new JComboBox<>(styles);
		style.setEditable(false);
		style.setToolTipText("Select font style");
		style.addActionListener(toolbarController.getFontStyleActionListener());
		this.add(style);
		
		this.addSeparator();
		
		JLabel colorLabel = new JLabel();
		colorLabel.setIcon(new ImageIcon(Constants.FONT_COLOR));
		this.add(colorLabel);
		color = new JComboBox<>(colors);
		color.setEditable(false);
		color.setToolTipText("Select color");
		color.addActionListener(toolbarController.getFontColorActionListener());
		this.add(color);
	}
	
	public int getSelectedFontSize(){
		return Integer.parseInt(((String)size.getSelectedItem()));
	}
	public String getSelectedFontStyle(){
		return (String)style.getSelectedItem();
	}
	public String getSelectedFontColor(){
		return (String)color.getSelectedItem();
	}
}
