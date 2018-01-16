package gui.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import gui.constants.Constants;
import gui.model.MainModel;
import gui.model.Page;
import gui.model.Slot;
import gui.observer.MainObserver;
import gui.observer.NotificationObserver;


@SuppressWarnings("serial")
public class PageView extends JPanel implements MainObserver {

	private Page page;
	private MainModel model;
	private JPanel content;
	private EmptyBorder emptyBorder;
	private EmptyBorder innerTitledBorder;
	private TitledBorder titledBorder;
	private CompoundBorder compoundBorder;

	public PageView(MainModel model, Page page) {
		this.model = model;
		this.model.addObserver(this);
		this.setPage(page);
		this.page.addObserver(this);
	
		setMaximumSize(Constants.PAGE_SIZE);
		setPreferredSize(Constants.PAGE_SIZE);
		setMinimumSize(Constants.PAGE_SIZE);
		setBackground(Color.LIGHT_GRAY);
		setAlignmentY(CENTER_ALIGNMENT);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		emptyBorder = new EmptyBorder(Constants.PAGE_TOP_MARGIN, 0, Constants.PAGE_BOTTOM_MARGIN, 0);
		innerTitledBorder = new EmptyBorder(0, 0, 0, 0);
		titledBorder = BorderFactory.createTitledBorder(innerTitledBorder, this.getPage().getName());
		titledBorder.setTitlePosition(TitledBorder.BELOW_BOTTOM);
		titledBorder.setTitleJustification(TitledBorder.CENTER);
		compoundBorder = new CompoundBorder(emptyBorder, titledBorder);
		this.setBorder(compoundBorder);
		
		content = new JPanel();
		content.setBackground(page.getColor());
		add(content);
	}
	
	@Override
	public void update(NotificationObserver notification, Object obj) {
		if (notification == NotificationObserver.ADD) {
			if (obj instanceof Slot) {
				Slot slot = (Slot) obj;
				addNewChildView(slot);
				validate();
				repaint();
			}
		}
		else if (notification == NotificationObserver.DELETE) {
			SlotView slotView = findSlot((Slot) obj);
			
			try {
				content.remove(slotView);
				adjustSlotSizes();
				validate();
				repaint();
			}
			catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
		else if (notification == NotificationObserver.NODE_RENAME) {
			titledBorder.setTitle(this.getPage().getName());
			repaint();
		}
	}
	
	public void addNewChildView(Slot slot) {
		SlotView slotView = new SlotView(model, slot);
		content.add(slotView);
		adjustSlotSizes();
	}
	
	private void adjustSlotSizes() {
		int factor = Math.max(2, content.getComponents().length);
		int availableHeight = content.getHeight() - factor * 5;

		for (Component c : content.getComponents()) {
			if (c instanceof SlotView) 
				c.setPreferredSize(new Dimension(content.getWidth(), availableHeight / factor));
		}
	}
	
	private SlotView findSlot(Slot slot) {
		for (Component c : content.getComponents()) {
			if (c instanceof SlotView) {
				SlotView slotView = (SlotView) c;

				if (slotView.getSlot() == slot) 
					return slotView;
			}
		}
		
		return null;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}