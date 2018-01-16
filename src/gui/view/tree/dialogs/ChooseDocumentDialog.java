package gui.view.tree.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

import gui.controller.tree.ChooseDocumentDialogController;
import gui.model.MainModel;
import gui.model.tree.Node;
import gui.view.MainView;


@SuppressWarnings("serial")
public class ChooseDocumentDialog extends JDialog {

	private MainModel model;
	private Node parent;
	private JButton btnOk;
	private JList<Node> list;
	private ChooseDocumentDialogController controller;
	
	public ChooseDocumentDialog(MainModel model, Node parent) {
		super(MainView.getInstance(), "Free Documents", ModalityType.APPLICATION_MODAL, 
			  MainView.getInstance().getGraphicsConfiguration());
		
		this.model = model;
		this.parent = parent;
		
		this.setLayout(new BorderLayout());
		
		JLabel lblWelcome = new JLabel("Select the document that you want to add to the project:");
		lblWelcome.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblWelcome.setAlignmentY(CENTER_ALIGNMENT);
		this.add(lblWelcome, BorderLayout.NORTH);
		
		DefaultListModel<Node> listModel = new DefaultListModel<>();
		
		list = new JList<>(listModel);
		
		this.add(list, BorderLayout.CENTER);
		
		for (Node node : this.model.getFreeDocuments()){
			listModel.addElement(node);
		}
		
		btnOk = new JButton("Import selected documents");
		btnOk.setEnabled(false);
		this.add(btnOk, BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(380, 300));
		pack();
		setLocationRelativeTo(null);
		
		this.controller = new ChooseDocumentDialogController(model, this);
	}
	
	public void enableBtnOk() {
		this.btnOk.setEnabled(this.list.getSelectedValuesList().size() != 0);
	}
	
	public List<Node> getSelected() {
		return this.list.getSelectedValuesList();
	}

	public Node getParentNode() {
		return this.parent;
	}
	
	public void addSelectionChangedListener(ListSelectionListener listener) {
		this.list.addListSelectionListener(listener);
	}

	public void addBtnOkListener(ActionListener listener) {
		this.btnOk.addActionListener(listener);
	}

	public void addDoubleClickListener(MouseListener listener) {
		this.list.addMouseListener(listener);
	}
}