package gui.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import gui.model.tree.Node;
import gui.observer.MainObserver;
import gui.observer.NotificationObserver;
import gui.observer.Observable;
import gui.observer.ObserverList;

/**
 * Glavni model MVC arhitekture.
 * 
 * @author Vanja Paunovic
 *
 */
public class MainModel implements Observable, Serializable {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;
	
	private static MainModel instance = null;

	/**
	 * Model WorkspaceTree. Koristi se da osvezi stablo.
	 */
	private DefaultTreeModel treeModel;
	
	/**
	 * ObserverList koji reaguje na svaku promenu podataka.
	 */
	private ObserverList observerList;
	
	/**
     * Dokumenti koji su uklonjeni iz WorkspaceTree-a, ali nisu obrisani.
     * Oni su sacuvani ovde dok cekaju da budu vraceni u stablo.
     */
    private ArrayList<Node> freeDocuments;
	
	/**
	 * Cuva trenutno selektovan path u stablu.
	 */
	private TreePath selectedPath;

	
	private MainModel() {
		this.observerList = new ObserverList();
		this.freeDocuments = new ArrayList<>();
	}
	
	@Override
	public void addObserver(MainObserver observer) {
		this.observerList.addObserver(observer);
	}

	/**
	 * Obavestava WorkspaceTree da selektuje cvor.
	 * 
	 * @param node
	 * 			Node koji ce biti selektovan.
	 */
	public void doTreeSelection(Node node) {
		this.observerList.notifyObservers(NotificationObserver.TREE_SELECT, node);
	}
	
	/**
	 * Obavestava WorkspaceTree da preimenuje cvor.
	 * 
	 * @param node
	 * 			Node koji ce biti preimenovan.
	 */
	public void doTreeRename(Node node) {
		this.observerList.notifyObservers(NotificationObserver.TREE_RENAME, node);
	}
	
	/**
	 * Azurira izabranu putanju do stabla.
	 * 
	 * @param path
	 * 			Novi selektovani TreePath.
	 */
	public void updateSelection(TreePath path) {
		this.observerList.notifyObservers(NotificationObserver.DESKTOP_SELECT, path);
		selectedPath = path;
	}

	/**
     * Obavestava TreeView da osvezi slobodne dokumente.
     */
    public void doReloadFreeDocuments() {
    	this.observerList.notifyObservers(NotificationObserver.FREE_DOCUMENTS_CHANGED, null);
    }
	
	/**
	 * Vraca trenutno selektovan objekat.
	 * 
	 * @return Selektovan objekat.
	 */
	public Object getSelectedObject() {
		return selectedPath != null ? selectedPath.getLastPathComponent() : null;
	}
	
	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(DefaultTreeModel treeModel) {
		this.treeModel = treeModel;
	}

	public TreePath getSelectedPath() {
		return selectedPath;
	}

	/**
     * Vraca slobodne dokumente.
     * 
     * @return Prazan cvor.
     */
    public ArrayList<Node> getFreeDocuments() {
    	return this.freeDocuments;
    }

    /**
     * Proverava da li postoje slobodni dokumenti.
     * 
     * @return Da li postoje slobodni dokumenti.
     */
    public boolean hasFreeDocuments() {
    	return !this.freeDocuments.isEmpty();
    }
	
	public static MainModel getInstance() {
		if (instance == null){
			instance = new MainModel();
		}
		
		return instance;
	}
}