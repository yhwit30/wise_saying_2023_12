package com.ws.wiseSaying.service;

import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {

	private WiseSayingRepository wiseSayingRepository;

	public WiseSayingService() {		//컨트롤러의 요청을 받아서 필요한 걸 리포지터리에 실행요청하고 가져옴

		wiseSayingRepository = new WiseSayingRepository();		//리포지터리에 접근하기 위해 생성
	}

	public WiseSaying findById(int id) {
		return wiseSayingRepository.findBㄱyId(id);
	}

	public List<WiseSaying> findAll() {
		return wiseSayingRepository.finAll();
	}

	public int write(String content, String author) {
		return wiseSayingRepository.write(content, author);
	}

	public void remove(WiseSaying wiseSaying) {
		wiseSayingRepository.remove(wiseSaying);
	}

	public void modify(WiseSaying wiseSaying, String content, String author) {
		wiseSayingRepository.modfy(wiseSaying, content, author);

	}

}