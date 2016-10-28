package org.daniel.java.JavaGraph;

import org.junit.Before;

public class GraphSetup {
	protected Node one;
	protected Node two;
	protected Node three;
	protected Node four;
	protected Node five;
	protected Node six;
	protected Node seven;
	protected Node eight;
	protected Node nine;
	protected Node ten;
	
	protected Graph graph;
	
	@Before
	public void init() {
		graph = new Graph();
		
		one = new Node(1);
		two = new Node(2);
		three = new Node(3);
		four = new Node(4);
		five = new Node(5);
		six = new Node(6);
		seven = new Node(7);
		eight = new Node(8);
		nine = new Node(9);
		ten = new Node(10);
		
		one.addEdge(two);
		one.addEdge(three);
		one.addEdge(four);
		one.addEdge(five);
		
		two.addEdge(one);
		two.addEdge(six);
		
		three.addEdge(one);
		three.addEdge(six);
		three.addEdge(four);
		three.addEdge(seven);
		
		four.addEdge(one);
		four.addEdge(three);
		four.addEdge(nine);
		
		five.addEdge(one);
		five.addEdge(nine);
		
		six.addEdge(two);
		six.addEdge(three);
		
		seven.addEdge(three);
		seven.addEdge(eight);
		seven.addEdge(ten);
		
		eight.addEdge(seven);
		eight.addEdge(ten);
		
		nine.addEdge(four);
		nine.addEdge(five);
		
		ten.addEdge(seven);
		ten.addEdge(eight);
		
		graph.addVertex(one);
		graph.addVertex(two);
		graph.addVertex(three);
		graph.addVertex(four);
		graph.addVertex(five);
		graph.addVertex(six);
		graph.addVertex(seven);
		graph.addVertex(eight);
		graph.addVertex(nine);
		graph.addVertex(ten);
	}
	
}
