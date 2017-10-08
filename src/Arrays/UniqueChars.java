package Arrays;

import java.util.Hashtable;

public class UniqueChars {

	public static void main(String[] args) {
		System.out.println(hasUniqueChars("nag"));
		int t='z';
		System.out.println(t);
		Hashtable h=new Hashtable();

	}
	/*Brute Force approach runs in O(n) and with constant extra space O(1)*/
	public static boolean hasUniqueChars(String s){
		boolean[] b=new boolean[128];
		for(int i=0; i<s.length(); i++){
			int temp=s.charAt(i);
			if(b[temp]){
				return false;
			}
			b[temp]=true;
		}
		return true;
	}

}
