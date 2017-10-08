package Sorting;

/**
 * @author Nagaraju Budigam
 *
 */
public class BucketSort {
	/*
	 * Bucket Sort (or) Bin Sort is a linear Sorting Algorithm runs in O(nk)
	 * where k is the no.of buckets (constant value). So, the time complexity is O(n)
	 * 
	 * I/P: 2 3 1 5 3 6 3 7 8 2 1 8 4 3 
	 * O/P: 1 1 2 2 3 3 3 3 4 5 6 7 8 8 
	 */
	public static void main(String[] args) {
		int[] a={2,3,1,5,3,6,3,7,8,2,1,8,4,3};
		bucketSort(a,10);
	}
	/**
	 * @param array to be sorted
	 * @param n : number of buckets
	 */
	private static void bucketSort(int[] a, int n){
		int i,j,k;
		int[] buckets=new int[n];
		for(i=0; i<a.length; i++)
			buckets[a[i]]++;
		System.out.print("I/P: ");
		for(int x:a)System.out.print(x+" ");
		System.out.println();
		for(i=0, j=0; j<buckets.length; j++)
			for(k=buckets[j]; k>0; k--)
				a[i++]=j;
		System.out.print("O/P: ");
		for(int x:a)System.out.print(x+" ");
	}

}
