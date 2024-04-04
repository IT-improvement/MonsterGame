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
}
