package Searching;

import java.util.HashMap;
import java.util.Scanner;

public class Pairs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int c = 0;
		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < n; i++) {
			int t = in.nextInt();
			map.put(t, t);
		}
		for (Integer i : map.keySet()) {
			int t = map.get(i).intValue();
			if(map.get(Math.abs(t - k))!=null){
				if ((map.get(Math.abs(t - k)).intValue()+k) == t) {
					c++;
				}
			}
		}
		System.out.println(c);
	}
}
