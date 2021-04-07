package spring.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class salesDto {
	
	private String bookname;
	private String publisher;
	private int price;
	private int saleprice;
	private int count;
	private Date orderdate;
	
	public salesDto() {	}
	

}
