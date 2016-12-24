package org.daniel.java.algorithms.tree;

import static org.junit.Assert.assertEquals;

import org.daniel.java.algorithms.tree.InOTTree;
import org.junit.Before;
import org.junit.Test;

public class InOTTreeTest extends TreeSetup{
	InOTTree iot;
	String expected;
	
	//In OT of tree is dbfehgiac
	@Before
	public void init_iot() {
		iot = new InOTTree();
		expected = "dbfehgiac";
	}
	
	@Test
	public void recursiveIOT_test() {
		String result = iot.recursiveIOT(a);
		assertEquals(expected, result);
	}
	
	@Test
	public void iterativeIOT_test() {
		String result = iot.iterativeIOT(a);
		assertEquals(expected, result);
	}
	
	@Test
	public void iterativeIOTWithLessSpace_test() {
		String result = iot.iteravtiveIOTWithLessSpace(a);
		assertEquals(expected, result);
	}
}
