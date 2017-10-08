package RrecursionandBackTracking;
/*
 * Towers of Honai Rules: 
 * 1. Only one disk can be moved at a time
 * 2. Each move consists of taking the upper disk from one of the rods and sliding it into 
 * 	  another rod, on top of the other disks that may already present on the rod.
 * 3. No disks may be placed on top of a smaller disk.
 */
public class TowersOfHonaiProblem {

	public static void main(String[] args) {
		TowersOfHonai(3, 'S', 'D', 'A');
	}
	public static void TowersOfHonai(int n, char fromPeg, char toPeg, char auxPeg){
		if(n==1){
			System.out.println("Moving disk 1 from peg "+fromPeg+" to peg "+toPeg);
			return;
		}
		TowersOfHonai(n-1, fromPeg, auxPeg, toPeg);
		System.out.println("Moving disk from peg "+fromPeg+" to peg "+toPeg);
		TowersOfHonai(n-1, auxPeg, toPeg, fromPeg);
	}

}
