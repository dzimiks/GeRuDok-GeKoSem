package gui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import gui.model.MainModel;

@SuppressWarnings("serial")
public class StatusBarView extends JPanel {

	private JLabel state = new JLabel("State");
	private JLabel elementType = new JLabel("Element Type");
	private JLabel elementName = new JLabel("Element Name");
	private JLabel position = new JLabel("Position");
	private JLabel dimension = new JLabel("Dimension");
	private MainModel model;

	public StatusBarView(MainModel model) {
		this.model = model;
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		// State label podesavanja
		state.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		state.setBackground(Color.GRAY);
		state.setPreferredSize(new Dimension(170, 20));
		state.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		
		// ElementType label podesavanja
		elementType.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		elementType.setBackground(Color.GRAY);
		elementType.setPreferredSize(new Dimension(170, 20));
		elementType.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		
		// ElementName label podesavanja
		elementName.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		elementName.setBackground(Color.GRAY);
		elementName.setPreferredSize(new Dimension(170, 20));
		elementName.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		
		// Position label podesavanja
		position.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		position.setBackground(Color.GRAY);
		position.setPreferredSize(new Dimension(170, 20));
		position.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		
		// Dimension label podesavanja
		dimension.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		dimension.setBackground(Color.GRAY);
		dimension.setPreferredSize(new Dimension(170, 20));
		dimension.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		
		add(state);
		add(elementType);
		add(elementName);
		add(position);
		add(dimension);
	}

	public String getState() {
		return state.getText();
	}

	public void setState(String state) {
		this.state.setText(state);
	}

	public String getElementType() {
		return elementType.getText();
	}

	public void setElementType(String elementType) {
		this.elementType.setText(elementType);
	}

	public String getElementName() {
		return elementName.getText();
	}

	public void setElementName(String elementName) {
		this.elementName.setText(elementName);
	}

	public String getPosition() {
		return position.getText();
	}

	public void setPosition(String position) {
		this.position.setText(position);
	}

	public String getDimension() {
		return dimension.getText();
	}

	public void setDimension(String dimension) {
		this.dimension.setText(dimension);
	}
}