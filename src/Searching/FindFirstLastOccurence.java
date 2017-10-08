package Searching;

public class FindFirstLastOccurence {
	/*
	 * Find the first and last occurence of an element in the sorted array.
	 * Solution: Modification of Binary Search which runs in O(log n)
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 4, 4,5, 6, 7, 9, 10 };
		System.out.println(getLastOccurence(a, 4));

	}

	public static int getFirstOccurence(int[] a, int n) {
		int result = -1;
		int low = 0, mid = 0, high = a.length - 1;
		while (low <= high) {
			mid = (high + low) / 2;
			if (a[mid] >= n) {
				result = mid;
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return result;
	}

	public static int getLastOccurence(int[] a, int n) {
		int result = -1;
		int low = 0, mid = 0, high = a.length - 1;
		while (low <= high) {
			mid = (high + low) / 2;
			if (a[mid] <= n) {
				result = mid;
				low = mid + 1;
			} else
				high = mid - 1;

		}
		return result;
	}

}
