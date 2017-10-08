package Sorting;

public class QuickSort {
	/*
	 * Comparison based Sorting algorithm
	 */
	public static void main(String[] args) {
		int[] a = { 9, 7, 5, 3, 5, 2, 3, 22, 15, 56, 32, 33, 24 };
		System.out.print("I/P: ");
		for (int x : a)
			System.out.print(x + " ");
		System.out.println();
		quickSort(a, 0, a.length - 1);
		System.out.print("O/P: ");
		for (int x : a)
			System.out.print(x + " ");
		System.out.println();

	}

	public static void quickSort(int[] a, int left, int right) {
		int index = partition(a, left, right);
		if (left < index - 1) {
			quickSort(a, left, index - 1);// sort left half
		}
		if (index < right) {
			quickSort(a, index, right);// sort right half
		}
	}

	public static int partition(int[] a, int left, int right) {
		int pivot = a[(left + right) / 2];
		while (left <= right) {
			// find element on the left that should be on right
			while (a[left] < pivot)
				left++;
			// find the element on right that should be on left
			while (a[right] > pivot)
				right--;
			// swap the elements, and move left and right indices
			if (left <= right) {
				swap(a, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static void swap(int[] a, int left, int right) {
		int t = a[left];
		a[left] = a[right];
		a[right] = t;
	}

}
