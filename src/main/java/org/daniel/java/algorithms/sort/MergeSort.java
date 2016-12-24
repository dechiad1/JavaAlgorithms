package org.daniel.java.algorithms.sort;

import java.util.Arrays;

public class MergeSort {

	public char[] mergeSort(char[] unsorted) {
		if(unsorted.length == 1) {
			return unsorted;
		}
		
		char[] left = mergeSort(Arrays.copyOfRange(unsorted, 0, unsorted.length/2));
		char[] right = mergeSort(Arrays.copyOfRange(unsorted, unsorted.length/2, unsorted.length));
		
		return merge(left, right);
	}
	
	public char[] merge(char[] left, char[] right) {
		char[] merged = new char[left.length + right.length];
		int i = 0;
		int j = 0;
		while(i < (left.length) && j < (right.length)) {
			if(left[i] <= right[j]) {
				merged[i+j] = left[i];
				i++;
			} else {
				merged[i+j] = right[j];
				j++;
			}	
		}
		
		while(i < (left.length)) {
			merged[i+j] = left[i];
			i++;
		}
		
		while(j < (right.length)) {
			merged[i+j] = right[j];
			j++;
		}
		
		return merged;
	}

}
