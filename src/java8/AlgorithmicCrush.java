package java8;

import java.util.Scanner;

public class AlgorithmicCrush {
	static long max=0;

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		long m=in.nextInt();
		long[] l =new long[n];
		while(m>0){
			int startInd=in.nextInt();
			int endInd=in.nextInt();
			long k=in.nextLong();
			performOperation(l, startInd, endInd, k);
			m--;
		}
		System.out.println(max);

	}
	public static void performOperation(long[] l, int startInd, int endInd, long k){
		for(int i=startInd-1; i<endInd; i++){
			l[i]+=k;
			if(l[i]>max)
				max=l[i];
		}
	}
}
