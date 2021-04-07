package Computer;

public class ComputerExample {		//오버라이딩 테스트

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = 10;
		
		Calculator calculator = new Calculator();
		System.out.println("원면적 : " + calculator.areaCircle(r));
		System.out.println();
		
		Computer computer = new Computer();
		System.out.println("원면적 : " + computer.areaCircle(r));
		
		System.out.println(Math.PI);
	}

}
