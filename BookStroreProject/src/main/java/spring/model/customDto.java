package spring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class customDto {
	
	private int custid;
	private String name;
	private String address;
	private String phone;
	
	public customDto() {}
	
}
