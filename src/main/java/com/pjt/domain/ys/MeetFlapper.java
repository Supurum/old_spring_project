package com.pjt.domain.ys;

public class MeetFlapper {
	private int meet_num;
	private String writer_photo;
	private String partner_photo;
	public MeetFlapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MeetFlapper(int meet_num, String writer_photo, String partner_photo) {
		super();
		this.meet_num = meet_num;
		this.writer_photo = writer_photo;
		this.partner_photo = partner_photo;
	}
	public int getMeet_num() {
		return meet_num;
	}
	public void setMeet_num(int meet_num) {
		this.meet_num = meet_num;
	}
	public String getWriter_photo() {
		return writer_photo;
	}
	public void setWriter_photo(String writer_photo) {
		this.writer_photo = writer_photo;
	}
	public String getPartner_photo() {
		return partner_photo;
	}
	public void setPartner_photo(String partner_photo) {
		this.partner_photo = partner_photo;
	}
	@Override
	public String toString() {
		return "MeetFlapper [meet_num=" + meet_num + ", writer_photo=" + writer_photo + ", partner_photo="
				+ partner_photo + "]";
	}
}
