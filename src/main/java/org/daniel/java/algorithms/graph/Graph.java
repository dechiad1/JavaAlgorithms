package org.daniel.java.algorithms.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
	private Set<Node> graph;
	private boolean directed;
	
	public Graph() {
		graph = new HashSet<Node>();
	}
	
	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}
	
	/* add and remove vertex 
	 * adding a vertex sets its index to current size plus one
	 * removing a vertex removes all edges containing it
	 */
	
	public void addVertex(Node n) {
		n.setIndex(size());
		graph.add(n);
	}
	
	public void removeVertex(Node n) {
		List<Node> edges = n.getEdges();
		for(Node node : edges) {
			node.removeEdge(n);
		}
		graph.remove(n);	
	}

	public boolean contains(Node n) {
		return graph.contains(n);
	}
	
	public int size() {
		return graph.size();
	}

}
