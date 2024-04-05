package main;

import user.User;
import user.UserManager;

public class Start {

	UserManager userManager = UserManager.getInstance();

	/* print Method */
	private void printGuideMessage() {
		System.out.println("1)회원가입");
		System.out.println("2)로그인");
	}

	public User run() {
		User user = null;
		while (user == null) {
			printGuideMessage();
			int sel = Scan.inputNum("메뉴");
			user = menu(sel);
		}
		return user;
	}

	private User menu(int sel) {
		User user = null;
		if (sel == 1) {
			signUp();
			user = null;
		} else if (sel == 2) {
			user = signIn();
			if (user == null) {
				System.err.println("아이디 또는 비밀번호가 일치하지 않습니다.");
			}
		}
		return user;
	}

	/* 회원가입 */
	private void signUp() {
		String id = Scan.inputString("아이디");
		if (userManager.findId(id) != null) {
			System.err.println("이미 있는 아이디입니다.");
			return;
		}
		String pw = Scan.inputString("비밀번호");
		String pwCheck = Scan.inputString("비밀번호확인");
		if (!pw.equals(pwCheck)) {
			System.err.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		String nickName = Scan.inputString("닉네임");
		if (userManager.findNickName(nickName) != null) {
			System.err.println("이미 있는 닉네임입니다.");
			return;
		}
		userManager.addUser(id, pwCheck, nickName);
	}

	/* 로그인 */
	private User signIn() {
		String id = Scan.inputString("아이디");
		String pw = Scan.inputString("비밀번호");
		return userManager.checkLogIn(id, pw);
	}
}
