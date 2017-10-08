package Graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Neighbour{
	int vertexNum;
	Neighbour next;
	public Neighbour(int vertexNum, Neighbour next) {
		this.vertexNum=vertexNum;
		this.next=next;
	}
	
}

class Vertex{
	String name;
	Neighbour adjList;
	public Vertex(String name, Neighbour adjList){
		this.name=name;
		this.adjList=adjList;
	}
	
}

public class Graph {
	Vertex[] vertex;
	public Graph(String file) throws FileNotFoundException {
		Scanner in = new Scanner(new File(file));
		String graphType = in.next();
		vertex=new Vertex[in.nextInt()];
		//read vertices
		for(int i=0; i<vertex.length; i++){
			vertex[i]=new Vertex(in.next(), null);
		}
		//read edges
		while(in.hasNext()){
			int v1=getIndexOf(in.next());
			int v2=getIndexOf(in.next());
			vertex[v1].adjList=new Neighbour(v2, vertex[v1].adjList);
			if(graphType.equalsIgnoreCase("undirected"))
			vertex[v2].adjList=new Neighbour(v1, vertex[v2].adjList);
		}
		print();
	}

	public void print() {
		for(int i=0; i<vertex.length; i++){
			System.out.print(vertex[i].name);
			Neighbour t = vertex[i].adjList;
			while(null!=t){
				System.out.print(" --> "+vertex[t.vertexNum].name);
				t=t.next;
			}
			System.out.println();
		}
		
	}

	private int getIndexOf(String val) {
		for(int i=0; i<vertex.length; i++){
			if(vertex[i].name.equalsIgnoreCase(val))
				return i;
		}
		return -1;
	}

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in =new Scanner(System.in);
		String fileName = "friendship.txt";//in.nextLine();		
		Graph g =new Graph(fileName);
		g.print();
	}

}
