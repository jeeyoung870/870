package sec.custom;

import lombok.Getter;

@Getter
public class UserPermission {
	
	private Long id;
	private String name;
	
	public UserPermission(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
