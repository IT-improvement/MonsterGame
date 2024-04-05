package file;

import user.UserManager;

public class FileManager {

	private UserManager userManager;

	private FileManager() {
		userManager = UserManager.getInstance();
	}

	private static FileManager instance = new FileManager();

	public static FileManager getInstance() {
		return instance;
	}

	public void loadUser() {

	}

	public void saveUser() {

	}
}
