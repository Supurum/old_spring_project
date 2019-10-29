package com.pjt.domain.ys;

public class GenderVO {
	private int gender_num; 
	private String gender_name;
	public GenderVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GenderVO(int gender_num, String gender_name) {
		super();
		this.gender_num = gender_num;
		this.gender_name = gender_name;
	}
	public int getGender_num() {
		return gender_num;
	}
	public void setGender_num(int gender_num) {
		this.gender_num = gender_num;
	}
	public String getGender_name() {
		return gender_name;
	}
	public void setGender_name(String gender_name) {
		this.gender_name = gender_name;
	}
	@Override
	public String toString() {
		return "GenderVO [gender_num=" + gender_num + ", gender_name=" + gender_name + "]";
	}
}
