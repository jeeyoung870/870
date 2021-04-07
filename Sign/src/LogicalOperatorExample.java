
public class LogicalOperatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//&와 &&, |와 ||는 같은 결과값이 나오지만 
		//&, |는 모든 연산을 수행하고, &&, ||는 앞의 연산자가 조건에 부합하면 뒤의 연산자는 수행X
		int charCode = 'A';
		
		if ((charCode >= 65) & (charCode <= 90)) {	
			System.out.println("대문자입니다.");
		}
		
		if ((charCode >= 97) && (charCode <= 122)) {
			System.out.println("소문자입니다.");
		}
		
		if (!(charCode < 48) && !(charCode > 57)) {
			System.out.println("0~9 숫자입니다.");
		}
		
		int value = 6;
		
		if ((value%2 == 0) | (value%3 == 0)) {
			System.out.println("2 또는 3의 배수입니다.");
		}
		
		if ((value%2 == 0) || (value%3 == 0)) {
			System.out.println("2 또는 3의 배수입니다.");
		}
 
	}
}