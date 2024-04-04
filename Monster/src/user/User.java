package user;

public class User {
	private String id;
	private String nickName;
	private String pw;

	public User(String id, String nickName, String pw) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
