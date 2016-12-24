package org.daniel.java.algorithms.tree;

public class Node {
	private Node left;
	private Node right;
	private String Id;
	
	public Node(String id) {
		Id = id;
	}
	
	public boolean hasLeft() {
		return left != null;
	}
	
	public boolean hasRight() {
		return right != null;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setLeft(Node n) {
		left = n;
	}
	
	public void setRight(Node n) {
		right = n;
	}
	
	public String toString() {
		return Id;
	}

}
