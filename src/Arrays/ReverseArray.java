package Arrays;

public class ReverseArray {
	/*Reverse an array in N/2*/
	public static void main(String[] args) {
		int[] a={1,2,3,4,5,6,7,8,9,10};
		int j=a.length-1;
		for(int i=0; i<a.length/2; i++){
			int t=a[j];
			a[j]=a[i];
			a[i]=t;
			j--;
		}
		for(int t:a)System.out.print(t+" ");
	}
}
