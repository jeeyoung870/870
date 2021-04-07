package MyFunctionalInterfaceEx;

public class RunnableEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable run = () -> {				//매개값이 없는 interface일 경우
			for (int i = 0; i <10; ++i) {	//람다식 스레드가 실행하는 코드
				System.out.println(i);
			}
		};
		run.run();
		
		Thread thread = new Thread( () -> {	//Thread의 매개값에 람다식을 대입
			for (int i = 0; i <10; ++i) {	
				System.out.println(i);
			}
		});
		thread.start();

	}

}
