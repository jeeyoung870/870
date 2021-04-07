package FunctionalInterfaceEx;

public class Student {
	private String name;
	private int englishScore;
	private int mathScore;
	
	public Student (String name, int eS, int mS) {
		this.name = name;
		this.englishScore = eS;
		this.mathScore = mS;
	}

	public String getName() {
		return name;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}
	
	

}
