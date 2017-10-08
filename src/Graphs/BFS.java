package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			HashMap<Integer, Queue<Integer>> adjList = new HashMap<>();
			while (m > 0) {
				Integer v1 = in.nextInt();
				Integer v2 = in.nextInt();
				prepareAdjList(adjList, v1, v2);
				prepareAdjList(adjList, v2, v1);
				m--;
			}
			Integer s = in.nextInt();
			getDistance(s,adjList, n);
			System.out.println(adjList);
			t--;
		}

	}

	private static void getDistance(Integer s, HashMap<Integer, Queue<Integer>> adjList, int n) {
		boolean[] visited = new boolean[n];
		int[] distance = new int[n];
		Queue<Integer> q= new LinkedList<>();
		q.add(s);
		while(!q.isEmpty()){
			Integer t=q.poll();
			if(adjList.get(t)!=null){
				q.addAll(adjList.get(t));
			}
			if(t==n){
				System.out.println("Found");
				break;
			}
		}
		
	}
	

	private static void prepareAdjList(HashMap<Integer, Queue<Integer>> adjList, Integer v1, Integer v2) {
		Queue<Integer> l = new LinkedList<>();
		if (adjList.get(v1) == null) {
			l.add(v2);
		} else {
			l = adjList.get(v1);
			l.add(v2);
		}
		adjList.put(v1, l);
	}

}
