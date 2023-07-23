package lab3.ds.q1.pairsumbst;

import java.util.HashSet;

public class PairSumBST {

	// BST node
		class Node {
			int key;
			Node left, right;
			}
			
			// creation of new node
			 Node newNode(int data) {
				Node temp = new Node();
				temp.key = data;
				temp.left = null;
				temp.right = null;
				return temp;
				}
			
			 Node insert(Node root, int key) {
				Node newnode = newNode(key);
				Node x = root;
				Node current_parent = null;
				while (x != null) {
					current_parent = x;
					if (key < x.key)
						x = x.left;
					else if (key > x.key)
						x = x.right;
					else {
						System.out.println("Value already exists!!!");
						return newnode;
						}
					}
				// If the root is null, the tree is empty.
				if (current_parent == null)
					current_parent = newnode;
				// assign new node node to the left child
				else if (key < current_parent.key)
					current_parent.left = newnode;
				// assign the new node to the right child
				else
					current_parent.right = newnode;
				// return pointer to new node
				return current_parent;
				}
			
			 void Inorder(Node root) {
				if (root == null)
					return;
				else {
					Inorder(root.left);
					System.out.print(root.key + " ");
					Inorder(root.right);
					}
				}
			 
			boolean findPair(Node root, int sum,HashSet<Integer> set) {
				 
				if (root == null)
					return false;
					
				if (findPair(root.left,sum,set))
				{
					return true;
				}
				 
				if(set.contains((sum-root.key))) 
				{
					System.out.print("Pair found is ("+root.key + ","+(sum-root.key)+")");
					return true;
				}
				else
				{
					set.add(root.key);
				}
						
				return findPair(root.right,sum,set);
						
				
			 }
			
			 void findSumPair(Node root, int sum) {
				 
				HashSet<Integer> set= new HashSet<Integer>();
				
				if(!findPair(root,sum,set)) 
				{
					System.out.println("Nodes not found");
				}
			}
				
			
			public static void main(String args[]) {
				
				PairSumBST pair = new PairSumBST();
				int value;
				Node root = null;
				int[] arr = { 34, 1, 89, 22, 19, 38 };
				
				for (int i = 0; i < arr.length; i++) 
				{
					value = arr[i];
				
					if (root == null) 
					{
						root = pair.insert(root, value);
					}
					else 
					{
						pair.insert(root, value);
					
					}
				}
				//hard-coded value of sumToBeFound
				int sumToBeFound = 35;
				
				System.out.println("Inorder of Binary Tree!!");
				pair.Inorder(root);
				
				System.out.println("\n\nSum pair : "+sumToBeFound);
				pair.findSumPair(root,sumToBeFound);
				
				
			} 
}
