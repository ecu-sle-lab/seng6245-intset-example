package edu.ecu.cs.sle.seng6245.intset;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Comp {
	public static int max(Iterator<Integer> g) throws EmptyException, NullPointerException {
		// REQUIRES: g contains only Integers
		// MODIFIES: g
		// EFFECTS: If g is null throws NullPointerException; if g is empty,
		// throws EmptyException; else consumes all elements of g and returns
		// the largest int in g.
		try {
			int m = g.next().intValue();
			while (g.hasNext()) {
				int x = g.next();
				if (m < x) m = x;
			}
			return m;
		} catch (NoSuchElementException e) {
			throw new EmptyException("Comp.max");
		}
	}

}
