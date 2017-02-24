package org.daniel.java.algorithms.queue;

public class PriorityQueue {
	private int[] array;
	private int last = 0;
	
	public PriorityQueue() {
	
	}
	
	public void init(int n) {
		array = new int[n];
	}
	
	public int getSize() {
		return array.length;
	}
	
	public int getLast() {
		return last;
	}

	public void push(int item) {
		array[last] = item;
		last++;
	}
	
	public int pull(int i) {
		return array[i];
	}
	
	public void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = array[temp];
	}
	
	public void decrementLast() {
		last--;
	}
}
