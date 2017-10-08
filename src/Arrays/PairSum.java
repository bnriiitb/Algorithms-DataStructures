package Arrays;

import java.util.Arrays;

public class PairSum {
//Given an array A[] and a number x, check for pair in A[] with sum as x
	public static void main(String[] args) {
		int[] a={1,2,3,4,6,8,4,10};
		//getPair(a, 8);

	}
	//method 1
	 static void getPair(int[] a, int n){
		Arrays.sort(a);
		for(int x: a)
			System.out.print(x+" ");
		System.out.println();
		int l=0,r=a.length-1;
		while(l<r){
			if(a[l]+a[r]==n){
				System.out.println(a[l]+" "+a[r]);
				l++;
				r++;
				
			}
			else if(a[l]+a[r]<n){
				l++;
			}
			else{
				r--;
			}
		}
	}
	 //method 2 using hashing
	 static void getPairs(int[] a,int n){
		 int[] binmap=new int[a.length];
		 for(int i=0; i<a.length; i++){
			 //binmap[n-a[i]]
		 }
		 
	 }

}
