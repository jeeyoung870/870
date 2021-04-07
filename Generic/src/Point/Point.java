package Point;

public class Point implements Comparable {
	private int x;
	private int y;
	
	public Point (int x, int y) {
		this.x = x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Point p = (Point)o;
		if (x == p.x && y == p.y)
			return 0;
		else if (x < p.x && y < p.y)
			return -1;
		return 1;
	}
	
	

}
