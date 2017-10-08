package DynamicProgramming;

import java.util.Scanner;

public class MaxSubArray {

    public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		int k=n;
		while(n>0){
			int size=in.nextInt();
			int[] a=new int[size];
			int i=0;
			while(size>0){
				a[i]=in.nextInt();
				size--;
				i++;
			}
			System.out.println(getMaxContSubArray(a)+" "+getMaxNonContSubArray(a));;
			n--;
		}
        in.close();
	}

	private static long getMaxContSubArray(int[] a) {
		long max_so_far=a[0],max_ending_here=a[0];
		for(int i=1; i<a.length; i++){
			max_ending_here=Math.max(a[i], max_ending_here+a[i]);
			max_so_far=Math.max(max_ending_here, max_so_far);
		}
		return max_so_far;
	}
	
	private static long getMaxNonContSubArray(int[] a) {
		long sum=a[0];
		for(int i=1; i<a.length; i++){
			if(a[i]>0){
				if(sum<0){
					sum=a[i];
				}
				else
				sum+=a[i];
			}else{
				sum=Math.max(a[i], sum);
			}
		}
		return sum;
	}
	}