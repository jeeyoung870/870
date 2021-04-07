package MaxMethod;


public class Stack <T> {
	public Stack(int size) {
		v = (T[])new Object[size];
		count = 0;
	}
	public void push(T item) {
		v[count++] = item;
	}
	public T pop() {
		return v[--count];
	}
	
	public int size() {
		return count;
	}
	
	public boolean compareSize(Stack<?> o) {
		return size() > o.size() ? true : false;
	}
	
	private T[] v;
	private int count;
}
