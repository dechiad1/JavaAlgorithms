package org.daniel.java.JavaGraph;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DFSTest extends GraphSetup {
	private DFS dfs;
	
	@Before
	public void init_dfs() {
		graph.setDirected(false);
		dfs = new DFS(graph);
		dfs.setProcessEdge(false);
		dfs.setProcessVertexEarly(false);
		dfs.setProcessVertexLate(false);
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
	 * dfs of graph starting at node 1
	 * 
	 * initial dfs call will create the ancestor array 
	 * starting at node 1
	 * 
	 * toString will convert the ancestor array to a 
	 * string using the values of each node in the array
	 * 
	 * The index of the ancestors array corresponds to order
	 * in which a node was added to the graph. This value gets
	 * set during 'graph.addVertex(node)'
	 * 
	 * The value at each index represents the parent of the node
	 * for the most recent run of dfs
	 */
	@Test
	public void dfs_test_node1() {
		String expected = "163923748";
		dfs.dfs(one, 1);
		String actual = dfs.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void dfs_test_node4() {
		String expected = "416123758";
		dfs.dfs(four, 4);
		String actual = dfs.toString();
		assertEquals(expected, actual);
	}
	
}
