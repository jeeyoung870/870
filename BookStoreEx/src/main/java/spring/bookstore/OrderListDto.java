package spring.bookstore;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderListDto {
//고객명, 책이름, 주문날짜
	
	private String name;
	private String bookname;
	private Date orderdate;
	
	public OrderListDto() {}
	
}
