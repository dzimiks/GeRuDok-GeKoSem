package gui.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameListener;

import gui.constants.Constants;
import gui.controller.ProjectViewController;
import gui.model.Document;
import gui.model.DocumentLink;
import gui.model.MainModel;
import gui.model.Page;
import gui.model.Project;
import gui.model.tree.Node;
import gui.model.tree.NodeLink;
import gui.observer.MainObserver;
import gui.observer.NotificationObserver;


@SuppressWarnings("serial")
public class ProjectView extends JInternalFrame implements MainObserver {

	private Project project;
	private MainModel model;
	private JTabbedPane documentTabs;
	private ProjectViewController projectViewController;
	
	public ProjectView(MainModel model, Project project, Point position) {
		super(project.getName(), true, true, true, true);
		this.model = model;
		this.model.addObserver(this);
		this.setProject(project);
		this.project.addObserver(this);
		this.setBackground(Color.WHITE);
		setSize(Constants.INTERNAL_FRAME_SIZE);
		setLocation(position);
		setVisible(true);
		
		documentTabs = new JTabbedPane();
		documentTabs.setAlignmentX(0.0f);

		add(documentTabs);
		projectViewController = new ProjectViewController(model, this);
	}
	
	@Override
	public void update(NotificationObserver notification, Object obj) {
		if (notification == NotificationObserver.ADD) {
			Document document = null;
			
			if (obj instanceof Document) 
				document = (Document) obj;
			else if (obj instanceof DocumentLink) 
				document = (Document) ((NodeLink) obj).getOriginal();
			
			if (document != null) 
				addNewChildView(document);
			
		} 
		else if (notification == NotificationObserver.DELETE) {
			Document document = (Document) (obj instanceof Document ? obj : ((NodeLink) obj).getOriginal());
			DocumentView documentView = findDocumentTab(document);
			
			try {
				documentTabs.remove(documentView);
				repaint();
			}
			catch (NullPointerException e) {
				e.printStackTrace();
			}
		} 
		else if (notification == NotificationObserver.PROJECT_CLOSE) {
			try {
				this.setIcon(true);
			}
			catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		} 
		else if (notification == NotificationObserver.PROJECT_OPEN) {
			try {
				this.setIcon(false);
			} 
			catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		} 
		else if (notification == NotificationObserver.NODE_RENAME) {
			this.setTitle(this.getProject().getName());
		}
	}

	public void addNewChildView(Document document) {
		DocumentView documentView = new DocumentView(model, document);
		documentTabs.addTab(documentView.getDocument().getName(), documentView);
		repaint();

		for (Node child : document.getChildren()) {
			Page page = (Page) child;
			documentView.addNewChildView(page);
		}
	}

	public void updateSelection(Object[] path, int idx) {
		if (path.length > idx) {
			DocumentView documentView = findDocumentTab(
					(Document) (path[idx] instanceof Document ? path[idx] : ((NodeLink) path[idx]).getOriginal()));
			if (documentView == null)
				return;

			try {
				if (documentTabs.getSelectedComponent() != documentView) 
					documentTabs.setSelectedComponent(documentView);
				
				documentView.updateSelection(path, idx + 1);
			} 
			catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
	}

	private DocumentView findDocumentTab(Document document) {
		int totalTabs = documentTabs.getTabCount();
		
		for (int i = 0; i < totalTabs; i++) {
			Component tab = documentTabs.getComponentAt(i);
		
			if (tab instanceof DocumentView) {
				DocumentView documentView = (DocumentView) tab;
				
				if (documentView.getDocument() == document) 
					return documentView;
			}
		}
		return null;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	public JTabbedPane getDocumentTabs() {
		return documentTabs;
	}

	public void setDocumentTabs(JTabbedPane documentTabs) {
		this.documentTabs = documentTabs;
	}

	public ProjectViewController getProjectViewController() {
		return projectViewController;
	}

	public void setProjectViewController(ProjectViewController projectViewController) {
		this.projectViewController = projectViewController;
	}

	public void addProjectInternalFrameListener(InternalFrameListener listener) {
		this.addInternalFrameListener(listener);
	}
	
	public void addTabChangeListener(ChangeListener listener) {
		this.documentTabs.addChangeListener(listener);
	}
}