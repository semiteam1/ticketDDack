package com.kh.semi01.user.model.vo;

public class Book {
	
	private int bookedNo;		// 예매번호
	private int productNo;		// 상품번호 (긴급추가 => 포스터 눌렀을 때 상세페이지로 넘어가게 하기 위해서)
	private String user;		// 회원 => 조회 시 회원명 | 입력 시 회원번호
	private String product;		// 상품 => 조회 시 상품명 | 입력 시 상품번호
	private int audience;		// 관람인원수
	private String payment;		// 결제수단 => 조회 시 결제수단명 | 입력 시 결제수단 번호
	private String card;		// 카드종류 => 조회 시 카드사명 | 입력 시 카드사 번호
	private int price;			// 가격
	private String bookedDate;	// 예매날짜 => 입출력을 자유롭게 하기 위해서 String으로
	private String screenDate;	// 관람날짜 => 입출력을 자유롭게 하기 위해서 String으로
	private String screenTime;	// 관람시간 => "11:00 or 18:00"으로 입력
	private String titleImg;	// 포스터 이미지 조회용
	private String address;		// 공연 장소
	private String status;		// 삭제 여부
	
	// 기본 생성자
	public Book() {}
	
	// 전체 매개변수 생성자
	public Book(int bookedNo, int productNo, String user, String product, int audience, String payment, String card,
			int price, String bookedDate, String screenDate, String screenTime, String titleImg, String address,
			String status) {
		super();
		this.bookedNo = bookedNo;
		this.productNo = productNo;
		this.user = user;
		this.product = product;
		this.audience = audience;
		this.payment = payment;
		this.card = card;
		this.price = price;
		this.bookedDate = bookedDate;
		this.screenDate = screenDate;
		this.screenTime = screenTime;
		this.titleImg = titleImg;
		this.address = address;
		this.status = status;
	}

	// 상품번호를 제외한 매개변수 생성자
	public Book(int bookedNo, String user, String product, int audience, String payment, String card, int price,
			String bookedDate, String screenDate, String screenTime, String titleImg, String address, String status) {
		super();
		this.bookedNo = bookedNo;
		this.user = user;
		this.product = product;
		this.audience = audience;
		this.payment = payment;
		this.card = card;
		this.price = price;
		this.bookedDate = bookedDate;
		this.screenDate = screenDate;
		this.screenTime = screenTime;
		this.titleImg = titleImg;
		this.address = address;
		this.status = status;
	}

	// 예매내역 조회용 생성자
	public Book(int bookedNo, int productNo, String product, String screenDate, String titleImg, String address) {
		super();
		this.bookedNo = bookedNo;
		this.productNo = productNo;
		this.product = product;
		this.screenDate = screenDate;
		this.titleImg = titleImg;
		this.address = address;
	}

	// 예매내역 상세 조회용 생성자
	public Book(int bookedNo, String product, int audience, String payment, int price, String screenDate,
			String address) {
		super();
		this.bookedNo = bookedNo;
		this.product = product;
		this.audience = audience;
		this.payment = payment;
		this.price = price;
		this.screenDate = screenDate;
		this.address = address;
	}
	
	// 예매내역 등록용 생성자
	public Book(String user, String product, int audience, String payment, String card, String screenDate, String screenTime) {
		super();
		this.user = user;
		this.product = product;
		this.audience = audience;
		this.payment = payment;
		this.card = card;
		this.screenDate = screenDate;
		this.screenTime = screenTime;
	}

	// getter-setter 메소드
	public int getBookedNo() {
		return bookedNo;
	}

	public void setBookedNo(int bookedNo) {
		this.bookedNo = bookedNo;
	}
	
	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getAudience() {
		return audience;
	}

	public void setAudience(int audience) {
		this.audience = audience;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
	}

	public String getScreenDate() {
		return screenDate;
	}

	public void setScreenDate(String screenDate) {
		this.screenDate = screenDate;
	}
	
	public String getScreenTime() {
		return screenTime;
	}
	
	public void setScreenTime(String screenTime) {
		this.screenTime = screenTime;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// toString() 메소드
	@Override
	public String toString() {
		return "Book [bookedNo=" + bookedNo + ", productNo=" + productNo + ", user=" + user + ", product=" + product
				+ ", audience=" + audience + ", payment=" + payment + ", card=" + card + ", price=" + price
				+ ", bookedDate=" + bookedDate + ", screenDate=" + screenDate + ", screenTime=" + screenTime
				+ ", titleImg=" + titleImg + ", address=" + address + ", status=" + status + "]";
	}

}
