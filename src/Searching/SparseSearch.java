package Searching;

/**
 * @author Nagaraju Budigam
 *
 */
public class SparseSearch {
	/*
	 * Given a sorted array of strings that is intercepted with empty strings,
	 * write a method to find the location of the given string
	 * 
	 * I/P: ball, {"at", "", "", "", "ball","", "", "car","", "", "dad","", ""}
	 * O/P: 4
	 * 
	 * This solution runs in O(log n) in best case and O(n) in worst case.
	 */

	public static void main(String[] args) {
		String[] a = { "at", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "peak" };
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " : " + i + "  ");
		System.out.println("\n" + sparseSearch(a, "at"));
		System.out.println();

	}

	public static int sparseSearch(String[] a, String s) {
		int left = 0, right = a.length - 1, mid;
		mid = (left + right) / 2;
		while (left <= right) {
			if (a[mid].isEmpty()) {
				/*If the a[mid] is empty, find the nearest non empty string*/
				for (mid++; mid < right; mid++) {
					if (!a[mid].isEmpty())
						break;
				}
			} else {// a[mid] is not empty
				if (a[mid].equals(s))
					return mid;
				else if (a[mid].compareTo(s) > 0){
					/*s occurs before a[mid], update right value*/
					right = mid - 1;
				}
				else{
					/*s occurs after a[mid], update left value*/
					left = mid + 1;
				}
				mid = (left + right) / 2;
				/*
				 * compute mid value when a[mid] is not empty otherwise this may
				 * override the mid value which is computed for the empty string
				 */
			}
		}
		return -1;
	}
}
