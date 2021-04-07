package MapCollection;

import java.util.*;

public class HashMapEx2 {

	public static void main(String[] args) {
		Map<Student, Integer> stuMap = new HashMap<>();
		
		stuMap.put(new Student(1, "wowow"), 95);
		stuMap.put(new Student(1, "wowow"), 70);
		stuMap.put(new Student(2, "mimi"), 80);
		stuMap.put(new Student(3, "caca"), 68);
		
		System.out.println("총 Entry 수 : " + stuMap.size());	//3
		System.out.println(stuMap.get(new Student(1, "wowow")));	//70

		
	}

}
