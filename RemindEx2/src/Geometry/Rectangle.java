package Geometry;

public class Rectangle extends Geo {
	private int width;
	private int height;
	
	public Rectangle (int x, int y, int w, int h) {
		super(x, y);
		this.width = w;
		this.height = h;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.printf("사각형 좌표 : (%d, %d) 가로 : %d, 세로 : %d\n", x, y, width, height);
	}

	@Override
	public void area() {
		// TODO Auto-generated method stub
		System.out.println("사각형의 넓이 : " + width*height);
	}

}
