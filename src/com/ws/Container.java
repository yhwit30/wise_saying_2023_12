package com.ws;

import java.util.Scanner;

public class Container {			// 클래스 전역에서 필요한 데이터를 입력받기 위한 공유자원
	private static Scanner sc;

	public static void init() {
		sc = new Scanner(System.in);
	}

	public static void close() {
		sc.close();
	}

	public static Scanner getScanner() {
		return sc;
	}
}
