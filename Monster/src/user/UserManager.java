package user;

import java.util.ArrayList;
import java.util.HashMap;

import file.FileManager;

public class UserManager {

	private FileManager fileManager;

	public static ArrayList<User> userList;

	public static HashMap<String, String[]> jobData;

	private UserManager() {
		userList = new ArrayList<>();
		jobData = new HashMap<>();
	}

	private static UserManager instance = new UserManager();

	public static UserManager getInstance() {
		return instance;
	}

	/* C */
	public void addUser(String id, String pw, String nickName) {
		User user = new User(id, nickName, pw);
		userList.add(user);
		fileManager = FileManager.getInstance();
		fileManager.saveUser();
	}

	public void setUser(ArrayList<User> users) {
		userList = users;
	}

	public static HashMap<String, String[]> getJobData() {
		return jobData;
	}

	public void setJobData(HashMap<String, String[]> info) {
		jobData = info;
	}

	/* R */
	public ArrayList<User> getAll() {
		return userList;
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

	public User checkLogIn(String id, String pw) {
		for (User user : userList)
			if (user.getId().equals(id))
				if (user.getPw().equals(pw))
					return user;

		return null;
	}
	
	public void setJob() {
		
	}

	/* U */

	/* D */

}
