package org.daniel.java.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PreOTTree {
	/*
	 * print the value of the current node
	 * visit left child
	 * visit right child
	 */
	
	/**
	 * iterative pre order traversal implementation runs with
	 * O(n) time and space complexity 
	 * @param n
	 * @return
	 */
	public String iterativePOT(Node n) {
		Queue<Node> solutionQueue = new LinkedList<Node>();
		Stack<Node> nextStack = new Stack<Node>();
		
		nextStack.push(n);
		while(!nextStack.isEmpty()) {
			Node node = nextStack.pop();
			solutionQueue.add(node);
			//push left to stack second, as stack is lifo
			if(node.hasRight()) {
				nextStack.push(node.getRight());
			}
			if(node.hasLeft()) {
				nextStack.push(node.getLeft());
			}
		}
		
		StringBuilder result = new StringBuilder();
		while(!solutionQueue.isEmpty()) {
			result.append(solutionQueue.remove().toString());
		}
		
		return result.toString();
	}
	
	/**
	 * recursive pre order traversal implementation runs with
	 * O(n) time and space complexity
	 * @param n
	 * @return
	 */
	public String recursivePOT(Node n) {
		String result = n.toString();
		if(n.hasLeft()) {
			result += recursivePOT(n.getLeft());
		}
		
		if(n.hasRight()) {
			result += recursivePOT(n.getRight());
		}
		
		return result;
	}
	
	/**
	 * iterative pre order traversal implementation runs with 
	 * O(n) time and O(h), h = height of tree, space complexity
	 * @param n
	 * @return
	 */
	public String iterativePOTWithLessSpace(Node n) {
		StringBuilder result = new StringBuilder();
		Stack<Node> stack = new Stack<Node>();
		stack.push(n);
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			result.append(node.toString());
			
			if(node.hasRight()) {
				stack.push(node.getRight());
				node.setRight(null);
			}
			
			if(node.hasLeft()) {
				stack.push(node.getLeft());
				node.setLeft(null);
			}
		}
		return result.toString();
	}
}
