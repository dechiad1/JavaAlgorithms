package org.daniel.java.algorithms.sort;

public class QuickSort {

	public char[] quickSort(char[] unsorted, int start, int end) {
		int index = partition(unsorted, start, end, (start+end)/2);
		
		//recursive calls to sort second half of array,
		//made if the return index is increased past the first element
		if(index > start) {
			quickSort(unsorted, index, end);
		}
		//made if the return index is decremented at all in processing
		if(index < end) {
			quickSort(unsorted, start, index-1);
		}
		
		return unsorted;
	}
	
	public int partition(char[] unsorted, int i, int j, int pivot) {
		while(i<j) {
			//while array item is on the correct side of the pivot, 
			//look at the next one
			while(unsorted[i] < unsorted[pivot]) {
				i++;
			}
			while(unsorted[j] > unsorted[pivot]) {
				j--;
			}
			//if two items are on the wrong side of the pivot, 
			//swap them
			if(i<j) {
				swap(unsorted, i, j);
				i++;
				j--;
			}
		}
		return i;
	}
	
	public char[] quickSortTwo(char[] unsorted, int start, int end) {
		if((end-start) > 0) {
				int p = partitionTwo(unsorted, start, end);
				quickSortTwo(unsorted, start, p-1);
				quickSortTwo(unsorted, p+1, end);
		}
		return unsorted;
	}
	
	public int partitionTwo(char[] s, int start, int end) {
		//set the partition to start initially
		int partition = start;
		for(int i = start; i < end; i++) {
			if(s[i] < s[end]) {
				/* if the current element is less than end element, 
				 * swap with partition (a previous element that is 
				 * not less than the end element
				 */
				swap(s, i, partition);
				partition++;
			}
		}
		swap(s, end, partition); //since partition is greater than end, swap the two
		return partition;
	}
	
	public void swap(char[] unsorted, int x, int y) {
		char temp = unsorted[x];
		unsorted[x] = unsorted[y];
		unsorted[y] = temp;
	}

}
