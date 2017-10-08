package Arrays;

public class DNFlag012Sort {
	/*
	 * for the input like 0 0 0 0 0 1 1 1 1 1 2 2 code performs unnecessary
	 * swaps to avoid that perform swap if the numbers are not same.
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 0, 0, 1, 2, 1, 2, 1, 0, 1 };
		System.out.print("I/P: ");
		for (int x : a)
			System.out.print(x + " ");
		System.out.println();
		DNFsort012(a);
		System.out.print("O/P: ");
		for (int x : a)
			System.out.print(x + " ");
		System.out.println();
	}

	public static void DNFsort012(int[] a) {
		int l = 0, m = 0, h = a.length - 1;
		while (m <= h) {
			switch (a[m]) {
			case 0:
				if (a[m] != a[l])
					swap(a, m, l);
				l++;
				m++;
				break;
			case 1:
				m++;
				break;
			case 2:
				if (a[m] != a[h])
					swap(a, m, h);
				h--;
				break;
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
