package user;

import java.util.ArrayList;

public class UserManager {
	private ArrayList<User> userList;

	private UserManager() {
		userList = new ArrayList<>();
	}

	private static UserManager instance = new UserManager();

	public static UserManager getInstance() {
		return instance;
	}

	/* C */
	public void addUser(String id, String pw, String nickName) {
		User user = new User(id, nickName, pw);
		userList.add(user);
	}

	/* R */
	public String findId(String id) {
		for (User user : userList)
			if (user.getId().equals(id))
				return user.getId();
		return null;
	}

	public String findNickName(String nickName) {
		for (User user : userList)
			if (user.getNickName().equals(nickName))
				return user.getNickName();
		return null;
	}

	public User checkLogIn(String id, String pw) {
		for (User user : userList)
			if (user.getId().equals(id))
				if (user.getPw().equals(pw))
					return user;

		return null;
	}

	/* U */

	/* D */

}
