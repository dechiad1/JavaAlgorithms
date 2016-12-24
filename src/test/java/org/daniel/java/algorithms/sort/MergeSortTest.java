package org.daniel.java.algorithms.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
	private MergeSort mergeSort;
	
	@Before
	public void init() {
		mergeSort = new MergeSort();
	}
	
	@Test 
	public void merge_testsinglemerge() {
		char[] sorted = mergeSort.merge("c".toCharArray(), "b".toCharArray());
		assertTrue(Arrays.equals("bc".toCharArray(), sorted));
	}
	
	@Test 
	public void merge_testlongermerge() {
		char[] sorted = mergeSort.merge("acx".toCharArray(), "bdz".toCharArray());
		assertTrue(Arrays.equals("abcdxz".toCharArray(), sorted));
	}
	
	@Test
	public void mergeSort_testshort() {
		char[] sorted = mergeSort.mergeSort("cb".toCharArray());
		assertTrue(Arrays.equals("bc".toCharArray(), sorted));
	}
	
	@Test 
	public void mergeSort_testlongermerge() {
		char[] sorted = mergeSort.mergeSort("bzadxzdc".toCharArray());
		assertTrue(Arrays.equals("abcddxzz".toCharArray(), sorted));
	}
}
