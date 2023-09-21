package com.kh.semi01.qna.model.vo;

public class Qna {
	
	// 전역변수
	private int qnaNo; 			// Q&A 번호
	private String user; 		// 작성자 => 조회시 회원명 | 입력시 회원번호
	private String qnaTitle; 	// Q&A 제목
	private String qnaContent; 	// Q&A 내용
	private String qnaReply; 	// Q&A 답변내용
	private String qnaDate; 	// Q&A 작성날짜 => 입출력을 자유롭게 하기 위해서 String으로
	
	// 기본 생성자
	public Qna() {}

	// 전체 매개변수 생성자
	public Qna(int qnaNo, String user, String qnaTitle, String qnaContent, String qnaReply, String qnaDate) {
		super();
		this.qnaNo = qnaNo;
		this.user = user;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaReply = qnaReply;
		this.qnaDate = qnaDate;
	}

	public Qna(int qnaNo, String qnaTitle, String qnaContent,String user , String qnaDate) {
		super();
		this.qnaNo = qnaNo;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.user = user;
		this.qnaDate = qnaDate;
	}

	// getter-setter 메소드
	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public String getQnaReply() {
		return qnaReply;
	}

	public void setQnaReply(String qnaReply) {
		this.qnaReply = qnaReply;
	}

	public String getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}

	// toString() 메소드
	@Override
	public String toString() {
		return "Qna [qnaNo=" + qnaNo + ", user=" + user + ", qnaTitle=" + qnaTitle + ", qnaContent=" + qnaContent
				+ ", qnaReply=" + qnaReply + ", qnaDate=" + qnaDate + "]";
	}

}
