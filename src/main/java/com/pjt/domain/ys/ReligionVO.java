package com.pjt.domain.ys;

public class ReligionVO {
	private int religion_num;
	private String religion_name; 
	
	public ReligionVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReligionVO(int religion_num, String religion_name) {
		super();
		this.religion_num = religion_num;
		this.religion_name = religion_name;
	}

	public int getReligion_num() {
		return religion_num;
	}

	public void setReligion_num(int religion_num) {
		this.religion_num = religion_num;
	}

	public String getReligion_name() {
		return religion_name;
	}

	public void setReligion_name(String religion_name) {
		this.religion_name = religion_name;
	}

	@Override
	public String toString() {
		return "ReligionVO [religion_num=" + religion_num + ", religion_name=" + religion_name + "]";
	}
}
