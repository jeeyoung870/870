import java.util.ArrayList;

public class ArrayListExample {
	
	public static void main (String [] args) {
		//자바유틸의 ArrayList 클래스의 객체 생성하기(제네릭을 사용하는 무제한 배열 클래스)
		//일반배열과의 차이점 :
		//처음에 객체생성을 할때 몇 개의 배열을 만들 건지 선언하지 않아도 입력받은 개수만큼 카운트해줌.
		//java Collections Framework 기능 중 하나.
		ArrayList <String> arraytest = new ArrayList <String> ();
		arraytest.add("마미무ㅔㅁ모");	//0번째 Index
		arraytest.add("stupid");	//1번째 Index
		arraytest.add("ButImACreep");
		arraytest.add("ImAWeirdo");
		arraytest.add("WhatTheHellImDoingHere");
		arraytest.add("IDontBelongHere");
		
		System.out.println(arraytest.get(5));
		//ArrayList 객체에 저장된 Index 출력. 객체명.get(Index);
		for (String e : arraytest) {
			System.out.println(e);
		}
		
		ArrayList <Double> arr = new ArrayList <Double>();
		//<Double>, <Integer> 등 설정해주지 않고 .add하면 Object타입으로 저장됨.
		arr.add(354.0);
		arr.add(1008.7979);
		arr.add(12.0);
		arr.add(1010.272);
		arr.add(90.1);
		
		for (int i = 0; i < arr.size(); ++i) {	//제네릭 ArrayList는 .size()로 길이 측정함
			System.out.println(arr.get(i));
		}
		
		//배열을 위한 for - each 반복문.(값타입 e : 변수명)으로, e = arr.get(i)
		for (Double e : arr) {	
			System.out.println(e);
		}
		
		
		int [] itt = {1, 5, 3, 55};
		for (int j = 0; j <itt.length; ++j) {
			System.out.println(itt[j]);
		}
		
	}

}
