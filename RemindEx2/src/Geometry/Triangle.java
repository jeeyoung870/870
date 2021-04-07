package Geometry;

public class Triangle extends Geo {
	private int below;
	private int height;
	
	public Triangle (int x, int y, int b, int h) {
		super(x, y);
		this.below = b;
		this.height = h;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.printf("삼각형 좌표 : (%d, %d) 밑변 : %d, 높이 : %d\n", x, y, below, height);

	}

	@Override
	public void area() {
		// TODO Auto-generated method stub
		System.out.println("삼각형의 넓이 : " + below*height/2);

	}

}
