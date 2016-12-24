package org.daniel.java.algorithms.sort;

public class BinarySearch {
	
	/* Binary search that runs in log(n) time.
	 * Input array must be sorted
	 */
	public int binarySearch(char[] toSearch, char toFind) {
		int index = toSearch.length/2;
		
		while (!(toSearch[index] == toFind)) {
			if(toSearch[index] < toFind) {
				index += index/2;
			}
			else {
				index /= 2;
			}
		}
		return index;
	}
}
