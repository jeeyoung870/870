
public class Computer {
	int sum1(int [] values) {	//매개 변수의 수를 모르 경우
		int sum = 0;
		for (int i = 0; i < values.length; ++i) {
			sum += values[i];
		}
		return sum;
	}

	int sum2 (int ... v) {
		int sum = 0;
		for (int i = 0; i < v.length; ++i) {
			sum += v[i];
		}
		return sum;
	}
}
