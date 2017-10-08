package Trie;

import java.util.Scanner;

public class Trie {
	public static class TrieNode{
		private TrieNode[] children= new TrieNode[26];
		private int size;
		
		private int getCharIndex(char c){
			return c-'a';
		}
		private TrieNode getNode(char c){
			return children[getCharIndex(c)];
		}
		private void setNode(char c, TrieNode node){
			children[getCharIndex(c)]=node;
		}
		public void add(String s){
			add(s,0);
		}
		private void add(String s, int index){
			size++;
			if(index==s.length()) return;//reached end of the string
			char currentChar=s.charAt(index);
			int currentCharInd=getCharIndex(currentChar);
			TrieNode currentNode = getNode(currentChar);// get the node for current char
			if(currentNode==null){
				currentNode=new TrieNode();
				setNode(currentChar,currentNode);
			}
			currentNode.add(s,index+1);
		}
		public int findCount(String s, int index){
			if(index==s.length()) return size;
			TrieNode child = getNode(s.charAt(index));
			if(child==null){
				return 0;
			}
			return child.findCount(s, index+1);
		}
		
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TrieNode root=new TrieNode();
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")){
            		root.add(contact);
            }
            else{
            	  System.out.println(root.findCount(contact, 0));
            }
        }
	}

}
