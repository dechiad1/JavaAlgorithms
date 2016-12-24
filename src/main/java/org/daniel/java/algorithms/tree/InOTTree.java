package org.daniel.java.algorithms.tree;

import java.util.Stack;

public class InOTTree {
	/*
	 * Visit the left child
	 * Process the node
	 * Visit the Right child
	 */
	
	/**
	 * recursive in order traversal implementation runs with 
	 * O(n) time and space complexity
	 * @param n
	 * @return
	 */
	public String recursiveIOT(Node n) {
		String result = "";
		if(n.hasLeft()) {
			result += recursiveIOT(n.getLeft());
		}
		
		result += n.toString();
		
		if(n.hasRight()) {
			result += recursiveIOT(n.getRight());
		}
		
		return result;
	}
	
	/**
	 * iterative in order traversal implementation runs with 
	 * O(n) time and space complexity
	 * @param n
	 * @return
	 */
	public String iterativeIOT(Node n) {
		StringBuilder result = new StringBuilder();
		Stack<Node> nextStack = new Stack<Node>();
		nextStack.push(n);
		
		//add leftmost tree to stack
		while(n.hasLeft()) {
			nextStack.push(n.getLeft());
			n = n.getLeft();
		}
		
		//write if no further left child, add right and then
		//all possible lefts
		while(!nextStack.isEmpty()) {
			Node node = nextStack.pop();
			result.append(node.toString());
			
			if(node.hasRight()) {
				Node node2 = node.getRight();
				nextStack.push(node2);
				while(node2.hasLeft()) {
					nextStack.push(node2.getLeft());
					node2 = node2.getLeft();
				}
			}
		}
		
		
		return result.toString();
	}
	
	/**
	 * iterative in order traversal implementation runs with 
	 * O(n) time and O(h), h = height of tree, space complexity
	 * @param n
	 * @return
	 */
	public String iteravtiveIOTWithLessSpace(Node n) {
		StringBuilder result = new StringBuilder();
		Stack<Node> stack = new Stack<Node>();
		stack.push(n);
		
		while(!stack.isEmpty()) {
			Node node = stack.peek();
			if(node.hasLeft()) {
				stack.push(node.getLeft());
				node.setLeft(null);
			} 
			
			else {
				stack.pop();
				result.append(node.toString());
			
				if(node.hasRight()) {
					stack.push(node.getRight());
				}
			}
		}
		return result.toString();
	}
}
