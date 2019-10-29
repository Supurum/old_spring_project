package com.pjt.domain.ys;

public class LongMeet {
	private int meet_num; 
	private String meet_name; 
	private String writer;
	private String partner; 
	private String d_diff;
	public LongMeet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LongMeet(int meet_num, String meet_name, String writer, String partner, String d_diff) {
		super();
		this.meet_num = meet_num;
		this.meet_name = meet_name;
		this.writer = writer;
		this.partner = partner;
		this.d_diff = d_diff;
	}
	public int getMeet_num() {
		return meet_num;
	}
	public void setMeet_num(int meet_num) {
		this.meet_num = meet_num;
	}
	public String getMeet_name() {
		return meet_name;
	}
	public void setMeet_name(String meet_name) {
		this.meet_name = meet_name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getD_diff() {
		return d_diff;
	}
	public void setD_diff(String d_diff) {
		this.d_diff = d_diff;
	}
	@Override
	public String toString() {
		return "LongMeet [meet_num=" + meet_num + ", meet_name=" + meet_name + ", writer=" + writer + ", partner="
				+ partner + ", d_diff=" + d_diff + "]";
	}
}
