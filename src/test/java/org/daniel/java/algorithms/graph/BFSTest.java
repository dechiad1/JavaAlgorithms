package org.daniel.java.algorithms.graph;

import static org.junit.Assert.assertEquals;

import org.daniel.java.algorithms.graph.BFS;
import org.junit.Before;
import org.junit.Test;

public class BFSTest extends GraphSetup{
	private BFS bfs;
	
	@Before
	public void init_bfs() {
		graph.setDirected(false);
		bfs = new BFS(graph);
		bfs.setProcessEdge(false);
		bfs.setProcessVertexEarly(false);
		bfs.setProcessVertexLate(false);
	}
	
	/** graph:
	 * 				  1
	 * 			   /     \
	 *            /\     /\
	 *           2  3 - 4  5
	 *           | / \   \/
	 *           6    7   9
	 *               / \
	 *              8 - 10
	 */
	
	/**
	 * bfs of graph starting at node 1
	 * 
	 * initial call of bfs will create the ancestor array 
	 * starting the traversal at node 1
	 * 
	 * toString will convert the ancestor array into a string, 
	 * ignoring null values
	 * 
	 * The index corresponds to each node in the graph
	 * and is set when a vertex is added to the graph.
	 * 
	 * The value at each index denotes the node's parent
	 * for this particular search 
	 */
	@Test
	public void bfs_test_node1() {
		String expected = "111123747";
		bfs.bfs(one, 1);
		String actual = bfs.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void bfs_test_node6() {
		String expected = "266313747";
		bfs.bfs(six, 6);
		String actual = bfs.toString();
		assertEquals(expected, actual);
	}
}
