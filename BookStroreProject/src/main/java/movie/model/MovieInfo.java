package movie.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MovieInfo {
	
	String movieCd;
	String movieNm;
	String movieNmEn;
	ArrayList<Actor> actors = new ArrayList<Actor>();
	ArrayList<Director> directors = new ArrayList<Director>();
	String showTm;
	String prdtYear;
	String openDt;	//개봉연도
	
}
