package Searching;

import java.util.Scanner;

/**
 * @author Nagaraju Budigam
 *
 */
public class SortedSearchNoSize {
	/*
	 * You are given an array like data structure Listy which lacks a size method. It does,
	 * however have an array[i] method that returns the element at index i in O(1) time. If i
	 * is beyond the bounds of the data structure, it returns -1. (For this reason, the data
	 * structure only supports positive integers.) Given a Listy which contains sorted positive
	 * integers, find the index at which an element x occurs. If x occurs multiple times, you
	 * may return any index.
	 * 
	 * Steps to proceed:
	 * 	1. Find the no.of elements present in the given list to use it as 
	 * 		upper bound while performing binary search, it takes: O(logn)
	 * 	2. Perform Binary Search, it takes: O(logn)
	 * 
	 * Over all time complexity: O(logn), space complexity : O(1)
	 */
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int[] a = new int[20];
		for (int i = 0; i < 12; i++)
			a[i] = i + 1;
		for (int x : a)
			System.out.print(x + " ");
		System.out.println("\nComputed length: " + getLength(a));
		System.out.println("Enter the element to Search: ");
		int n=in.nextInt();
		//System.out.println("Searching for "+n+" found ? : "+(binarySearch(a, 0, getLength(a)-1, n)==1?"Yes":"No"));
		System.out.println("Searching for "+n+" found ? : "+(search(a, n)==1?"Yes":"No"));

	}

	public static int getLength(int[] a) {
		int left = 1, right = 0, mid;
		while (a[left] != 0)
			left *= 2;//double the index till the a[i] is 0, this acts as the upper bound
		/* The no.of elements present in the array lies between right and left/2 */
		right = left;//upper bound
		left /= 2;// most recent valid index
		while (left <=right) {
			mid = (left + right) / 2;
			if (a[mid] != 0){//check whether the a[mid] element is present or not
				/*if a[mid] is present we have to move towards left, so update left=mid+1*/
				left = mid + 1;
			}
			else{
				/*if a[mid] is not present we have to move towards right, so update right=mid-1*/
				right = mid - 1;
			}
		}
		return left;
	}
	/* Customized Binary Search for searching an element in a sorted list, with out knowing size*/
	public static int search(int[] a, int n){
		int left=1,right,mid;
		while (a[left] != 0 && a[left]<n)
			left *= 2;
		right=left;
		left=left/2;
		while(left<=right){
			mid=(left+right)/2;
			if(a[mid]!=0){
				if(a[mid]==n) return 1;
				else if(a[mid]<n) left=mid+1;
				else	 right=mid-1;
			}
			else{
				right=mid-1;
			}
		}
		return -1;
	}
	/* Standard Binary Search */
	public static int binarySearch(int[] a, int left, int right, int n) {
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (n == a[mid])
				return 1;
			else if (n < a[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}

}
