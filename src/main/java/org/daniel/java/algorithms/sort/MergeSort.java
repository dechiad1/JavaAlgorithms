package org.daniel.java.algorithms.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
	
	public char[] mergeSortTwo(char[] unsorted, int low, int high) {
		if(low < high) {
			int middle = Math.floorDiv((high+low), 2);
			mergeSortTwo(unsorted, low, middle);
			mergeSortTwo(unsorted, middle+1, high);
			mergeTwo(unsorted, low, middle, high);
		}
		
		return unsorted;
	}
	
	public char[] mergeTwo(char[] s, int low, int middle, int high) {
		Queue<Character> buffer1 = new LinkedList<Character>();
		Queue<Character> buffer2 = new LinkedList<Character>();
		int i = low;
		for(i = low; i<= middle; i++) {
			buffer1.add(s[i]);
		}
		
		for(i = middle+1; i <= high; i++) {
			buffer2.add(s[i]);
		}
		
		i = low;
		while(!(buffer1.isEmpty() || buffer2.isEmpty())) {
			if(buffer1.peek() < buffer2.peek()) {
				s[i] = buffer1.poll();
			} else {
				s[i] = buffer2.poll();
			}
			i++;
		}
		
		while(!buffer1.isEmpty()) {
			s[i] = buffer1.poll();
			i++;
		}
		
		while(!buffer2.isEmpty()) {
			s[i] = buffer2.poll();
			i++;
		}
		
		return s;
	}

}
