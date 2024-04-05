package file;

public class FileManager {
	private FileManager() {

	}

	private static FileManager instance = new FileManager();

	public static FileManager getInstance() {
		return instance;
	}
}
