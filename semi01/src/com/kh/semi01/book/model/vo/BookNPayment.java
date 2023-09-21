package com.kh.semi01.book.model.vo;

public class BookNPayment {
	
	private String bookedDate;	// 관람날짜
	private String screenTime;	// 관람시간
	private int spareSeat;		// 잔여좌석
	
	public BookNPayment() {}

	public BookNPayment(String bookedDate, String screenTime, int spareSeat) {
		super();
		this.bookedDate = bookedDate;
		this.screenTime = screenTime;
		this.spareSeat = spareSeat;
	}

	public String getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
	}

	public String getScreenTime() {
		return screenTime;
	}

	public void setScreenTime(String screenTime) {
		this.screenTime = screenTime;
	}

	public int getSpareSeat() {
		return spareSeat;
	}

	public void setSpareSeat(int spareSeat) {
		this.spareSeat = spareSeat;
	}

	@Override
	public String toString() {
		return "BookNPayment [bookedDate=" + bookedDate + ", screenTime=" + screenTime + ", spareSeat=" + spareSeat
				+ "]";
	}
	
}
