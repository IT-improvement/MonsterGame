package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import user.User;
import user.UserManager;

public class FileManager {

	private UserManager userManager;

	private File file;
	private FileReader fr;
	private FileWriter fw;
	private BufferedReader br;

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
		ArrayList<User> userList = userManager.getAll();
		String data = "";
		for (User user : userList) {
			data += user.getId() + "-" + user.getNickName() + "-" + user.getPw() + "\n";
		}
		try {
			file = new File("UserList.txt");
			fw = new FileWriter(file);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			System.err.println("저장오류");
		}
	}
}
