public class Date {
	private int year;
	private int month;
	private int day;
	
	private int max(int x, int y) {
		if(x > y)
			return x;
		return y;
	}
	
	private int min(int x, int y) {
		if (x < y)
			return x;
		return y;
	}
	
	
	public Date() {
		year = 1990;
		month = 1;
		day = 1;
	}
	public Date (int yy, int mm, int dd) {
		setDate(yy, mm, dd);
	}
	public void setDate(int yy, int mm, int dd) {	//년, 월, 일 받는 범위설정
		int [] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//참조변수
		year = max(1990, yy);
		month = max(1, mm);	//1보다 큰 동시에
		month = min(month, 12);	//12보다는 작은 숫자
		day = max(1, dd);	//1보다 큰 동시에 
		day = min(day, days[month-1]);	//각월 말일보다는 작은 숫자.[]는 0부터 카운트하므로 month값에서 -1한다.
	}
	
	public void displayDate () {	//값이름.displytDate() 입력할때의 명령어
		System.out.printf("%4d - %2d - %2d\n", year, month, day);	//%4d=4자리수 데이터값
	}
	
}













