
public class Main {

	public static void main(String[] args) {
		// sending message	Date.java에서 참조
		Date currentDate;	//참조변수=user defined datafile(개발자가 만든 데이터를 가져옴)
		
		currentDate = new Date();	//생성되어 있던 Date인스턴스에 접근할수 있게 됨
		currentDate.displayDate();
		
		Date today = new Date(2020, 11, 9);
		today.displayDate();
		
	}

}
