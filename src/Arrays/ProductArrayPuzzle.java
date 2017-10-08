package Arrays;

public class ProductArrayPuzzle {

	public static void main(String[] args) {
		int[] a={3,2,1,4};
		//int[] t=getProd_BruteForce(a);
		System.out.print("Original: ");
		for(int x:a)System.out.print(x+" ");
		System.out.println();
		getProd(a);
	}
	/*brute force solution
	 * Space Complexity : O(n)
	 * Time Complexity: O(n^2)
	 */
	static int[] getProd_BruteForce(int[] a){
		int[] t=new int[a.length];
		for(int i=0; i<a.length; i++)t[i]=1;
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a.length; j++){
				if(i!=j){
					t[i]*=a[j];
				}
			}
		}
		return t;
	}
	/*Better solution
	 * Space Complexity : O(n)
	 * Time Complexity: O(n)
	 */
	static int[] getProd(int[] a){
		int[] t=new int[a.length];
		for(int i=0; i<a.length; i++)t[i]=1;
		int temp=1;
		for(int i=0; i<a.length; i++){
			t[i]=temp;
			temp=temp*a[i];
		}
		System.out.print("Left Prod: ");
		for(int x:t)System.out.print(x+" ");
		System.out.println();
		temp=1;
		System.out.print("Right Prod: ");
		for(int x:t)System.out.print(x+" ");
		System.out.println();
		return null;
	}

}
