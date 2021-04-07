package Course;

public class Course <T> {
	private String name;
	private T[] students;
	
	public Course (String name, int capacity) {
		this.name = name;
		students = (T[]) (new Object[capacity]);	//타입 파라미터로는 new T[n]으로 생성불가
	}

	public String getName() {
		return name;
	}

	public T[] getStudents() {
		return students;
	}

	public void add (T t) {		//배열에 비어있는 부분을 찾아 수강생을 추가하는 메소드
		for (int i = 0; i < students.length; ++i) {
			if (students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}
}
