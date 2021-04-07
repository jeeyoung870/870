package spring.di;

public class Foo {
	
	Bar bar;
	Baz baz;
	
	String str;
	int i;
	
	public void start() { 
		System.out.println("start 실행");
	}
	public void stop() { 
		System.out.println("stop 실행");
	}
	
	
	//setter로 사용하려면 기본생성자를 꼭 만들어야 한다.
	public Foo() {
		super();
	}
	
	public void setBar(Bar bar) {
		this.bar = bar;
	}


	public void setBaz(Baz baz) {
		this.baz = baz;
	}


	public void setStr(String str) {
		this.str = str;
	}


	public void setI(int i) {
		this.i = i;
	}


	public Foo(Bar bar, Baz baz) {
		super();
		this.bar = bar;
		this.baz = baz;
	}
	
	
	public Foo(Bar bar, Baz baz, String str, int i) {
		super();
		this.bar = bar;
		this.baz = baz;
		this.str = str;
		this.i = i;
	}

	public void doFooBaz() {
		System.out.println("doFooBaz() 실행");
		baz = getBaz();	//lookup메소드 호출
		baz.doBaz();
	}
	
	//lookup()메소드
	public Baz getBaz() {
		return null;	//컨테이너에 있는 Baz타입객체가 리턴되도록 오버라이딩될예정
	}

	
	public void doFoo() {
		System.out.println("doFoo 실행");
		System.out.println("str : " + str + ", i : " + i);
		bar.doBar();
	}

}
