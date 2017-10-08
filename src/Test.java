import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number size (or) heigh of Pascal Triange here: ");
		int n = in.nextInt(); // 4
		/* System.out.println("Factorial of  "+n+" is : "+factorial(n)); */
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				printPascalTriangle(i, j);
			}
			System.out.println();
		}
	}

	public static void printPascalTriangle(int i, int j) {
		System.out.print(" " + factorial(i) / (factorial(i - j) * factorial(j)) + " ");
	}

	public static long factorial(int n) {
		return n <= 1 ? 1 : n * factorial(n - 1);
	}

}
