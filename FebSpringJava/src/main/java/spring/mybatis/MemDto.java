package spring.mybatis;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemDto {
	
	private String memberid;
	private String password;
	private String name;
	private String email;
	
	public MemDto() {}
	
	public MemDto(String memberid, String password, String name, String email) {
		super();
		this.memberid = memberid;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	

}
