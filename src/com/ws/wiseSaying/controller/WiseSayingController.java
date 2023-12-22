package com.ws.wiseSaying.controller;

import java.util.List;

import com.ws.Container;
import com.ws.Rq;
import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.service.WiseSayingService;

public class WiseSayingController {

	private WiseSayingService wiseSayingService;

	public WiseSayingController() {
		wiseSayingService = new WiseSayingService();				//명언서비스에 매소드 실행을 위해 생성
	}

	public void write() {
		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		int id = wiseSayingService.write(content, author);			//서비스에 등록하라고 하는데 '명언'과 '작가'를 준다.

		System.out.printf("%d번 명언이 등록되었습니다.\n", id);
	}

	public void list() {
		List<WiseSaying> wiseSayings = wiseSayingService.findAll();	//배열을 받아온다.

		System.out.println("번호  /  작가  /  명언  ");
		System.out.println("=".repeat(30));

		for (int i = wiseSayings.size() - 1; i >= 0; i--) {			//목록을 거꾸로 출력하기 위한 반복문 세팅
			WiseSaying ws = wiseSayings.get(i);						//최신 명언집부터 ws에 저장된다.

			System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
		}
	}

	public void remove(Rq rq) {

		int id = rq.getIntParam("id", -1);		//입력값에서 rq가 가공하고 그 안에서 번호값을 빼서 id에 저장.

		if (id == -1) {							//rq가 등록된 번호가 아니면 -1을 리턴하게 했다. -1 받으면 끝내도록.
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}
		
		WiseSaying wiseSaying = wiseSayingService.findById(id);	// 입력된 id와 일치하는 명언 객체 찾기. 삭제하기 위한

		if (wiseSaying == null) {				//가져온 객체(명언집)이 없을 때 리턴으로 끝.
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}

		
		wiseSayingService.remove(wiseSaying);		// 찾은 명언 객체를 object기반으로 삭제

		System.out.printf("%d번 명언이 삭제되었습니다.\n", id);

	}

	public void modify(Rq rq) {
		int id = rq.getIntParam("id", -1);		//입력값에서 rq가 가공하고 그 안에서 번호값을 빼서 id에 저장.

		if (id == -1) {							//rq가 등록된 번호가 아니면 -1을 리턴하게 했다. -1 받으면 끝내도록.
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}
		
		WiseSaying wiseSaying = wiseSayingService.findById(id);	// 입력된 id와 일치하는 명언 객체 찾기

		if (wiseSaying == null) {				//가져온 객체(명언집)이 없을 때 리턴으로 끝.
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}

		// 찾은 명언 객체를 object기반으로 수정
		System.out.println("명언(기존) :" + wiseSaying.getContent());
		System.out.println("작가(기존) :" + wiseSaying.getAuthor());

		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		wiseSayingService.modify(wiseSaying, content, author);

		System.out.printf("%d번 명언이 수정되었습니다.\n", id);

	}

}