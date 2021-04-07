package MaxMethod;


public class Map <T extends Number, V> {
	private T [] key;
	private V [] value;
	int count;
	public Map(int size) {
//		key = (T[])new Object[size];
		key = (T[])new Number[size];
		value = (V[])new Object[size];
		count = 0;
	}
	
	public void push(T k, V v) {
		key[count] = k;
		value[count] = v;
		count++;
	}
	
	public V get(T k) {
		for(int i = 0; i < count; ++i)
			if(key[i] == k)
				return value[i];
		return null;
	}
}
