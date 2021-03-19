package hils.Login.Model;

public class MemberDto {
	private String id_token;
	private String userName;
	private String email;
	private String userImg;
	private int enabled;

	public String getId_token() {
		return id_token;
	}

	public void setId_token(String id_token) {
		this.id_token = id_token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
