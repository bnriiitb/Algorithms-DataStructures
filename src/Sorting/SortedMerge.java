package Sorting;

public class SortedMerge {
/*
 * Merges two sorted arrays A and B
 */
	public static void main(String[] args) {
		int[] a =new int[20];
		int[] b={29,54,66,78,110};
		for(int i=0; i<10; i++){
			a[i]=i*3;
		}
		mergeSortedArrays(a,b);
	}

	private static void mergeSortedArrays(int[] a, int[] b) {
		int indexA=9;
		int indexB=4;
		int mergedInd=indexA+indexB;
		while(indexB>=0){
			if(indexA>=0 && a[indexA]>b[indexB]){
				a[mergedInd]=a[indexA];
				indexA--;
			}
			else{
				a[mergedInd]=b[indexB];
				indexB--;
			}
			mergedInd--;
		}
		System.out.println("Didn't copy : "+mergedInd);
		for(int x:a)System.out.print(x+" ");
	}
}
