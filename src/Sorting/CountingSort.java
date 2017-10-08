package Sorting;

/**
 * @author Nagaarju Budigam
 *
 */
public class CountingSort {
	/*
	 * CountingSort is a linear Sorting Algorithm runs in O(n) time.
	 */
	public static void main(String[] args) {
		int[] a = { 2, 3, 1, 2, 4, 3};
		int[] b = new int[a.length];
		System.out.print("I/P: ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		countingSort(a, b, 4);
	}

	private static void countingSort(int[] a, int[] b, int n) {
		int[] c = new int[n];
		for (int i = 0; i < n; i++) {// frequency array
			c[a[i]]++;
		}
		for (int i = 1; i < c.length; i++)// calculate the rank
			c[i] = c[i - 1] + c[i];
		System.out.println("\nCount Array: : ");
		for (int x : c)
			System.out.print(x + " ");
		for (int i = a.length - 1; i >= 0; i--) {
			c[a[i]] = c[a[i]] - 1;
			b[c[a[i]]] = a[i];
		}
		System.out.println("\nO/P: ");
		for (int x : b)
			System.out.print(x + " ");
	}
}
