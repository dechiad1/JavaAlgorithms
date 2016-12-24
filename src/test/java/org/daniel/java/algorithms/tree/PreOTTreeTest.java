package org.daniel.java.algorithms.tree;

import static org.junit.Assert.assertEquals;

import org.daniel.java.algorithms.tree.PreOTTree;
import org.junit.Before;
import org.junit.Test;

public class PreOTTreeTest extends TreeSetup {
	PreOTTree pot;
	String expected; 
	
	//Pre OT of tree is abdefghic
	@Before
	public void init_pot() {
		pot = new PreOTTree();
		expected = "abdefghic";
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
