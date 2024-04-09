package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import main.Game;

public class GuildManager {

	private static HashMap<String, ArrayList<User>> guildList;

	private GuildManager() {
		guildList = new HashMap<>();
	}

	private static GuildManager instance = new GuildManager();

	public static GuildManager getInstance() {
		return instance;
	}

	/* C(insert) */
	public void createGuild(String guildName) {
		ArrayList<User> userList = new ArrayList<>();
		userList.add(Game.user);
		guildList.put(guildName, userList);
		System.out.println("여기");
	}

	public void addGuild(String guildName) {
		ArrayList<User> userList = guildList.get(guildName);
		userList.add(Game.user);
		guildList.replace(guildName, userList);
	}

	/* R(select) */
	public int size() {
		return guildList.size();
	}

	public boolean checkName(String guildName) {
		Set keySet = guildList.keySet();
		Iterator<String> keys = keySet.iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			if (key.equals(guildName))
				return true;
		}
		return false;
	}

	public boolean checkUser(User user) {
		if (guildList.size() == 0)
			return false;

		Set keySet = guildList.keySet();
		Iterator<String> keys = keySet.iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			ArrayList<User> userList = guildList.get(key);
			for (int i = 0; i < userList.size(); i++) {
				User target = userList.get(i);
				if (target.getId().equals(user.getId()))
					return true;
			}
		}
		return false;
	}

	/* U(update) */

	/* D(delete) */
	public void deleteGuild() {
		boolean checkLeader = checkLeader();
		if (checkLeader) {
			Set keySet = guildList.keySet();
			Iterator<String> keys = keySet.iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				ArrayList<User> userList = guildList.get(key);
				for (int i = 0; i < userList.size(); i++) {
					User target = userList.get(i);
					if (target.getId().equals(Game.user.getId())) {
						guildList.remove(key);
						return;
					}
				}
			}
		} else {
			Set keySet = guildList.keySet();
			Iterator<String> keys = keySet.iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				ArrayList<User> userList = guildList.get(key);
				for (int i = 0; i < userList.size(); i++) {
					User target = userList.get(i);
					if (target.getId().equals(Game.user.getId())) {
						userList.remove(i);
						guildList.replace(key, userList);
						return;
					}
				}
			}
		}
	}

	private boolean checkLeader() {
		Set keySet = guildList.keySet();
		Iterator<String> keys = keySet.iterator();
		int index = -1;
		while (keys.hasNext()) {
			String key = keys.next();
			ArrayList<User> userList = guildList.get(key);
			for (int i = 0; i < userList.size(); i++) {
				User target = userList.get(i);
				if (target.getId().equals(Game.user.getId())) {
					index = i;
				}
			}
		}
		if (index == 0)
			return true;
		else
			return false;
	}
}
