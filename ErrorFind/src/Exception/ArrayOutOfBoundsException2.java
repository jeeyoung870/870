package Exception;

public class ArrayOutOfBoundsException2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 2) {
			String data1 = args[0];
			String data2 = args[1];
			System.out.println("args[0] : " + data1);
			System.out.println("args[1] : " + data2);	//Arguments값이 2개 초과여도 에러 발생
		}else {
			System.out.println("[실행 방법]");
			System.out.println("java ArrayOutOfBoundsException2 ");
			System.out.print("값1, 값2");
		}

	}

}
