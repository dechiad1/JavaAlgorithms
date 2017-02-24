package org.daniel.java.algorithms.sort;

import org.junit.Before;
import org.junit.Test;

public class HeapSortTest {
	private HeapSort heapSort;
	private int[] input = {7,6,3,5,2,1,23,0,54,2,5,7,8};
	@Before
	public void init() {
		heapSort = new HeapSort();
		heapSort.init(input.length);
	}
	
	@Test
	public void testBubbleUp() {
		for(int i = 0; i < input.length; i++) {
			heapSort.insert(input[i]);
		}
		
		heapSort.printQueue();
	}
	
	@Test
	public void testSort() {
		heapSort.createHeap(input);
		for(int i = 0; i<input.length; i++) {
			input[i] = heapSort.getMin();
		}
		
		System.out.println("sorted: ");
		for(int i = 0; i<input.length; i++) {
			System.out.println(input[i]);
		}
	}
}
