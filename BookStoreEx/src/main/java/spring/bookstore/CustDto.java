package spring.bookstore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustDto {
	
	private int custid;
	private String name;
	private String address;
	private String phone;
	
	public CustDto() {}

	public CustDto(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	

}
