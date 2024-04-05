package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import main.Game;
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

	public String loadJob() {
		String data = "";
		try {
			file = new File("JobList.txt");
			if (file.exists()) {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				while (br.ready()) {
					data += br.readLine();
					data += "\n";
				}
				br.close();
				fr.close();
				data = data.substring(0, data.length() - 1);
			}
		} catch (Exception e) {
			System.err.println("직업 로드 실패" + e.getMessage());
		}
		userJobset(data);
		return data;
	}

	private void userJobset(String info) {
		String jobinfoTemp[] = info.split("\n");
		HashMap<String, String[]> jobinfo = new HashMap<>();
		for (int i = 0; i < jobinfoTemp.length; i++) {
			String temp[] = jobinfoTemp[i].split(":");
			String id = temp[0];
			String infoTemp[] = temp[1].split("-");
			jobinfo.put(id, infoTemp);
		}
		userManager = UserManager.getInstance();
		userManager.setJobData(jobinfo);
	}

	// id:job-map-x-y-hp-MAX_HP-mp-MAX_MP-power-level-xp
	public void saveJob(String job, String map, String id) {
		String data = "";
		data += id + ":" + map + "-" + job + "-" + Game.job.getHp() + "-" + Game.job.getMAX_HP() + "-"
				+ Game.job.getMp() + "-" + Game.job.getMAX_MP() + "-" + Game.job.getPower() + "-" + Game.job.getLevel()
				+ "-" + Game.job.getXp();
		System.out.println(data);
		try {
			file = new File("JobList.txt");
			fw = new FileWriter(file);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			System.err.println("직업 저장 실패");
		}
	}
}
