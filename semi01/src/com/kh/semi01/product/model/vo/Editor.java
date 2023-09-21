package com.kh.semi01.product.model.vo;

public class Editor {
	private int productNo;
	private String editor;
	private String deitComment;
	
	public Editor() {}

	public Editor(int productNo, String editor, String deitComment) {
		super();
		this.productNo = productNo;
		this.editor = editor;
		this.deitComment = deitComment;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getDeitComment() {
		return deitComment;
	}

	public void setDeitComment(String deitComment) {
		this.deitComment = deitComment;
	}

	@Override
	public String toString() {
		return "Editor [productNo=" + productNo + ", editor=" + editor + ", deitComment=" + deitComment + "]";
	}
	
	
}
