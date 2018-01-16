package gui.model;

import java.io.File;
import java.io.Serializable;

import gui.model.tree.Node;
import gui.observer.NotificationObserver;

/**
 * Cvor u stablu koji sadrzi dokumente.
 * 
 * @author Vanja Paunovic
 *
 */
public class Project extends Node implements Serializable {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;

	private static int newChildCount = 1;
	private File projectFile;
	private boolean opened;

	public Project(String name) {
		super(name);
		this.opened = true;
		this.projectFile = null;
	}

	
	
	@Override
	public Node addNewChild() {
		Document child = new Document("Document " + newChildCount);
		newChildCount++;
		this.addChild(child);
        
		return child;
	}
	
	@Override
	public Node addNewLinkChild(Node node) {
		DocumentLink child = new DocumentLink(node);
		
		node.addLink(child);
		this.addChild(child);
		child.setParent(this);
		
		return child;
	}

	public void doProjectOpen() {
		this.observerList.notifyObservers(NotificationObserver.PROJECT_OPEN, null);
	}

	public void doProjectClose() {
		this.observerList.notifyObservers(NotificationObserver.PROJECT_CLOSE, null);
	}
	
	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public File getProjectFile() {
		return projectFile;
	}

	public void setProjectFile(File projectFile) {
		this.projectFile = projectFile;
	}
}