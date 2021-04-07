package Exception;

public class NumberFormatException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data1 = "100";
		String data2 = "a100";
		
		int value1 = Integer.parseInt(data1);//()안의 문자열을 숫자로 변환시켜 주는 코드
		int value2 = Integer.parseInt(data2);	//int로 변환할 수 없는 값이라 에러 발생
		
		int result = value1 + value2;
		System.out.println(data1 + "+" + data2 + "=" + result);

	}

}
