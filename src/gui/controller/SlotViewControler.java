package gui.controller;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.listeners.DoubleClickListener;
import gui.model.ElementType;
import gui.model.MainModel;
import gui.model.Slot;
import gui.view.SlotView;

public class SlotViewControler {
	
	private MainModel model;
	private SlotView slotView;
	
	public SlotViewControler(MainModel model, SlotView slotView) {
		this.model = model;
		this.slotView = slotView;
		slotView.setDoubleClickListener(new DoubleClickListener(model));
	}
	
	

}
