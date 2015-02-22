package edu.ecu.cs.sle.seng6245.intset;

import java.util.Iterator;
import java.util.Vector;

public class IntSet implements Cloneable {
	// OVERVIEW: IntSets are ubounded, mutable sets of integers
	private Vector<Integer> els; // the rep
	
	// constructors
	public IntSet() {
		// EFFECTS: Initializes this to be empty.
		els = new Vector<Integer>();
	}
	
	// methods
	public void insert(int x) {
		// MODIFIES: this
		// EFFECTS: Adds x to the elements of this.
		if (getIndex(x) < 0) {
			els.add(x);
		}
	}

	public void remove(int x) {
		// MODIFIES: this
		// EFFECTS: Removes x from this
		int i = getIndex(x);
		if (i < 0) return;
		els.set(i, els.lastElement());
		els.remove(els.size()-1);
	}
	
	public boolean isInt(int x) {
		// EFFECTS: Returns true if x is in this else returns false.
		return getIndex(x) > 0;
	}
	
	private int getIndex(int x) {
		// EFFECTS: If x is in this returns index where x appears else returns -1.
		for (int i = 0; i < els.size(); ++i) {
			if (Integer.valueOf(x).equals(els.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	public int size() {
		// EFFECTS: Returns the cardinality of this
		return els.size();
	}
	
	public int choose() throws EmptyException {
		// EFFECTS: If this is empty throws EmptyException else
		// returns an arbitrary element of this.
		if (els.size() == 0) {
			throw new EmptyException("IntSet.choose");
		}
		return els.lastElement();
	}
	
	private IntSet (Vector v) {
		els = v;
	}
	
	public IntSet clone() {
		// NOTE: In the book this returns Object, but since Java 1.5 we can return
		// a more specific type than what is defined on the clone method we are
		// inheriting, this is the concept of covariance that I mentioned in class.
		// NOTE: This is what is in the book, we discussed in class why this
		// is actually problematic
		return new IntSet((Vector)els.clone());
	}

	public String toString() {
		if (els.size() == 0) {
			return "IntSet:{ }";
		}
		
		String s = "IntSet: {" + els.elementAt(0).toString();
		for (int i = 1; i < els.size(); i++) {
			s = s + " , " + els.elementAt(i).toString();
		}
		return s + "}";
	}
	
	public boolean repOk() {
		if (els == null) return false;
		for (int i = 0; i < els.size(); i++) {
			Object x = els.get(i);
			if (!(x instanceof Integer)) return false;
			for (int j = i + 1; j < els.size(); j++) {
				if (x.equals(els.get(j))) return false;
			}
		}
		return true;
	}

	public Iterator elements() {
		// EFFECTS: Returns a generator that will produce all the elements of
		// this (as Integers), each exactly once, in arbitrary order.
		// REQUIRES: this must not be modified while the generator is in use
		
		return null;
	}
}
