package Box;

import java.util.ArrayList;

public class ProductEx {

	public static void main(String[] args) {
		ArrayList <Product> pa = new ArrayList<>();
		
		Product <Tv, Integer> product1 = new Product<>(new Tv("삼성", "어쩌구"), 345);
		Product<String, Integer>product2 =new Product<>("엘지어쩌구", 234); 
		Product<Integer, Tv>product3 = new Product<>(12345, new Tv("기아", "어쩌구"));
		
		System.out.println(product2.showModel("엘지어쩌구"));
		
		pa.add(product1);
		pa.add(product2);
		pa.add(product3);
		
		for (Product p : pa) {
			System.out.println(p.getKind() + "  " + p.getModel());
		}
		
		
	}

}
