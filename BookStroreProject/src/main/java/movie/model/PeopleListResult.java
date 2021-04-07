package movie.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PeopleListResult {
	
	String totCnt;
	ArrayList<Peoples> peopleList = new ArrayList<Peoples>();
}
