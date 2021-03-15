package Palindrome;

public class MemFIFO<R> extends MemObject<R> {
	private int inPnt = 0, outPnt = 0;
	private boolean empty = true;

	protected MemFIFO(int nElem) {
		super(nElem);
	}

	@Override
	protected void write(R val) throws MemException {
		if ((inPnt != outPnt) || empty) {
			mem[inPnt] = val;
			inPnt += 1;
			inPnt %= nMax;
			empty = false;
		}
	}

	@Override
	protected R read() throws MemException {
		R val = null;
		
		if((outPnt != inPnt) || !empty) {
			val = mem[outPnt];
			outPnt += 1;
			outPnt %= nMax;
			empty = (inPnt == outPnt);
		}
		else throw new MemException("Fifo empty");
		
		return val;
	}
}
