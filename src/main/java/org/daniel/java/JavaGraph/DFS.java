package org.daniel.java.JavaGraph;

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
