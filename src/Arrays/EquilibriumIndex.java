package Arrays;

public class EquilibriumIndex {

	public static void main(String[] args) {
		int[] a={-7,1,5,2,-4,3,0,1};
		getEquilibIndex(a);

	}
	public static void getEquilibIndex(int[] a){
		int s=0,lSum=0;
		for(int x:a)s+=x;
		System.out.println("Sum: "+s);
		for(int i=0; i<a.length; i++){
			s-=a[i];
			lSum+=a[i];
			if(lSum==s)System.out.println("Index: "+i+" Sum: "+s);
		}
		
	}

}
