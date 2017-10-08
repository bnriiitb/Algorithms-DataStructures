package Arrays;

public class DutchNationalFlag {
/*
 * Seggregate Even and odd numbers (or)
 */
	public static void main(String[] args) {
		int[] a={0,1,0,1,1,0,1,0,1,0,1,1,0,0};
		System.out.print("I/P: ");
		for(int x: a)System.out.print(x+" ");
		System.out.println();
		seggregate(a);

	}
	public static void seggregate(int[] a){
		int l=0,r=a.length-1;
		while(l<r){
			while(a[l]%2==0 && l<r)l++;
			while(a[r]%2==1 && l<r)r--;
			if(l<r){
				int t=a[l];
				a[l]=a[r];
				a[r]=t;
				l++;
				r--;
			}
		}
		System.out.print("O/P: ");
		for(int x: a)System.out.print(x+" ");
		System.out.println();
	} 

}
