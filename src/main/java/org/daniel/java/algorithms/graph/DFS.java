package org.daniel.java.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {
	private Graph graph;
	private boolean[] discovered;
	private boolean[] processed;
	private Node[] ancestor;
	
	private boolean processVertexEarly = false;
	private boolean processVertexLate = false;
	private boolean processEdge = false;
	
	public DFS(Graph g) {
		graph = g;
		discovered = new boolean[g.size()];
		processed = new boolean[g.size()];
		ancestor = new Node[g.size()];
	}

	public void dfs(Node n, int value) {
		discovered[n.getIndex()] = true;
		
		if(processVertexEarly) {
			processVertexEarly(n, value);
		}
		
		for(Node node : n.getEdges()) {
			if(!discovered[node.getIndex()]) {
				ancestor[node.getIndex()] = n;
				dfs(node, value);
			}
			
			if((!processed[node.getIndex()] || graph.isDirected()) && processEdge) {
				processEdge(n, node, value);
			}
		}
		
		if(processVertexLate) {
			processVertexLate(n, value);
		}
		
		processed[n.getIndex()] = true;
	}
	
	/* Find the longest sequence of nodes with value's of either A or B. Nodes can have 
	 * a value of A, B or C. 
	 */
	public List<Node> findPath(Node n, List<Node> soln) {
		discovered[n.getIndex()] = true;
		//test if node is in sequence early
		//DEBUG: System.out.println("at node " + (n.getIndex()+1));
		if(n.getValue() == "A" || n.getValue() == "B") {
			soln.add(n);
		} else {
			soln = new ArrayList<Node>();
		}
		//DEBUG: System.out.println("solution at " + (n.getIndex()+1) + " is " + soln.size() + " long");
		
		List<Node> tempList = new ArrayList<Node>(0);
		for(Node node : n.getEdges()) {
			if(!discovered[node.getIndex()]) {
				//DEBUG: System.out.println("going into " + (node.getIndex()+1) + " from " + (n.getIndex()+1));
				List<Node> childSoln = findPath(node, soln);
				if(childSoln.size() > tempList.size()) {
					tempList = childSoln;
				}
				//DEBUG: System.out.println("soln for " + (n.getIndex()+1) + " is " + soln.size() + " after returning from " + (node.getIndex()+1));
			}
		}
		if(tempList.size() > soln.size()) {
			soln = tempList;
		}
		//DEBUG: System.out.println("node " + (n.getIndex()+1) + " soln length is " + soln.size());
		return soln;
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Node n : ancestor) {
			//node of root is null, as it has no parent
			if(n != null) { sb.append(n.getValue()); }
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
