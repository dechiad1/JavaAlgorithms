package org.daniel.java.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private List<Node> edges;
	private Object value;
	private int index;
	
	public Node(Object v) {
		edges = new ArrayList<Node>();
		value = v;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}

	/*
	 * Node operations to support graph functionality
	 * Edges are maintained at the node level
	 */
	public int numEdges() {
		return this.edges.size();
	}
	public void addEdge(Node n) {
		this.edges.add(n);
	}
	public void removeEdge(Node n) {
		edges.remove(n);
	}
	public List<Node> getEdges() {
		return edges;
	}
	
}
