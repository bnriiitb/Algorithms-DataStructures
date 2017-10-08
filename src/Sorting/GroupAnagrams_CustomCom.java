package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class GroupAnagrams_CustomCom {
	/*
	 * Anagrams are words that have the same characters and the order may be
	 * different. Example: care, race, acre
	 * 
	 * This solution runs in O(nlogn) time and is implemented using custom comparator
	 */
	public static void main(String[] args) {
		String[] a={"acer","car","race","acre","care","rac","push","rome","husp","more"};
		System.out.print("I/P: ");
		for(String s: a)System.out.print(s+" ");
		System.out.println();
		Arrays.sort(a,new AnagramComparator());
		System.out.print("O/P: ");
		for(String s: a)System.out.print(s+" ");
		System.out.println();
	}

}

class AnagramComparator implements Comparator<String> {
	public static String sortChars(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

	@Override
	public int compare(String s1, String s2) {
		/*
		 * The result is a negative integer if this String object
		 * lexicographically precedes the argument string. The result is a
		 * positive integer if this String object lexicographically follows the
		 * argument string. The result is zero if the strings are equal
		 */
		return sortChars(s1).compareTo(sortChars(s2));
	}

}
