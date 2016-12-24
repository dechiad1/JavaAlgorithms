package org.daniel.java.algorithms.tree;

import java.util.Stack;

public class PostOTTree {
	/*
	 * visit left child
	 * visit right child
	 * print the value of the current node
	 */
	
	/**
	 * iterative post order traversal implementation runs with
	 * O(n) time and space complexity 
	 * @param n
	 * @return
	 */
	public String iterativePOT(Node n) {
		StringBuilder result = new StringBuilder();
		
		Stack<Node> nextStack = new Stack<Node>();
		Stack<Node> solutionStack = new Stack<Node>();
		
		nextStack.push(n);
		while(!nextStack.isEmpty()) {
			Node node = nextStack.pop();
			solutionStack.push(node);
			if(node.hasLeft()) {
				nextStack.push(node.getLeft());
			}
			
			if(node.hasRight()) {
				nextStack.push(node.getRight());
			}
		}
		
		while(!solutionStack.isEmpty()) {
			result.append(solutionStack.pop().toString());
		}
		
		return result.toString();
	}
	
	/**
	 * recursive post order traversal implementation runs with 
	 * O(n) time and space complexity
	 * @param n
	 * @return
	 */
	public String recursivePOT(Node n) {
		String result = "";
		if(n.hasLeft()) {
			result += recursivePOT(n.getLeft());
		}
		
		if(n.hasRight()) {
			result += recursivePOT(n.getRight());
		}
		return result + n.toString();
	}
	
	/**
	 * iteravice post order traversal implementation runs with 
	 * O(n) time and O(h), h = height of tree, space complexity
	 * this requires modification of the nodes within the tree
	 * @param n
	 * @return
	 */
	public String iterativePOTWithLessSpace(Node n) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(n);
		StringBuilder result = new StringBuilder();
		while(!stack.isEmpty()) {
			Node node = stack.peek();
			if(node.hasLeft()) {
				stack.push(node.getLeft());
				node.setLeft(null);
			}
			
			else if(node.hasRight()) {
				stack.push(node.getRight());
				node.setRight(null);
			}
			
			else if(!node.hasLeft() && !node.hasRight()) {
				result.append(stack.pop().toString());
			}
		}
		return result.toString();
	}
}
