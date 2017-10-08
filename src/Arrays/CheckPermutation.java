package Arrays;

import java.util.Arrays;

public class CheckPermutation {

	public static void main(String[] args) {
		System.out.println(isPermutaion("rat", "tar"));
	}

	/* This solution runs in O(n) time with constant extra space i.e O(1) */
	private static boolean isPermutaion(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int[] charFreq = new int[128];// assuming that characters are ascii
		for (int i = 0; i < s1.length(); i++)
			charFreq[s1.charAt(i)]++;
		for (int i = 0; i < s2.length(); i++) {
			charFreq[s2.charAt(i)]--;
			if (charFreq[s2.charAt(i)] < 0)
				return false;
		}
		return true;
	}

	/* This solution runs in O(nlogn) with extra space O(n) */
	private static boolean isPermutaionBasic(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		return sort(s1).equals(sort(s2));
	}

	private static String sort(String s1) {
		char[] c = s1.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

}
