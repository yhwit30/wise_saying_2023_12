package com.ws;

public class Main {
	public static void main(String[] args) {		//프로그램의 시작.

		Container.init();	//공유데이터를 시작

		new App().run();	//앱을 실행

		Container.close();	//공유데이터 끝
	}
}
