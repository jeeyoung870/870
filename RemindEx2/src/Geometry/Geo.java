package Geometry;

public abstract class Geo {
	protected int x;
	protected int y;	//protected = 같은 패키지 안의 클래스들은 접근가능
	
	public Geo (int x, int y) {
	}

	public abstract void draw();

	public abstract void area();

}
