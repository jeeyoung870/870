
public class CompareOperatorExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v2 = 1;
		double v3 = 1.0;
		System.out.println(v2 == v3);	//true
		
		double v4 = 0.1;
		float v5 = 0.1f;
		System.out.println(v4 == v5);	//false
		System.out.println((float)v4 == v5);	//true
		System.out.println(v4 < v5);	//true
		System.out.printf("%15.14f\n", v4);
		System.out.printf("%15.14f\n", v5);		//float쪽이 미세하게 더 큼
		System.out.println(v4*10 == v5*10);	//true (10을 곱하면 둘이 같아짐)?왜???
		
		int i1 = 10;
		int i2 = 10;
		int r1 = 2 * ++i1;
		int r2 = 2 * i2++;
		System.out.println(r1);	//22
		System.out.println(r2);	//20
		System.out.println(i2);	//11
		
	}

}
