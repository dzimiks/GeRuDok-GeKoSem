package gui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

import gui.actions.CloseTabbedPaneAction;
import gui.constants.Constants;
import gui.listeners.CloseApplicationListener;
import gui.model.MainModel;
import gui.view.tree.TreeView;

public class MainView extends JFrame {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;

	private static MainView instance;

	private MenuBarView menuBar;
	private ToolBarView toolBar;
//	private PaletteView palette;
	private StatusBarView statusBar;
	private DesktopView desktopView;
	private TreeView treeView;
	private MainModel model;
	
	private MainView() {
		initialize();
	}

	private void initialize() {

		// Podesavanje MainView-a

		setLookAndFeel();
		this.model = MainModel.getInstance();

		setLayout(new BorderLayout());
		setSize(Constants.WINDOW_SIZE);
		setMinimumSize(new Dimension(800, 700));
		setTitle("GeKoSeM");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new CloseApplicationListener());
		setLocationRelativeTo(null);

		// Favicon ikonica
		try {
			this.setIconImage(ImageIO.read(new File(Constants.FAVICON)));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// MenuBar
		menuBar = new MenuBarView(this.model);
		this.setJMenuBar(menuBar);

		// ToolBar
		toolBar = new ToolBarView(this.model);
		this.add(toolBar, BorderLayout.PAGE_START);

//		// Palette
//		palette = new PaletteView(this.model);
//		this.add(palette, BorderLayout.EAST);
		
		// StatusBar
		statusBar = new StatusBarView(this.model);
		this.add(statusBar, BorderLayout.SOUTH);
		
		// TreeView
		treeView = new TreeView(this.model);
		
		// DesktopView
		desktopView = new DesktopView(this.model);
		
		// ScrollView za stablo
		JScrollPane scrollView = new JScrollPane(treeView);
		scrollView.setMinimumSize(new Dimension(200, 600));
		scrollView.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		// SplitView 
		JSplitPane splitView = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollView, desktopView);
		splitView.setDividerLocation(300);
		
		this.add(splitView, BorderLayout.CENTER);
	}
	
	private void setLookAndFeel() {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public StatusBarView getStatusBar() {
		return statusBar;
	}

	public ToolBarView getToolBar() {
		return toolBar;
	}

	public TreeView getTreeView() {
		return treeView;
	}
	
	public DesktopView getDesktopView(){
		return desktopView;
	}
	
	public static MainView getInstance() {
		if (instance == null) {
			instance = new MainView();
		}

		return instance;
	}
}