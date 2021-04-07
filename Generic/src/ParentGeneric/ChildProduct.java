package ParentGeneric;

public class ChildProduct<T, M, C> extends Product<T, M> {	//자식 제네릭 클래스
	//부모 클래스에서 생성자를 만들었으면 여기서도 똑같이 불러와야 함
	private C company;
	
	public C getCompany() {
		return this.company;
	}
	public void setCompany(C c) {
		this.company = c;
	}
	

}
