package gui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import gui.model.Document;
import gui.model.MainModel;
import gui.model.Page;
import gui.model.Slot;
import gui.model.tree.Node;
import gui.observer.MainObserver;
import gui.observer.NotificationObserver;


@SuppressWarnings("serial")
public class DocumentView extends JPanel implements MainObserver {

	private Document document;
	private MainModel model;
	private JPanel pageArea;
	private Page selectedPage;
	private JScrollPane scrollBar;
	
	public DocumentView(MainModel model, Document document) {
		this.model = model;
		this.model.addObserver(this);
		this.setDocument(document);
		this.document.addObserver(this);
		
		pageArea = new JPanel();
		pageArea.setLayout(new BoxLayout(pageArea, BoxLayout.PAGE_AXIS));
		pageArea.setBackground(Color.LIGHT_GRAY);
		selectedPage = null;
		
		this.setLayout(new BorderLayout());
		scrollBar = new JScrollPane(pageArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
									ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollBar.setBorder(BorderFactory.createEmptyBorder());
		scrollBar.getVerticalScrollBar().setUnitIncrement(20);
		this.add(scrollBar);
		
	}
	
	@Override
	public void update(NotificationObserver notification, Object obj) {
		if (notification == NotificationObserver.ADD) {
			if (obj instanceof Page) {
				Page page = (Page) obj;
				addNewChildView(page);
			}
		}
		else if (notification == NotificationObserver.DELETE) {
			PageView pageView = findPage((Page) obj);
			
			try {
				pageArea.remove(pageView);
				repaint();
			}
			catch (NullPointerException e) {
				e.printStackTrace();
			}
		} 
		else if (notification == NotificationObserver.NODE_RENAME) {
			JTabbedPane documentTabs = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, this);

			for (int i = 0; i < documentTabs.getTabCount(); i++) {
				if (documentTabs.getComponentAt(i) == this) 
					documentTabs.setTitleAt(i, this.getDocument().getName());
			}
		}
	}
	
	public void addNewChildView(Page page) {
		PageView pageView = new PageView(model, page);

		pageArea.add(pageView);
		pageArea.scrollRectToVisible(pageView.getBounds());
		repaint();
		
		for (Node child : page.getChildren()) {
			Slot slot = (Slot) child;
			pageView.addNewChildView(slot);
		}
	}
	
	public void updateSelection(Object[] path, int idx) {
		if (path.length > idx) {
			PageView pageView = findPage((Page) path[idx]);
			
			if (pageView == null) 
				return;
			
			if (pageView.getPage() != selectedPage) {
				selectedPage = pageView.getPage();
			
				try {
					pageArea.scrollRectToVisible(pageView.getBounds());
				} 
				catch (NullPointerException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private PageView findPage(Page page) {
		for (Component c : pageArea.getComponents()) {
			if (c instanceof PageView) {
				PageView pageView = (PageView) c;

				if (pageView.getPage() == page) 
					return pageView;
			}
		}
		return null;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
}