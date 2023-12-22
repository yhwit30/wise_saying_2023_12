package com.ws.wiseSaying.repository;

import java.util.ArrayList;
import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;

public class WiseSayingRepository {
	private int lastWiseSayingId;			//명언집에 번호를 부여할 용도로 선언
	private List<WiseSaying> wiseSayings;	//명언집을 만드는 용도로 선언

	public WiseSayingRepository() {
		lastWiseSayingId = 0;				//첫 명언집 번호를 0으로 세팅(아래에서 +1해서 1번으로 명언집은 시작)
		wiseSayings = new ArrayList<>();	//arraylist를 생성

	}
	
	public WiseSaying findById(int id) {
		for (WiseSaying wiseSaying : wiseSayings) {		//데이터베이스격인 arraylist 명언집의 요소를 순회하면서 wiseSaying에 넣어주는데 리모컨을 복제해주는 것.
			if (wiseSaying.getId() == id) {
				return wiseSaying;
			}
		}

		return null;
	}

	public List<WiseSaying> finAll() {		//arraylist로 만든 배열 리모컨을 리턴
		return wiseSayings;
	}

	public int write(String content, String author) {
		int id = lastWiseSayingId + 1;			//시작하는 번호는 1로 만들어준다.

		WiseSaying wiseSaying = new WiseSaying(id, content, author);	//명언집 객체를 다룰 리모컨을 만든다. 
		wiseSayings.add(wiseSaying);									//배열에 객체 생성하고 값을 넣어준다. 생성 시 번호 부여. 즉, id값이 1씩 증가.

		lastWiseSayingId = id;					// 방금 전에 새 명언이 생겼으니, lastWiseSayingId의 값을 갱신

		return id;		//서비스에 전달

	}

	public void remove(WiseSaying wiseSaying) {
		wiseSayings.remove(wiseSaying);			//받은 명언집 객체를 제거만 한다. 리턴을 줄 필요가 없다. 어떤 명언집을 삭제할 지는 컨트롤러에서 정했다.

	}

	public void modfy(WiseSaying wiseSaying, String content, String author) {
		wiseSaying.setContent(content);			//명언 클래스에 있는 메소드실행해서 새로운 값을 줌
		wiseSaying.setAuthor(author);			//명언 클래스에 있는 메소드실행해서 새로운 값을 줌

	}

}
