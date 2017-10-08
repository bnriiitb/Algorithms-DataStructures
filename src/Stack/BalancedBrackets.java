package Stack;

import java.util.Stack;

public class BalancedBrackets {
	/* Check whether the given brackets are balanced */
	public static void main(String[] args) {
		System.out.println(isBalanced("{}{}{}"));
	}

	public static boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			} else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
				if (stack.isEmpty() || !isMatchingPair(s.charAt(i), stack)) {
					return false;
				} else
					stack.pop();
			}
		}
		return stack.isEmpty();
	}

	private static boolean isMatchingPair(char c, Stack s) {
		if (c == ')' && (Character) s.peek() == '(')
			return true;
		else if (c == ']' && (Character) s.peek() == '[')
			return true;
		else if ((Character) s.peek() == '{')
			return true;
		return false;
	}

}
