package org.daniel.java.algorithms.tree;

import org.daniel.java.algorithms.tree.Node;
import org.junit.Before;

public class TreeSetup {
	protected Node a;
	protected Node b;
	protected Node c;
	protected Node d;
	protected Node e;
	protected Node f;
	protected Node g;
	protected Node h;
	protected Node i;
	
	@Before
	public void init() {
		a = new Node("a");
		b = new Node("b");
		c = new Node("c");
		d = new Node("d");
		e = new Node("e");
		f = new Node("f");
		g = new Node("g");
		h = new Node("h");
		i = new Node("i");
		
		/*
		 * create tree with structure of.
		 *           a
		 *          / \
		 *         b   c
		 *        / \ 
		 *       d   e
		 *          / \
		 *         f   g
		 *            / \
		 *           h   i
		 */
		
		a.setLeft(b);
		a.setRight(c);
		b.setLeft(d);
		b.setRight(e);
		e.setLeft(f);
		e.setRight(g);
		g.setLeft(h);
		g.setRight(i);
	}

}