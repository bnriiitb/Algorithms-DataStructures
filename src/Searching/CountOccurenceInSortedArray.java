package Searching;

public class CountOccurenceInSortedArray {

	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 2, 2, 2, 3, 3,4, 5, 6, 7 };
		System.out.println(getOccurenceinSortedArray(a, 10));
	}

	/* Optimized solution runs in O(log n ) time */
	public static int getOccurenceinSortedArray(int[] a, int n) {
		int firstOccInd=getOccurence(a,n,true);
		int lastOccInd=getOccurence(a,n,false);
		return (firstOccInd ==-1 || lastOccInd ==-1)?0:(lastOccInd-firstOccInd)+1;
	}

	private static int getOccurence(int[] a, int n, boolean b) {
		int low=0,mid=0,high=a.length-1,result=-1;
		while(low<=high){
			mid=(low+high)/2;
			if(a[mid]==n){
				if(b==true)//find first occurrence so search towards left
					high=mid-1;
				else//find last occurrence so search towards right
					low=mid+1;
				result=mid;
			}
			else if(a[mid]>n)
				high=mid-1;
			else
				low=mid+1;
		}
		return result;
	}

	public static int binarySearch(int[] a, int n) {
		int low = 0, mid = 0, high = a.length - 1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] == n)
				return mid;
			else if (a[mid] > n)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	/* Bruteforce solution runs in O(n) i.e O(log n)+ O(n) */
	public static int countOccurence(int[] a, int n) {
		int c = 0;
		int l = -1, r = -1;
		l = binarySearch(a, n);
		if (l != -1) {
			r = l + 1;
			while (a[l] == n && l >= 0) {
				c++;
				l--;
			}
			while (a[r] == n && r < a.length) {
				c++;
				r++;
			}
		}
		return c;
	}

}
