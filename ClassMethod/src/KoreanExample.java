
public class KoreanExample {
	public static void main(String [] args) {
		Korean k1 = new Korean("박지바", "011225-1234567", "여");
		System.out.println("k1 name : " + k1.name);
		System.out.println("k1 ssn : " + k1.ssn);
		System.out.println("k1 sex : " + k1.sex);
		
		Korean k2 = new Korean("깁자바", "011125-1234561", "남");
		System.out.println(k2.name + " : " + k2.ssn);
		System.out.println(k2.nation);
	}
}
