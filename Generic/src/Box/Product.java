package Box;

public class Product <T, M> {
	private T kind;
	private M model;
	
	public Product (T t, M m) {
		this.kind = t;
		this.model = m;
	}
	
	public T getKind() {	//T는 return문의 kind의 타입을 지정함.M이라고 쓰면 오류
		return kind;
	}
	public M getModel() {
		return model;
	}
	
	public <T> M showModel(T t) {	//public <매개변수타입> 리턴타입 메소드명(T t)
		return model;				//클래스에서 정의한 파라미터와 같다면 생략이 가능함.
	}
	
	

}
