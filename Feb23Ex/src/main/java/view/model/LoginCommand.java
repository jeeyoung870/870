package view.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginCommand {
	
	private String id;
	private String password;
	private String loginType;
}
