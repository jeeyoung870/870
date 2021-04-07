
class Stack <T> implements IStack<T> {		//제네릭으로 <변수 형식>의 클래스 만들기. 모든 타입의 변수에 사용가능한 클래스
	
	private T [] v;
	private int count;
	
	public Stack (int size) {	//생성자
		v = (T []) new Object [size];
		count = 0;
	}
	public void push (T item) {	//메소드
		v[count++] = item;
	}
	public T pop () {
		return v[--count];
	}
	public int size () {
		return count;
	}
	public boolean compareSize(Stack <T> o) {
		return size () > o.size() ? true : false;
	}
	
}
