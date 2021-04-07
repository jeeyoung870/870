package movie.model;

import java.util.ArrayList;

public class MovieListResult {

    String boxofficeType;
    String showRange;

    ArrayList<Movie> dailyBoxOfficeList = new ArrayList<Movie>();

	public String getBoxofficeType() {
		return boxofficeType;
	}

	public void setBoxofficeType(String boxofficeType) {
		this.boxofficeType = boxofficeType;
	}

	public String getShowRange() {
		return showRange;
	}

	public void setShowRange(String showRange) {
		this.showRange = showRange;
	}

	public ArrayList<Movie> getDailyBoxOfficeList() {
		return dailyBoxOfficeList;
	}

	public void setDailyBoxOfficeList(ArrayList<Movie> dailyBoxOfficeList) {
		this.dailyBoxOfficeList = dailyBoxOfficeList;
	}

    
    
}
