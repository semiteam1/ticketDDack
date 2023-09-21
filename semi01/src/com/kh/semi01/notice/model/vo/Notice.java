package com.kh.semi01.notice.model.vo;

public class Notice {
	
	private int noticeNo; 			// 공지사항 번호
	private String noticeTitle; 	// 공지사항 제목
	private String noticeContent;	// 공지사항 내용
	private String noticeDate; 		// 공지사항 작성일 => 입출력을 자유롭게 하기 위해서 String으로
	private int noticeCount; 		// 공지사항 조회수
	
	// 기본 생성자
	public Notice() {}

	// 전체 매개변수 생성자
	public Notice(int noticeNo, String noticeTitle, String noticeContent, String noticeDate, int noticeCount) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeCount = noticeCount;
	}
	
	
	
	public Notice(int noticeNo, String noticeTitle, String noticeContent, String noticeDate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
	}

	// getter-setter 메소드
	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public int getNoticeCount() {
		return noticeCount;
	}

	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}

	// toString() 메소드
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeDate=" + noticeDate + ", noticeCount=" + noticeCount + "]";
	}

}
