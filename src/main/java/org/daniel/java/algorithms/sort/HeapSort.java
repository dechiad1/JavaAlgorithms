package org.daniel.java.algorithms.sort;


/* HeapSort with a priority queue
 * build on an array
 * Implement min dominating queue
 */
public class HeapSort {
	private int[] q;
	private int last = 0;
	
	public int parent(int n) {
		if(n <= 1) {
			return 1; //parent
		} else {
			return (n/2);
		}
	}
	
	public int youngChild(int n) {
		if((2*n) > q.length) {
			return 0;
		}
		return (2*n);
	}
	
	public void init(int n) {
		/* use 1 as the root index for easy parent/child
		 * calculation
		 */
		q = new int[n+1];
		q[0] = Integer.MAX_VALUE;//nothing can be less than the buffer
	}
	
	public void insert(int item) {
		if(last == 0) {
			q[1] = item; //make element root
			last++;
			return;
		} 
		
		if(item < q[parent(last+1)]) {
			q[last+1]=item;
			last++;
			bubbleUp(parent(last), last);
		} else {
			q[last+1]=item;
			last++;
		}	
	}
	
	public void bubbleUp(int parent, int child) {
		swap(parent, child);
		//parent position in array now holds ex child value
		//recursive call to satisfy domination relationship
		if(q[parent] < q[parent(parent)]) {
			bubbleUp(parent(parent), parent);
		}
	}
	
	public int getMin() {
		int temp = q[1];
		q[1] = q[last];
		q[last] = Integer.MAX_VALUE;
		last--;
		bubbleDown(1, youngChild(1));
		return temp;
	}
	
	public void bubbleDown(int parent, int child) {
		/*  1. if leaf, return
		 *  2. loop through both possible children & get min
		 *  3. if min is smaller, swap
		 *  4. recursive call on child
		 */
		if(child == 0) {
			return;
		}

		int min = q[parent];
		int minChild = parent;
		
		for(int i = 0; i<= 1; i++) {
			if((child+i) <= last) {
				if(min > q[child+i]) {
					min = q[child+i];
					minChild = child+i;
				}
			}
		}
		if(minChild != parent) {
			swap(parent, minChild);
			bubbleDown(minChild, youngChild(minChild));
		}
	}
	
	private void swap(int n, int m) {
		int temp = q[n];
		q[n] = q[m];
		q[m] = temp;
	}
	
	public void createHeap(int[] arr) {
		for(int i : arr) {
			insert(i);
		}
	}
	
	public void printQueue() {
		for(int i = 1; i <= last; i++) {
			System.out.println("position: " + i + " value " + q[i]);
		}
	}
	
	public String stringQueue() {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= last; i++) {
			sb.append(q[i]);
		}
		return sb.toString();
	}
}
