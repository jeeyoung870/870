
public class Calculator {
	
	double areaRectangle (double width)  {	//메소드 오버로딩
		return width * width;
	} 		//매개 변수의 타입, 순서, 개수 중 하나가 다르면, 이름이 같은 메소드로 사용할 수 있다.

	double areaRectangle (double width, double height) {
		return width * height;
	}
}
