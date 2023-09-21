package com.kh.semi01.product.model.vo;

public class ProductLike {
	
	private int product_no;
	private int user_no;
	private String productTitle;
	private String titleImg;
	
	public ProductLike() {}
	
	public ProductLike(int product_no, int user_no, String productTitle, String titleImg) {
		super();
		this.product_no = product_no;
		this.user_no = user_no;
		this.productTitle = productTitle;
		this.titleImg = titleImg;
	}
	
	public ProductLike(int product_no, String productTitle, String titleImg) {
		super();
		this.product_no = product_no;
		this.productTitle = productTitle;
		this.titleImg = titleImg;
	}

	public ProductLike(int product_no, int user_no) {
		super();
		this.product_no = product_no;
		this.user_no = user_no;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	
	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}
	
	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	@Override
	public String toString() {
		return "ProductLike [product_no=" + product_no + ", user_no=" + user_no + ", productTitle=" + productTitle
				+ ", titleImg=" + titleImg + "]";
	}

}
