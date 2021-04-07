package Exception;

public class ArrayOutOfBoundsException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data1 = args[0];
		String data2 = args[1];
		
		System.out.println("args[0]: " + data1);
		System.out.println("args[1]: " + data2);	//실행 매개값을 주지 않았기 떄문에 인덱스 사용불가
			//Run - Run Configurations - Arguments에 매개값을 입력해주면 에러 발생하지 않음

	}

}
