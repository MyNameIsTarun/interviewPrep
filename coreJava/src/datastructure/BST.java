package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * A BST is a binary tree where every node of the left subtree has value lesser than the root node and
 * every node of the right subtree has value greater than the root node, and left and right subtrees must also be BST
 * 
 * A tree in which every node can have at-most two child nodes is know as binary tree
 */
public class BST<T extends Comparable<T>> {
	
	private Node<T> root = null;
	
	/*
	 * Returns true if value is inserted, false if value already exist (based on the return value of compareTo() method)
	 * This will work fine if CompareTo and equals of the specified object maintains the general contract
	 */
	// add: O(h) time , O(1) space, h = height of the tree
	// Worst case: O(n) time, skewed tree (h = n)
	public boolean insert(T newValue) {
		
//		TreeSet<String> set;
//		TreeMap<String, String> map;
		
		if(newValue == null) {
			return false;
		}
		
		Node<T> newNode = new Node<>(newValue);
		
		if(root == null) {
			root = newNode;
			return true;
		}
		else {
			Node<T> curr = root, parent = null;  
			while(curr != null) {
				parent = curr;
				
				if(curr.value.compareTo(newValue) < 0) {
					curr = curr.right;
				}
				else if(curr.value.compareTo(newValue) > 0) {
					curr = curr.left;
				}
				else {
					return false;
				}
			}
			
			if(parent.value.compareTo(newValue) > 0) {
				parent.left = newNode;
			}
			else {
				parent.right = newNode;
			}
		}
		
		return true;
		
	}
	
	// Search: O(h) time , O(1) space, h = height of the tree
	// Worst case: O(n) time, skewed tree (h = n)
	public boolean contains(T key) {
		
		if(key == null) {
			return false;
		}
		
		return (getNode(key) != null);
	}
	
	// returns the value if present, otherwise null
	private T getNode(T key) {
		
		Node<T> temp = root;
		
		while(temp != null) {
			// This will give correct result if equals() and compareTo() maintains the general contract
			if(temp.value.equals(key)) {
				return temp.value;
			}
			else if(temp.value.compareTo(key) < 0) {
				temp = temp.right;
			}
			else {
				temp = temp.left;
			}
		}
		
		return null;
	}
	
	public T delete(T keyToBeDeleted) {
		
		if(keyToBeDeleted == null) {
			return null;
		}
		
		T valueToReturn = getNode(keyToBeDeleted);
		
		if(valueToReturn == null) {
			return null;
		}
		
		deleteNode(root, keyToBeDeleted);
		
		return valueToReturn;
	}
	
	// delete: O(h) time , O(h) space, h = height of the tree
	// Worst case: O(n) time & space, skewed tree (h = n)
	private Node<T> deleteNode(Node<T> temp, T newValue) {
		
		if(temp == null) {
			return null;
		}
		
		if(temp.value.compareTo(newValue) < 0) {
			temp.right = deleteNode(temp.right, newValue);
		}
		else if(temp.value.compareTo(newValue) > 0) {
			temp.left = deleteNode(temp.left, newValue);
		}
		else {
			if(temp.left == null) return temp.right;
			if(temp.right == null) return temp.left;
			
			// I have made a rule that i will choose the successor of the deleted node from the right side
			Node<T> succ = getSuccessor(temp.right);
			temp.value = succ.value;
			temp.right = deleteNode(temp.right, succ.value);
		}
		
		return temp;
	}

	private Node<T> getSuccessor(Node<T> temp) {
		
		while(temp != null && temp.left != null) temp = temp.left;
		
		return temp;
	}

	public List<T> getList(){
		Node<T> temp = root;
		List<T> list = new ArrayList<>();
		inOrder(list, temp);
		
		return list;
	}

	// Tree traversal: O(h) time , O(h) space, h = height of the tree
	// Worst case: O(n), skewed tree (h = n)
	private void inOrder(List<T> list, Node<T> temp) {
		
		if(temp == null) {
			return;
		}
		
		inOrder(list, temp.left);
		list.add(temp.value);
		inOrder(list, temp.right);
	}

	private class Node<T>{
		T value;
		Node<T> left, right;
		Node(T value){
			this.value = value;
		}
	}
	
	/*
	 * What are self balancing BST?
	 * => Self-Balancing Binary Search Trees are height-balanced binary search trees that automatically keep the height as small as 
	 * => possible when insertion and deletion operations are performed on the tree. 
	 * 
	 * Where it is used in java?
	 * => TreeSet and TreeMap uses Self balancing BST
	 * 
	 * Applications of BST?
	 * => Searching and Sorting operations
	 * => DB index
	 */

}
