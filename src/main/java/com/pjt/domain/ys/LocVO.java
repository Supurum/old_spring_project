package com.pjt.domain.ys;

public class LocVO {
	private int loc_num;
	private String loc_name;
	public LocVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocVO(int loc_num, String loc_name) {
		super();
		this.loc_num = loc_num;
		this.loc_name = loc_name;
	}
	public int getLoc_num() {
		return loc_num;
	}
	public void setLoc_num(int loc_num) {
		this.loc_num = loc_num;
	}
	public String getLoc_name() {
		return loc_name;
	}
	public void setLoc_name(String loc_name) {
		this.loc_name = loc_name;
	}
	@Override
	public String toString() {
		return "LocVO [loc_num=" + loc_num + ", loc_name=" + loc_name + "]";
	}
}
