package org.daniel.java.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private Graph graph;
	private boolean[] discovered;
	private boolean[] processed;
	private Node[] ancestor;
	
	/*
	 * boolean switches to control which vertex/edge processing to use
	 */
	private boolean processVertexEarly = false;
	private boolean processVertexLate = false;
	private boolean processEdge = false;
	
	public BFS(Graph g) {
		graph = g;
		discovered = new boolean[g.size()];
		processed = new boolean[g.size()];
		ancestor = new Node[g.size()];
	}
	
	/**
	 * Breadth first search of a graph. Runs in O(v + e), where v and e are 
	 * the amount of vertexes and edges, respectively 
	 * @param node - acting root node of graph
	 * @param value - value to find, if at all
	 */
	public void bfs(Node n, int value) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		discovered[n.getIndex()] = true;
		
		while(!q.isEmpty()) {
			Node node = q.remove();
			if(processVertexEarly) {
				processVertexEarly(node, value);
			}
			for(Node child : node.getEdges()) {
				int currentIndex = child.getIndex();
				if(!discovered[currentIndex]) {
					ancestor[currentIndex] = node;
					discovered[currentIndex] = true;
					q.add(child);
				}
				if((!processed[currentIndex] || graph.isDirected()) && processEdge) {
					processEdge(node, child, value);
				}
			}
			if(processVertexLate) {
				processVertexLate(node, value);
			}
			processed[node.getIndex()] = true;
		}
	}

	private void processVertexEarly(Node node, int value) {
		System.out.println("process node " + node.getValue() + " early");
	}
	private void processVertexLate(Node node, int value) {
		System.out.println("process node " + node.getValue() + " late");
	}
	private void processEdge(Node node, Node child, int value) {
		System.out.println("process edge of " + node.getValue() + " and " + child.getValue());
	}

	
	/**
	 * Print the ancestors as a string - to be used to verify testing
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Node node : ancestor) {
			//node of root is null, as it has no parent
			if(node != null) {sb.append(node.getValue());}
		}
		return sb.toString();
	}
	
public void setProcessVertexEarly(boolean processVertexEarly) {
	this.processVertexEarly = processVertexEarly;
}
public void setProcessVertexLate(boolean processVertexLate) {
	this.processVertexLate = processVertexLate;
}
public void setProcessEdge(boolean processEdge) {
	this.processEdge = processEdge;
}
}
