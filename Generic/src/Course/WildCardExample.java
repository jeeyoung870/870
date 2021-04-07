package Course;
import java.util.Arrays;

public class WildCardExample {
	public static void registerCourse (Course<?> course) {	//=모든 과정을 뜻함.
		System.out.println(course.getName() + "수강생" + Arrays.toString(course.getStudents()));
	}											//Arrays의 toString 이라는 정적 메소드는 배열을 문자열그대로 반환해줌
	public static void registerCourseStudent (Course<? extends Student> course) {//학생 과정
		System.out.println(course.getName() + "수강생" + Arrays.toString(course.getStudents()));
	}
	public static void registerCourseWorker (Course<? super Worker> course) {//직장인,일반인과정
		System.out.println(course.getName() + "수강생" + Arrays.toString(course.getStudents()));
	}		//super Worker는 Worker클래스 포함한 모든 상위클래스까지 포함한다는 뜻이다.
	
	public static void main(String [] srgs) {
		Course <Person> personCourse = new Course<Person>("일반인과정", 5);	//5개의 과정을 가진 일반인과정
		personCourse.add(new Person ("일반인"));
		personCourse.add(new Worker ("직장인"));
		personCourse.add(new Student ("학생"));
		personCourse.add(new HighStudent ("고등학생"));
		
		Course<Worker> workerCourse = new Course <Worker>("직장인과정", 5);
		workerCourse.add(new Worker ("직장인"));
		Course<Student> studentCourse = new Course <Student>("학생과정", 5);
		studentCourse.add(new Student ("학생"));
		studentCourse.add(new HighStudent ("고등학생"));
		Course<HighStudent> highStudentCourse = new Course <HighStudent>("고등학생과정", 5);
		highStudentCourse.add(new HighStudent ("고등학생"));
		
		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highStudentCourse);
		System.out.println();
		
		//registerCourseStudent(personCourse);		(X)
		//registerCourseStudent(workerCourse);		(X)
		registerCourseStudent(studentCourse);
		registerCourseStudent(highStudentCourse);	//학생과정만 수강가능
		System.out.println();
		
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);		//직장인 , 일반인과정만 수강가능
		//registerCourseWorker(studentCourse);
		//registerCourseWorker(highStudentCourse);
		
		
		
		
		
		
		
		
	}
}
