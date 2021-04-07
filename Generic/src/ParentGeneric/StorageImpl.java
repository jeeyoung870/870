package ParentGeneric;

public class StorageImpl<T> implements Storage<T> {
//제네릭<T> 인터페이스를 구현한 클래스도 제네릭 타입이어야 한다.
	private T [] array;
	
	public StorageImpl (int capacity) {
		this.array = (T[]) new Object[capacity];
		//타입 파라미터로 배열 만들기
	}
	
	@Override
	public void add(T item, int index) {
		array[index] = item;
		
	}

	@Override
	public T get(int index) {
		return array[index];
	}

	
}
