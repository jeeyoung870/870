package APIFunctionalInterface;

import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;

//Supplier 함수적 인터페이스는 매개변수가 없고, 리턴값이 있는 getXXX()메소드를 가짐.
	//Supplier <T>	//T get()	//T 객체 리턴
	//BooleanSupplier	//boolean getAsBoolean()	//boolean 값을 리턴
	//DoubleSupplier	//double getAsDouble()	//double 값을 리턴
	//IntSupplier	//int getAsInt()	//int 값을 리턴
	//LongSupplier 	//long getAsLong()	//long 값을 리턴

public class SupplierIEx {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntSupplier intS = () -> {
			int num = (int)(Math.random()*6) + 1;	//주사위 랜덤뽑기
			return num;					//return문 꼭 넣어야 함.
		};
		
		int num = intS.getAsInt();
		System.out.println(num);

		
		BooleanSupplier boolS = () -> {
			int num1 = (int)(Math.random()*2);
			if (num1 == 0) {
				return false;
			}return true;
		};
		System.out.println(boolS.getAsBoolean());
	}

}
