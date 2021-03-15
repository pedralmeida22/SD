package Palindrome;

import genclass.*;

public abstract class MemObject<R> {
	protected R[] mem;
	protected int nMax;
	
	protected MemObject(int nElem) {
		mem = (R[]) new Object[nElem];
		this.nMax = nElem;
	}
	
	protected abstract void write(R val) throws MemException;
	protected abstract R read() throws MemException;
	
}
