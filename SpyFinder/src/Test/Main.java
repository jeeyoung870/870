package Test;

public class Main {
	public static int method (int value) {
		value = 100;
		return value;
	}
	public static void method2(MyClass r) {
		r.setValue(100);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 200;
		
		//method(i);
		
		
		System.out.println(method(i));
		
		MyClass o = new MyClass();
		
		method2(o);
		System.out.println(o.getValue());
	}

}
