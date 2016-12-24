package org.daniel.java.algorithms.sort;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {
	private BinarySearch searchUtil;
	private char[] testString;
	
	@Before
	public void init() {
		testString = "abcdefghijk".toCharArray();
		searchUtil = new BinarySearch();
	}
	
	@Test
	public void binarySearch_chartest() {
		int eIndex = searchUtil.binarySearch(testString, 'e');
		assertEquals(4, eIndex);
		int aIndex = searchUtil.binarySearch(testString, 'a');
		assertEquals(0, aIndex);
		int kIndex = searchUtil.binarySearch(testString, 'k');
		assertEquals(testString.length-1, kIndex);
	}
}
