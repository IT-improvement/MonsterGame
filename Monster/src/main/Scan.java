package main;

import java.util.Scanner;

public class Scan {
	private Scanner scan = new Scanner(System.in);

	// input String
	public String inputString(String message) {
		System.out.print(message + ": ");
		return scan.next();
	}

	// input Num
	public int inputNum(String message) {
		int num = -1;
		try {
			System.out.print(message + ": ");
			String temp = scan.next();
			num = Integer.parseInt(temp);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return num;
	}
}
