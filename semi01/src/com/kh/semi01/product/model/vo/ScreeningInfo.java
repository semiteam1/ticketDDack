package com.kh.semi01.product.model.vo;

public class ScreeningInfo {
	
	private int productNo;
	private String screeningDate;
	private String screeningDayTime;
	private String screeningNightTime;
	private int screeningDaySeat;
	private int screeningNightSeat;

	public ScreeningInfo() {}

	public ScreeningInfo(int productNo, String screeningDate, String screeningDayTime, String screeningNightTime,
			int screeningDaySeat, int screeningNightSeat) {
		super();
		this.productNo = productNo;
		this.screeningDate = screeningDate;
		this.screeningDayTime = screeningDayTime;
		this.screeningNightTime = screeningNightTime;
		this.screeningDaySeat = screeningDaySeat;
		this.screeningNightSeat = screeningNightSeat;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getScreeningDate() {
		return screeningDate;
	}

	public void setScreeningDate(String screeningDate) {
		this.screeningDate = screeningDate;
	}

	public String getScreeningDayTime() {
		return screeningDayTime;
	}

	public void setScreeningDayTime(String screeningDayTime) {
		this.screeningDayTime = screeningDayTime;
	}

	public String getScreeningNightTime() {
		return screeningNightTime;
	}

	public void setScreeningNightTime(String screeningNightTime) {
		this.screeningNightTime = screeningNightTime;
	}

	public int getScreeningDaySeat() {
		return screeningDaySeat;
	}

	public void setScreeningDaySeat(int screeningDaySeat) {
		this.screeningDaySeat = screeningDaySeat;
	}

	public int getScreeningNightSeat() {
		return screeningNightSeat;
	}

	public void setScreeningNightSeat(int screeningNightSeat) {
		this.screeningNightSeat = screeningNightSeat;
	}

	@Override
	public String toString() {
		return "ScreeningInfo [productNo=" + productNo + ", screeningDate=" + screeningDate + ", screeningDayTime="
				+ screeningDayTime + ", screeningNightTime=" + screeningNightTime + ", screeningDaySeat=" + screeningDaySeat
				+ ", screeningNightSeat=" + screeningNightSeat + "]";
	}
	
}
