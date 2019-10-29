package com.pjt.domain.ys;

public class Statistical {
	private String todate;
	private int todayloginmember;
	private int todaylogin;
	private int todaymeet;
	public Statistical() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Statistical(String todate, int todayloginmember, int todaylogin, int todaymeet) {
		super();
		this.todate = todate;
		this.todayloginmember = todayloginmember;
		this.todaylogin = todaylogin;
		this.todaymeet = todaymeet;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public int getTodayloginmember() {
		return todayloginmember;
	}
	public void setTodayloginmember(int todayloginmember) {
		this.todayloginmember = todayloginmember;
	}
	public int getTodaylogin() {
		return todaylogin;
	}
	public void setTodaylogin(int todaylogin) {
		this.todaylogin = todaylogin;
	}
	public int getTodaymeet() {
		return todaymeet;
	}
	public void setTodaymeet(int todaymeet) {
		this.todaymeet = todaymeet;
	}
	@Override
	public String toString() {
		return "Statistical [todate=" + todate + ", todayloginmember=" + todayloginmember + ", todaylogin=" + todaylogin
				+ ", todaymeet=" + todaymeet + "]";
	}
}
