package APIFunctionalInterface;

import java.util.function.IntBinaryOperator;

//Operator 함수적 인터페이스는 매개 변수와 리턴값이 있는 applyXXX()메소드를 가짐.
//매핑보다는 매개값을 이용해 연산을 수행하고, 동일타입으로 리턴값 제공.
//BinaryOperator<T>	//T apply(T t, T t)		//T와 T를 연산한 후 T타입으로 리턴
//UnaryOperator<T>	//T apply(T t)		//T 연산후 T 리턴
//DoubleBinaryOperator	//double applyAsDouble(double, double)	//두 개의 double 연산
//DoubleUnaryOperator	//double applyAsDouble(double)	//한 개의 double 연산
//IntBinaryOperator ---- IntUnaryOperator
//LongBinaryOperator ---- LongUnaryOperator
public class OperatorIEx {
	private static int [] scores = {92, 95, 87, 90};
	
	public static int maxOrMin (IntBinaryOperator operator) {
		int result = scores[0];
		for (int i : scores) {
			result = operator.applyAsInt(result, i);
		}	//위에서 결정된 result, i가 람다식의 a, b로 들어가서,
		//(IntBinaryOperator operator)의 실행문에 해당하는 람다식의{}속 연산에 쓰이고 return됨.
		return result;
	};
	
	//실행
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//최대값 얻기
		int max = maxOrMin(
				(a, b) -> {				//메소드에 들어온 int 두 개로 연산
					if (a >= b) return a;
					else return b;
				});
		System.out.println("최대값 : " + max);
		
		//최소값 얻기
		int min = maxOrMin (
				(a, b) -> {
					if (a <= b) return a;
					else return b;
				}
				);
		System.out.println("최소값 : " + min);

		int printEach = maxOrMin (			//설명 필요,,
				(a, b) -> {
					System.out.println(a +"  " + b);
					if (a >=
							b) return a;
					else return b;
				}
				);
		System.out.println(printEach);
	}

}
