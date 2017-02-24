package org.daniel.java.algorithms.sort;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {
	private QuickSort quickSort;
	private char[] testInput;
	
	@Before 
	public void init() {
		quickSort = new QuickSort();
		testInput = "unsorted".toCharArray(); 
	}
	
	@Test
	public void charOrder_test() {
		assertTrue('a' < 'b');
	}
	
	@Test
	public void swap_test() {
		char[] input = "ba".toCharArray();
		quickSort.swap(input, 0, 1);
		assertEquals('a', input[0]);
		assertEquals('b', input[1]);
	}
	
	@Test
	public void partition_test() {
		int pivot = quickSort.partition(testInput, 0, testInput.length-1, testInput.length/2);
		assertEquals(testInput.length/2, pivot);
		assertTrue(Arrays.equals("dneortsu".toCharArray(), testInput));
	}
	
	@Test
	public void partition_testinorder() {
		testInput = "abcd".toCharArray();
		int pivot = quickSort.partition(testInput, 0, testInput.length-1, testInput.length/2);
		assertEquals(2, pivot);
	}
	
	@Test
	public void quicksort_test() {
		char[] sorted = quickSort.quickSort(testInput, 0, testInput.length-1);
		assertTrue(Arrays.equals("denorstu".toCharArray(), sorted));
	}
	
	@Test
	public void quicksort_testinorder() {
		testInput = "abcd".toCharArray();
		char[] sorted = quickSort.quickSort(testInput, 0, testInput.length-1);
		assertTrue(Arrays.equals("abcd".toCharArray(), sorted));
	}
	
	@Test
	public void quicksorttwo_test() {
		char[] sorted = quickSort.quickSortTwo("quicksort".toCharArray(), 0, 8);
		assertTrue(Arrays.equals("cikoqrstu".toCharArray(), sorted));
	}
}
