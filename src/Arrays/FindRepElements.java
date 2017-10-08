package Arrays;

public class FindRepElements {
/*
 * Find the repeating elements in the elements ranging from 1 to n in O(n)
 */
	public static void main(String[] args) {
		int[] a={1,2,3,4,5,2,3,4,5};
		findRepeatedElem(a);
	}
	public static void findRepeatedElem(int[] a){
		for(int i=0; i<a.length; i++){
			int t=Math.abs(a[i]);
			if(a[t]>0){
				a[t]=-a[t];
			}
			else
				System.out.print(Math.abs(a[i])+" ");
		}
	}
}
