package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App {

	private byte system_status = 1;	//while반복문 반복을 시킴과 동시에 끝내는 역할도 맡기위해

	public App() {

	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");

		SystemController systemController = new SystemController();				//시스템컨트롤러에 접근해서 메소드 실행을 위해서 생성
		WiseSayingController wiseSayingController = new WiseSayingController();	//명언컨트롤러에 접근해서 메소드 실행을 위해서 생성

		while (system_status == 1) {								//명령어를 계속받기위함
			System.out.print("명령어 ) ");
			String cmd = Container.getScanner().nextLine().trim();
			Rq rq = new Rq(cmd);									//입력값을 나눠주는 일을 하청에 요청

			switch (rq.getActionCode()) {			//하청이 잘라준 첫 단어를 가져왔다.
			case "종료":
				systemController.exit();
				system_status = 0;
				break;
			case "등록":
				wiseSayingController.write();
				break;
			case "목록":
				wiseSayingController.list();
				break;
			case "삭제":
				wiseSayingController.remove(rq);	//잘라주는 작업을 맡기면서 삭제를 요청
				break;
			case "수정":
				wiseSayingController.modify(rq);	//수정하는 작업을 요청
				break;
			default:
				System.out.println("존재하지 않는 명령어입니다");
				break;
			}
		}

	}
}