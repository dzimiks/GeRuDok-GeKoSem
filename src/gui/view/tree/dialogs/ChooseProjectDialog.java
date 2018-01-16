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

import gui.controller.tree.ChooseProjectDialogController;
import gui.model.MainModel;
import gui.model.Workspace;
import gui.model.tree.Node;
import gui.view.MainView;


@SuppressWarnings("serial")
public class ChooseProjectDialog extends JDialog {

	private MainModel model;
	private Node shared;
	private JButton btnOk;
	private JList<Node> list;
	private ChooseProjectDialogController controller;

	public ChooseProjectDialog(MainModel model, Node shared) {
		super(MainView.getInstance(), "Project selection", ModalityType.APPLICATION_MODAL,
			  MainView.getInstance().getGraphicsConfiguration());
		
		this.model = model;
		this.shared = shared;

		this.setLayout(new BorderLayout());
		
		JLabel lblWelcome = new JLabel("Select the project to share the document with:");
		lblWelcome.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblWelcome.setAlignmentY(CENTER_ALIGNMENT);
		this.add(lblWelcome, BorderLayout.NORTH);

		DefaultListModel<Node> listModel = new DefaultListModel<>();
		list = new JList<Node>(listModel);
		this.add(list, BorderLayout.CENTER);

		for (Node node : Workspace.getInstance().getChildren()) 
			if (node != shared.getParent())
				listModel.addElement(node);

		btnOk = new JButton("Share with selected project");
		btnOk.setEnabled(false);
		this.add(btnOk, BorderLayout.SOUTH);

		setPreferredSize(new Dimension(380, 300));
		pack();
		setLocationRelativeTo(null);

		this.controller = new ChooseProjectDialogController(model, this);
	}

	public void enableBtnOk() {
		this.btnOk.setEnabled(this.list.getSelectedValuesList().size() != 0);
	}

	public List<Node> getSelected() {
		return this.list.getSelectedValuesList();
	}

	public Node getShared() {
		return this.shared;
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
