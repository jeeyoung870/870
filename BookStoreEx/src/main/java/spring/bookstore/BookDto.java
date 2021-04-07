package spring.bookstore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookDto {
	
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	
	public BookDto() {}
	
	@Override
	public String toString() {
		return "BookDto [bookid=" + bookid + ", bookname=" + bookname + ", publisher=" + publisher + ", price=" + price
				+ "]";
	}
	
	
}
