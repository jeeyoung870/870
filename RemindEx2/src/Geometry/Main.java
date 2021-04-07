package Geometry;

public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Geo geo [] = new Geo[3];
		
		Triangle tri = new Triangle (10, 10, 30, 15);
		Rectangle rec = new Rectangle (100, 200, 40, 50);
		Circle cir = new Circle (400, 400, 25);
		
		geo[0] = tri;
		geo[1] = rec;
		geo[2] = cir;
		
		for (int i = 0; i < geo.length; ++i) {
			geo[i].draw();
		}
		for (Geo e : geo) {
			e.area();
		}
		
		
	
		

	}


}
