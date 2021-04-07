package StackEx;

public class Stack <T> implements IStack<T> {
	private T [] v;
	private int count;
	
	public Stack (int size) {
		v = (T []) new Object[size];
		count = 0;
	}

	@Override
	public void push(T o) {
		// TODO Auto-generated method stub
		v[count++] = o;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return v[--count];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
	
	public String compareSize (Stack o) {
		String str = this.size() > o.size() ? "요소가 더 많음." : "요소가 더 적음.";
		return str;
	}

}
