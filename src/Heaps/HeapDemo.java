package Heaps;

import java.util.Scanner;

public class HeapDemo {

	public static void main(String[] args) {
		Heaps<Integer> h =new Heaps<Integer>();
		Scanner in =new Scanner(System.in);
		System.out.println("Enter Input: ");
		String s= in.next();
		while(!s.equals("1")){
			h.insert(Integer.parseInt(s));
			System.out.println(h);
			System.out.println("Enter 1 to stop: ");
			s=in.next();
		}
		while(!h.isEmpty()){
			int t = h.delete();
			System.out.println(t+" "+h);
		}
	}

}
