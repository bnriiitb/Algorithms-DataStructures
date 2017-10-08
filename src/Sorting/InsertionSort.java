package Sorting;

public class InsertionSort {
	/*
	 * Comparison based Sorting algorithm
	 */
	public static void main(String[] args) {
		int[] a = { 2, 1, 5, 3, 6, 7, 9, 34, 22, 76, 21 };
		insertionSort(a);
	}

	public static void insertionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int t = a[i];
			int j = i;
			while (j > 0 && a[j - 1] > t) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = t;
		}
		for (int x : a)
			System.out.print(x + " ");
	}
}
