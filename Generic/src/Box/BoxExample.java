package Box;

public class BoxExample {

	public static void main(String[] args) {
		Box <String> box1 = new Box<>();
		box1.set("Hello");
		
		String str = box1.get();
		System.out.println(str);
		
		Box <Integer> box2 = new Box <>();
		box2.set(6);
		System.out.println(box2.get());

	}

}
