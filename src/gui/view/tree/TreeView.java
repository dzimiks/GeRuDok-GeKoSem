package gui.view.tree;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeSelectionModel;

import gui.constants.Constants;
import gui.controller.tree.TreeController;
import gui.model.MainModel;
import gui.model.Project;
import gui.model.Workspace;
import gui.model.tree.Node;
import gui.observer.MainObserver;
import gui.observer.NotificationObserver;


/**
 * Graficki prikaz WorkspaceTree-a.
 * 
 * @author Vanja Paunovic
 *
 */
public class TreeView extends JPanel implements MainObserver {

	/**
	 * VersionUID za serijalizaciju
	 */
	private static final long serialVersionUID = 1;
	
	private MainModel model;
	private WorkspaceTree tree;
	private DefaultListModel<Node> freeDocumentsListModel;
	
	public TreeView(MainModel model) {
		this.model = model;
		this.model.addObserver(this);
		this.initialize();
		new TreeController(model, this);
	}
	
	/**
	 * Pravi celo stablo.
	 */
	private void initialize() {
		
		Node root = Workspace.getInstance();
		this.setPreferredSize(Constants.TREE_SIZE);
		
		DefaultTreeModel treeModel = new DefaultTreeModel(Workspace.getInstance());
		treeModel.setRoot(root);
		
		this.tree = new WorkspaceTree(this.model);
		this.tree.setModel(treeModel);
		
		TreeCellRendered tcr = new TreeCellRendered();
		this.tree.setCellRenderer(tcr);
		this.tree.setCellEditor(new TreeCellEditor(this.tree, tcr, this.model));
		this.tree.setEditable(true);
		this.tree.setShowsRootHandles(true);
		
		TreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
		selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		this.tree.setSelectionModel(selectionModel);
		
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(1000, 1000));
		
		int height = Constants.TREE_VIEW_HEIGHT;
		JScrollPane treeScrollPane = new JScrollPane(tree);
		
		treeScrollPane.setSize(new Dimension(50, height));
		treeScrollPane.setMaximumSize(new Dimension(50, height));
		treeScrollPane.setMinimumSize(new Dimension(50, height));
		treeScrollPane.setPreferredSize(new Dimension(50, height));
		treeScrollPane.setAutoscrolls(true);
		
		this.add(treeScrollPane, BorderLayout.NORTH);
		freeDocumentsListModel = new DefaultListModel<>();
		
		JList<Node> freeDocumentsList = new JList<>(freeDocumentsListModel);
		JScrollPane freeDocumentsScrollPane = new JScrollPane(freeDocumentsList);

		freeDocumentsScrollPane.setSize(new Dimension(100, 150));
		freeDocumentsScrollPane.setMaximumSize(new Dimension(100, 150));
		freeDocumentsScrollPane.setMinimumSize(new Dimension(100, 150));
		freeDocumentsScrollPane.setPreferredSize(new Dimension(100, 150));
		
		this.reloadFreeDocumentsList();
		
		this.add(new JLabel("Free Documents:", SwingConstants.CENTER), BorderLayout.CENTER);
		this.add(freeDocumentsScrollPane, BorderLayout.SOUTH);
		
		this.model.setTreeModel(treeModel);
	}
	
	/**
	 * Ponovo ucitava listu slobodnih dokumenata.
	 */
	public void reloadFreeDocumentsList() {
		this.freeDocumentsListModel.removeAllElements();
		for (Node node : this.model.getFreeDocuments()) 
			this.freeDocumentsListModel.addElement(node);
	}

	public WorkspaceTree getTree() {
		return tree;
	}
	
	public Project getSelectedProject() {
		Object o = tree.getLastSelectedPathComponent();
		
		if (o instanceof Project) 
			return (Project) o;

		return null;
	}
	
	public Node getSelectedNode() {
		Object o = tree.getLastSelectedPathComponent();
		
		if (o instanceof Node) 
			return (Node) o;
		
		return null;
	}
	
	/**
	 * Dodaje listener na odgovarajucu stavku iz menija.
	 * 
	 * @param listener
	 * 			Listener koji ce biti dodat.
	 */
	public void addTreeListener(MouseListener listener) {
		this.tree.addMouseListener(listener);
	}
	
	@Override
	public void update(NotificationObserver notification, Object obj) {
		if (notification == NotificationObserver.FREE_DOCUMENTS_CHANGED) 
			this.reloadFreeDocumentsList();
	}
}