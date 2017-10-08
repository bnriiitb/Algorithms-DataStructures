package Arrays;

public class FindUnsotedSubArray {

	public static void main(String[] args) {
		int[] a={1,2,3,15,7,8,20,22,21,9,10,11,12,14};
		findUnsortedArray(a);
	}
	public static void findUnsortedArray(int[] a){
		int l=0,r=0;
		for(l=0; l+1<a.length; l++){
			if(a[l]>a[l+1])
				break;
		}
		for(r=a.length-1; r>0; r--){
			if(a[r]<a[r-1])
				break;
		}
		if(l==a.length-1)System.out.println("Array is fully sorted");
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for(int i=l; i<r; i++){
			if(a[i]>max)max=a[i];
			if(a[i]<min)min=a[i];
		}
		for(int i=l; i<r; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println("\nMin: "+min+" Max: "+max);
		for(int i=0; i<l; i++){
			if(a[i]>min){
				l=i;
				break;
			}
		}
		for(int i=a.length-1; i>=r; i--){
			if(a[i]<max){
				r=i;
			}
		}
		for(int i=l; i<r; i++)System.out.print(a[i]+" ");
	}

}
