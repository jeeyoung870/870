
public class IncreaseDecreaseOperatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 10;
		int z;
		
		System.out.println("------------------------------");
		
		x++;
		++x;
		System.out.println("x= " + x);		//12
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		y--;
		--y;
		System.out.println("y= " + y);
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		z = x++;
		System.out.println("z= " + z);
		System.out.println("x= " + x);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		z = ++x;
		System.out.println("z= " + z);
		System.out.println("x= " + x);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		z = ++x + y++;	//x=14, y=8  // z출력값 = 15 + 8
		System.out.println("z= " + z);	//23
		System.out.println("x= " + x);	//15
		System.out.println("y= " + y);	//9		//위에서 ++,--연산하면 다음 출력때 반영
		
		
		

	}

}
