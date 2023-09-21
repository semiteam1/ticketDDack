package com.kh.semi01.user.model.vo;

public class Grade {
	
	private int gradeNo;			// 등급번호
	private String gradeName;		// 등급명
	private double gradeDiscount;	// 등급별 할인율
	
	public Grade() {}

	public Grade(int gradeNo, String gradeName, double gradeDiscount) {
		super();
		this.gradeNo = gradeNo;
		this.gradeName = gradeName;
		this.gradeDiscount = gradeDiscount;
	}

	public int getGradeNo() {
		return gradeNo;
	}

	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public double getGradeDiscount() {
		return gradeDiscount;
	}

	public void setGradeDiscount(double gradeDiscount) {
		this.gradeDiscount = gradeDiscount;
	}

	@Override
	public String toString() {
		return "Grade [gradeNo=" + gradeNo + ", gradeName=" + gradeName + ", gradeDiscount=" + gradeDiscount + "]";
	}
	
}
