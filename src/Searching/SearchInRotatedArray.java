package Searching;

import java.util.Scanner;

/**
 * @author Nagaraju Budigam
 *
 */
public class SearchInRotatedArray {
	/*
	 * Given a sorted array of n integers that has been rotated an unknown
	 * times. Write code to find an element in the array. You may assume that
	 * the array was originally sorted in increasing order.
	 * 
	 * Example: [15,16,19,20,25,1,3,4,5,7,10,14]
	 * 
	 * As we have customized the Binary Search this solution runs in O(logn) if all the elements are unique.
	 * 
	 * With many duplicates this solution runs in O(n), it's because we will have to search in
	 * both the halves of the array(or sub-array).
	 */

	public static void main(String[] args) {
		int[] a = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
		Scanner in = new Scanner(System.in);
		for (int x : a)
			System.out.print(x + " ");
		System.out.print("\nEnter the element to Search: ");
		int n = in.nextInt();
		in.close();
		System.out.println("Searching for "+n+" found ? : "+search(a, 0, a.length - 1, n));
	}

	public static int search(int[] a, int left, int right, int n) {
		int mid = (left + right) / 2;
		if (n == a[mid])
			return 1;// element found at a[mid]
		if (left > right)
			return -1;// exhausted the search space..element not found
		/*
		 * Either left or right left must be normally ordered. So, find out
		 * which side is normally ordered, then use the normally ordered half,
		 * to figure out which side to search to find n.
		 */
		if(a[left]<a[mid]){//left is normally ordered
			if(n>=a[left] && n<a[mid])
				return search(a, left, mid-1, n);//search in the left half
			else
				return search(a, mid+1, right, n);//search in right half
		}
		else if(a[mid]<a[right]){//same as a[right]>a[mid] i.e right is normally ordered
			if(n>a[mid] && n<=a[right])
				return search(a, mid+1, right, n);//search in the right half
			else
				return search(a, left, mid-1, n);//search in left half
		}
		else if(a[left]==a[mid]){//left half is all repeats
			if(a[right]!=a[mid])//check if a[right] is not same a[mid]
				return search(a, mid+1, right, n);//search in right half
			else{//have to search in both the halves
				/*first search in left half if not found then go ahead with the right half*/
				int result=search(a, left, mid-1, n); 
				if(result==-1)/*if not found in left half search in right half*/
					return search(a, mid+1, right, n);//search in the right half
				else return result;//found in left half return the result
			}
		}
		return -1;
	}
}
