package gui.model.tree;

import java.io.Serializable;
import java.util.Enumeration;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import gui.observer.NotificationObserver;


public class NodeLink extends Node implements Serializable {

	final static long serialVersionUID = 1;

	private Node original;

	public NodeLink(Node original) {
		this.original = original;
	}

	public Node getOriginal() {
		return this.original;
	}

	@Override
	public Enumeration<Node> children() {
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int index) {
		return this.original.getChildAt(index);
	}

	@Override
	public int getChildCount() {
		return this.original.getChildCount();
	}

	@Override
	public int getIndex(TreeNode node) {
		return this.original.getChildren().indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		return this.parent;
	}

	@Override
	public boolean isLeaf() {
		return this.original.isLeaf();
	}

	@Override
	public void insert(MutableTreeNode child, int index) {
		this.original.insert(child, index);
	}

	@Override
	public void remove(int index) {
		this.original.remove(index);
	}

	@Override
	public void remove(MutableTreeNode child) {
		this.original.remove(child);
	}

	@Override
	public void removeFromParent() {
		this.parent.children.remove(this);
		this.parent.observerList.notifyObservers(NotificationObserver.DELETE, this);
	}

	@Override
	public void setParent(MutableTreeNode parent) {
		this.parent = (Node) parent;
	}

	@Override
	public void setUserObject(Object obj) {

	}

	@Override
	public String toString() {
		return this.original.getName();
	}
}