package com.qa.qacdb.utils;

import java.util.Scanner;

public class Utils {
	
	public static final String MYSQL_URL = "35.242.142.245:3306";
	public static final Scanner SCANNER = new Scanner(System.in);

	private Utils() {

	}

	public static String getInput() {
		return SCANNER.nextLine();
	}
	

}
