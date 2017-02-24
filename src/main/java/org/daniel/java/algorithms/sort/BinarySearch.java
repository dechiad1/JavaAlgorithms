package org.daniel.java.algorithms.sort;

public class BinarySearch {
	
	/* Binary search that runs in log(n) time.
	 * Input array must be sorted
	 */
	public int binarySearch(char[] toSearch, char toFind) {
		int low = 0;
		int high = toSearch.length-1;
		
		while (low <= high) {
			int middle = (high + low)/2;
			if(toSearch[middle] < toFind) {
				low = middle+1;
			}
			else if(toSearch[middle] > toFind){
				high = middle-1;
			}
			else return middle;
		}
		return -1;
	}
}
