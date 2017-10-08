package Searching;

import java.util.Scanner;

/**
 * @author Nagaraju Budigam
 *
 */
public class SortedMatrixSearch {
	/*
	 * Given an MxN matrix in which each row and column is sorted in ascending
	 * order, write a method to find an element
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] a = { { 15, 20, 40, 85 }, { 20, 35, 80, 95 }, { 30, 55, 95, 105 }, { 40, 80, 100, 120 } };
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.print("\nEnter the element to search: ");
		int n = in.nextInt();
		in.close();
		System.out.println("\nSearching for " + n + " found ?:" + (findX(a, n) < 1 ? " No" : " Yes"));

	}

	/*
	 * Simple Solution, perform binary search on each row of the matrix. This
	 * solution runs in O(M logN) time, where m is the no.of rows and N no.of
	 * columns
	 */
	public static int binarySearchSol(int[][] a, int n) {
		for (int i = 0; i < a.length; i++) {
			if (binarySearch(a[i], n) == 1)
				return 1;
			binarySearch(a[i], n);
		}
		return -1;
	}

	/* Standard Binary Search Algorithm runs in O(log n) time */
	public static int binarySearch(int[] a, int n) {
		int left = 0, right = a.length - 1, mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (n == a[mid])
				return 1;
			else if (n > a[mid])
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}
	/*
	 * Observations: 
	 * 	1.If the start of a column is less than x, then x is to the left of the column. 
	 * 	2.If the end of a column is less than x, then x is to the right of the column. 
	 * 	3.If the start of a row is greater than x, then x is above that row.
	 *  4. If the end of a row is less than x, then x is below that row.
	 * 
	 * From the observations above we can provide solutions using observations 1 and 4
	 * 
	 * This solution runs in O(log n) time.
	 */
	
	public static int findX(int[][] a, int n){
		int row=0, col=a[0].length-1;
		//start from the the right most column i.e a.length-1 search till 0th column 
		while(row<a.length && col>=0){
			if(a[row][col]==n) return 1;
			else if(a[row][col]>n) col--;/*a[row][col] > n, then n will be present left of that column*/ 
			else row++;/*a[row][col] < n, then n will be present below of that row*/
		}
		return -1;
	}
}
