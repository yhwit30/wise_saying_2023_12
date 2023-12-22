package com.ws;

public class Main {
	public static void main(String[] args) {		//프로그램의 시작.

		Container.init();

		new App().run();

		Container.close();
	}
}
