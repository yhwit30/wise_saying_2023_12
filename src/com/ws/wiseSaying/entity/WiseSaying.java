package com.ws.wiseSaying.entity;

public class WiseSaying {				// 받은 입력값을 조립. 
	private int id;
	private String content;
	private String author;

	public WiseSaying(int id, String content, String author) {		//private 변수에 가지고 온 값을 넣어준다.
		this.id = id;
		this.content = content;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}