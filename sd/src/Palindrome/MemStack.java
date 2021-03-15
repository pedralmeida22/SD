package Palindrome;

public class MemStack<R> extends MemObject<R> {
	private int index = 0;

	protected MemStack(int nElem) {
		super(nElem);
	}

	@Override
	protected void write(R val) throws MemException {
		if(index != nMax) {
			mem[index] = val;
			index++;
		}
	}

	@Override
	protected R read() throws MemException {
		if(index != 0) {
			index -= 1;
			return mem[index];
		}
		else throw new MemException("Stack empty!");
	}	
}
