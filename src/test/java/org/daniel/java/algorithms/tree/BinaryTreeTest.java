package org.daniel.java.algorithms.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
	private Node root;
	private Node child1;
	private Node child2;
	private Node toFind;
	
	@Before
	public void init() {
		root = new Node();
		child1 = new Node();
		child2 = new Node();
		
		root.setValue(5);
		child1.setValue(3);
		child2.setValue(9);
		root.insert(child1);
		root.insert(child2);
		
		Node child3 = new Node();
		child3.setValue(1);
		root.insert(child1);
		root.insert(child3);
		
		Node child4 = new Node();
		child4.setValue(0);
		root.insert(child4);
		
		toFind = new Node();
	}
	
	@Test
	public void insertNode_test() {
		assertEquals(3, root.getLeft().getValue());
	}
	
	@Test
	public void insertMultiNode_test() {
		assertEquals(0, root.getLeft().getLeft().getLeft().getValue());
	}
	
	@Test
	public void find_nulltest() {
		toFind.setValue(18);
		assertNull(root.find(toFind));
	}
	
	@Test
	public void find_existingtest() {
		toFind.setValue(3);
		assertEquals(3, root.find(toFind).getValue());
	}
	
	@Test
	public void find_multiexistingtest() {
		toFind.setValue(0);
		assertEquals(0, root.find(toFind).getValue());
	}
	
}
