package user;

public class GuildManager {
	private GuildManager() {

	}

	private static GuildManager instance = new GuildManager();

	public static GuildManager getInstance() {
		return instance;
	}
}
