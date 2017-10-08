package Searching;

import java.util.Scanner;

import Sorting.QuickSort;

/**
 * @author Nagaraju Budigam
 *
 */
public class BinarySearch {
	/* Standard Binary Search Algorithm Implementation runs in O(log n) time */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] ar = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] a = { 2, 20, 3, 44, 32, 65, 34, 333, 7, 55, 42, 24, 32, 121, 90, 9 };
		System.out.println("Before Sort: ");
		for (int x : a)
			System.out.print(x + " ");
		System.out.println();
		QuickSort.quickSort(a, 0, a.length - 1);
		System.out.println("After Sort: ");
		System.out.println();
		System.out.print("Enter element to Search: ");
		int n = in.nextInt();
		System.out.println("Searching for " + n + "....Found ? : " + binarySearch(a, n));
		in.close();

	}

	private static boolean binarySearch(int[] a, int n) {
		int left = 0, right = a.length - 1;
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (n == a[mid])
				return true;
			else if (n < a[mid]) {
				right = mid - 1;
			} else { // n > a[mid]
				left = mid + 1;
			}
		}
		return false;
	}

}
