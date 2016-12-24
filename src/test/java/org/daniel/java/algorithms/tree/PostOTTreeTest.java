package org.daniel.java.algorithms.tree;

import static org.junit.Assert.assertEquals;

import org.daniel.java.algorithms.tree.PostOTTree;
import org.junit.Before;
import org.junit.Test;

public class PostOTTreeTest extends TreeSetup {
	PostOTTree pot;
	String expected;
	
	//Post OT of tree is dfhigebca
	@Before
	public void init_pot() {
		pot = new PostOTTree();
		expected = "dfhigebca";
	}
	
	@Test
	public void iterativePOT_test() {
		String result = pot.iterativePOT(a);
		assertEquals(expected, result);	
	}
	
	@Test
	public void recursivePOT_test() {
		String result = pot.recursivePOT(a);
		assertEquals(expected, result);	
	}
	
	@Test
	public void iterativePOTwithLessSpace_test() {
		String result = pot.iterativePOTWithLessSpace(a);
		assertEquals(expected, result);
	}
  }
