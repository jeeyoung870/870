package sec.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUser {

	private String name;
	private String password;
	private String confirm;
	
	public boolean isPasswordAndConfirmSame() {
		return password.equals(confirm);
	}
	
}
