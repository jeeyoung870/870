package sec.custom;

import lombok.Getter;

@Getter
public class UserInfo {

	private String id;
	private String name;
	private String password;
	
	public UserInfo(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	
}
