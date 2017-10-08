package Sorting;

public class MergeSort {
	/*
	 * Comparison based Sorting algorithm
	 */
	public static void main(String[] args) {
		int[] a = { 3, 2, 5, 1, 6, 7, 3, 33, 22, 7, 45345, 23, 2, 97, 0, 4, 3 };
		System.out.print("I/P: ");
		for (int x : a)
			System.out.print(x + " ");
		System.out.println();
		int[] helper = new int[a.length];
		mergeSort(a, helper, 0, a.length - 1);
		System.out.print("O/P: ");
		for (int x : a)
			System.out.print(x + " ");
	}

	public static void mergeSort(int[] a, int[] helper, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(a, helper, low, mid);// Sort left half recursively
			mergeSort(a, helper, mid + 1, high);// Sort right half recursively
			merge(a, helper, low, mid, high);// Merge them
		}
	}

	public static void merge(int[] a, int[] helper, int low, int mid, int high) {
		/* Copy both the halves into helper array */
		for (int i = low; i <= high; i++)
			helper[i] = a[i];
		int helperLeft = low;
		int helperRight = mid + 1;
		int current = low;
		/*
		 * Iterate through helper array. Compare the left and right half,
		 * copying back the smaller element from the two halves into the
		 * original array.
		 */
		while (helperLeft <= mid && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				a[current] = helper[helperLeft];
				helperLeft++;
			} else { /* If the right element is smaller than left element */
				a[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		/*
		 * Copy the rest of the left side of the array into the array into the
		 * target array
		 */
		int remaining = mid - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			a[current + i] = helper[helperLeft + i];
		}
	}
}
