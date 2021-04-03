package hils.Login.Model;

public class MemberDto {
	private String user_name;
	private String user_email;
	private String userImg;
	private int enabled;

	public String getUserName() {
		return user_name;
	}

	public void setUserName(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return user_email;
	}

	public void setEmail(String user_email) {
		this.user_email = user_email;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

}
