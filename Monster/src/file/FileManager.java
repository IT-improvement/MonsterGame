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
	}

	private static FileManager instance = new FileManager();

	public static FileManager getInstance() {
		return instance;
	}

	public void loadUser() {
		ArrayList<User> userList = new ArrayList<>();
		String data = "";
		try {
			file = new File("UserList.txt");
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while (br.ready()) {
				data += br.readLine();
				data += "\n";
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.err.println("유저 로드 실패");
		}
		data = data.substring(0, data.length() - 1);
		String userListTemp[] = data.split("\n");
		for (int i = 0; i < userListTemp.length; i++) {
			String userInfo[] = userListTemp[i].split("-");
			User user = new User(userInfo[0], userInfo[1], userInfo[2]);
			userList.add(user);
		}
		userManager = UserManager.getInstance();
		userManager.setUser(userList);
	}

	public void saveUser() {
		userManager = UserManager.getInstance();
		ArrayList<User> userList = userManager.getAll();
		String data = "";
		for (User user : userList) {
			data += user.getId() + "-" + user.getNickName() + "-" + user.getPw() + "\n";
		}
		data = data.substring(0, data.length() - 1);
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
