
public class Date {
	private int year = 1970;
	private int month = 1;
	private int day = 1;
	
	public Date (int yy, int mm, int dd) {
		setYear(yy);
		setMonth(mm);
		setDay(dd);
		}

	
	public void setYear(int yy) {
		if (yy < 1970) {
			yy = this.year;
		}else {this.year = yy;}
	}


	public void setMonth(int mm) {
		if (mm < 1 || mm > 12) {
			mm = this.month;
		}else {this.month = mm;}
	}


	public void setDay(int dd) {
		int [] lastDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (dd < 1 || dd > lastDay[month-1]) {
			dd = this.day;
		}else {this.day = dd;}
	}


	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public void showDate() {
		System.out.printf("<날짜>\n%d년 %d월 %d일\n" , getYear(), getMonth(), getDay() );
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date bDay = new Date (1956, 1, 15);
		Date today = new Date(2020, 13, 36);
		Date someday;
		someday = new Date (today.getYear(), today.getMonth(), today.getDay());
		
		System.out.println(today.getDay());
		bDay.showDate();
		today.showDate();
		someday.showDate();

	}

}
