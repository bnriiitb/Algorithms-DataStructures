package Sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Nagaraju Budigam
 *
 */
public class PeaksAndValley {
	/*
	 * In an array of integers, a peak is an element which is greater than or
	 * equals to the adjacent integers and a valley is an element which is less
	 * than or equal to the adjacent integers. For example in the
	 * array[5,8,6,2,3,4,6] [8,6] are peaks and [5,2] are valleys. Given an
	 * array of integers sort the array into an alternating sequence of peaks
	 * and valleys.
	 */
	public static void main(String[] args) {
		int[] a = { 5,3,1,2,3 };
		//int[] a = { 5,3,1,2,3,4,3,2,6,5,8,7 };
		Integer[] p={3,2,1,6,4,7};
		//peaksAndValleySimple(a);
		//valleyAndPeaks(p);
		sortValleyPeaks(a);
	}

	/*
	 * Simple Solution 1. Sort the array in ascending order. 2. Iterate through
	 * the elements starting from index 1(not 0) and jumping two elements at a
	 * time. 3. At each element, swap it with the previous element. Since every
	 * three elements appear in the order small <=medium<=large, swapping these
	 * elements will always put medium as a peak. medium<= small <= large, this
	 * solution runs in o(n log n).
	 */
	public static void peaksAndValleySimple(int[] a) {
		Arrays.sort(a);
		for (int i = 1; i < a.length; i += 2) {
			int t = a[i - 1];
			a[i - 1] = a[i];
			a[i] = t;
		}
		for (int x : a)
			System.out.print(x + " ");
		sortPeaksAndValley(a);
	}

	/*
	 * Valley and Peaks sort the array in descending order
	 * swap ith i-1 th elements by jumping 2 index at time
	 */
	public static void valleyAndPeaks(Integer[] a) {
		System.out.println("***Valley and Peaks***");
		Arrays.sort(a, new myComparator());
		System.out.println("After Sort:");
		for(Integer i:a)System.out.print(i+" ");
		for(int i=1; i<a.length; i+=2){
			Integer t=a[i];
			a[i]=a[i-1];
			a[i-1]=t;
		}
		System.out.println();
		for(Integer i:a)System.out.print(i+" ");
	}
	
	/*Given Peaks and valley array sort it*/
	public static void sortPeaksAndValley(int[] a){
		System.out.println("***Sort Peaks and Valley Array***");
		System.out.println("\nBefore Sort: ");
		for(int i:a)System.out.print(i+" ");
		for(int i=1; i<a.length; i+=2){
			int t=a[i];
			a[i]=a[i-1];
			a[i-1]=t;
		}
		System.out.println("\nAfter Sort: ");
		for(int i:a)System.out.print(i+" ");
	}
	
	/*Simple Optimal Solution runs in O(n)*/
	public static void peaksAndValley(int[] a){
		System.out.println("***Sort Peaks and Valley Array: Optimal Solution***");
		System.out.println("\nOriginal Array: ");
		for(int i:a)System.out.print(i+" ");
		for(int i=0; i+1<a.length; i++){
			if(i%2==0){
				//P V
				if(a[i]<a[i+1]){
					int t=a[i];
					a[i]=a[i+1];
					a[i+1]=t;
				}
			}
			else{
				// V P
				if(a[i]>a[i+1]){
					int t=a[i+1];
					a[i+1]=a[i];
					a[i]=t;
				}
			}
		}
		System.out.println("\nAfter Swap: ");
		for(int i:a)System.out.print(i+" ");
	}
	/*Optimal Solution runs in O(n)*/
	public static void sortValleyPeaks(int[] a){
		System.out.println("*** Valley and Peaks ***");
		System.out.println("\nBefore Sort: ");
		for(int i:a)System.out.print(i+" ");
		for(int i=1; i<a.length; i+=2){
			int biggestIndex=getMaxIndex(a,i-1,i,i+1);
			if(i!=biggestIndex){
				swap(a,i,biggestIndex);
			}
		}
		System.out.println("\nAfter Swap: ");
		for(int i:a)System.out.print(i+" ");
		
	}

	private static void swap(int[] a, int i, int biggestIndex) {
		int t=a[i];
		a[i]=a[biggestIndex];
		a[biggestIndex]=t;
		
	}

	private static int getMaxIndex(int[] a, int i, int j, int k) {
		int len=a.length;
		int aVal=i>=0 && i<len ?a[i]:Integer.MIN_VALUE;
		int bVal=j>=0 && j<len ?a[j]:Integer.MIN_VALUE;
		int cVal=k>=0 && k<len ?a[k]:Integer.MIN_VALUE;
		int max=Math.max(aVal, Math.max(bVal, cVal));
		if(aVal==max) return i;
		else if(max==bVal) return j;
		else return k;
	}

}

class myComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		return -o1.compareTo(o2);
	}
}
