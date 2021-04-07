package Geometry;

public class Circle extends Geo {
	private int radius;
	
	public Circle (int x, int y, int r) {
		super(x, y);
		this.radius = r;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.printf("원 좌표 : (%d, %d) 반지름 : %d\n", x, y, radius);
	}

	@Override
	public void area() {
		// TODO Auto-generated method stub
		System.out.println("원의 넓이 : " + Math.PI*radius*radius);
	}

}
