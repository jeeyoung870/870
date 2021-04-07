package APIFunctionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;
//Consumer타입 인터페이스는 매개값을 받아 소비하김나 한다.
public class ConsumerIEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1가지 타입의 객체
		Consumer<String> consumer = (t) -> {
			System.out.println(t + "11");
		};
		consumer.accept("java");
		
		//2가지 타입의 객체(둘이 같아도 상관없음)
		BiConsumer<String, Integer> biConsumer = (t, u) -> {
			System.out.println(t + u);
		};
		biConsumer.accept("java", 8);
		
		//double값을 받는 객체 (IntConsumer, LongConsumer 가능)
		DoubleConsumer dConsumer = (d) -> {
			System.out.println("java" + d);
		};
		dConsumer.accept(9.0);
		
		//object(객체 1타입)+Integer타입을 받아 소비하는 인터페이스
		//ObjIntConsumer, ObjDoubleConsumer, ObjLongConsumer
		ObjIntConsumer <String> objIntCon = (t, i) -> {	//<>안에 객체명만 써주면 됨.
			System.out.println(t + i);
		};
		objIntCon.accept("java", 10);

	}

}
