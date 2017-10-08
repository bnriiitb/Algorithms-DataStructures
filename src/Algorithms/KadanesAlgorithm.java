package Algorithms;

public class KadanesAlgorithm {

	/*
	 * Kadane's Algorithm: Used to get the maximum sub-array
	 */
	public static void main(String[] args) {
		int a[]={1,2,-3,4,-5};
		System.out.println(getMaximumSubarray(a));

	}
	public static int getMaximumSubarray(int[] a){
		int max_so_far=a[0];
		int max_ending_here=a[0];
		for(int i=1; i<a.length; i++){
			max_ending_here=Math.max(a[i], max_ending_here+a[i]);
			max_so_far=Math.max(max_ending_here, max_so_far);
		}
		return max_so_far;
	}

}
