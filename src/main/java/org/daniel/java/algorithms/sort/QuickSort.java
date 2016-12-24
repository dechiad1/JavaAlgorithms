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
	
	public void swap(char[] unsorted, int x, int y) {
		char temp = unsorted[x];
		unsorted[x] = unsorted[y];
		unsorted[y] = temp;
	}

}
