package com.kh.semi01.common.model.vo;

import com.kh.semi01.user.model.service.UserService;

// 페이징 바 처리 클래스
public class PageInfo {
	
	private int boardCount;		// 게시물 총 개수
	private int currentPage; 	// 현재 페이지
	private int pageLimit;	 	// 페이징바에 노출되는 버튼의 최대 개수
	private int boardLimit;		// 한 페이지에 노출되는 게시물의 최대 개수
	private int maxPage;		// 마지막 페이지 (총 페이지 수)
	private int startPage;		// 페이징 바의 시작 수
	private int endPage;		// 페이징 바의 끝 수
	
	// 기본 생성자
	public PageInfo() {}

	// 전체 매개변수 생성자
	public PageInfo(int boardCount, int currentPage, int pageLimit, int boardLimit, int maxPage, int startPage,
			int endPage) {
		super();
		this.boardCount = boardCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	// getter-setter 메소드
	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	// toString() 메소드
	@Override
	public String toString() {
		return "PageInfo [boardCount=" + boardCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", boardLimit=" + boardLimit + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
	
}
