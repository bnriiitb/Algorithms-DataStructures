package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams_HashTable {
	/*
	 * Anagrams are words that have the same characters and the order may be
	 * different. Example: care, race, acre
	 * 
	 * This solution run in O(n) if HashMap is used, where the order is not preserved
	 * 	I/P: [acer , car , race , acre , care , rac , push , rome , husp , more] 
	 * 	O/P: [car , rac , acer , race , acre , care , rome , more , push , husp]
	 * 
	 * If order is required TreeMap should be used and it runs in O(nlogn)
	 * as insert/lookup takes O(logn)  time.
	 * 	I/P: [acer , car , race , acre , care , rac , push , rome , husp , more] 
	 * 	O/P: [acer , race , acre , care , car , rac , rome , more , push , husp]
	 * 
	 * Space complexity remains O(n) with both the approaches mentioned above.
	 */
	public static void main(String[] args) {
		String[] a={"acer","car","race","acre","care","rac","push","rome","husp","more"};
		System.out.print("I/P: ");
		for(String s: a)System.out.print(s+" ");
		System.out.println();
		groupAnagrams(a);
		System.out.print("O/P: ");
		for(String s: a)System.out.print(s+" ");
		System.out.println();
	}
	public static String sortChars(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	public static void groupAnagrams(String[] a){
		HashMap<String, ArrayList<String>> mapList=new HashMap();
		/*Group words by anagram*/
		for(String s: a){
			String key=sortChars(s);
			if(null==mapList.get(key)){//Check if key already exists?
				ArrayList<String> t =new ArrayList<String>();
				t.add(s);
				mapList.put(key, t);
			}
			else{//If key already exists then get value and append current value
				ArrayList<String> t = mapList.get(key);
				t.add(s);
				mapList.put(key, t);
			}
		}
		/*Convert the hash table to array*/
		int index=0;
		for(String key: mapList.keySet()){
			ArrayList<String> list=mapList.get(key);//get the list corresponds to each key
			for(String t:list){
				a[index]=t;
				index++;
				}
		}
	}

}
