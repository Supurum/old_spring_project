package com.pjt.domain.ys;

import java.sql.Timestamp;

public class MeetVO {
	private int meet_num; 
	private String meet_category; 
	private String meet_name; 
	private int meet_sub_category; 
	private int meet_addr; 
	private String meet_writer; 
	private int meet_target_gender; 
	private Timestamp meet_regist_date; 
	private String meet_partner; 
	private String meet_state;
	
	public MeetVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MeetVO(int meet_num, String meet_category, String meet_name, int meet_sub_category, int meet_addr,
			String meet_writer, int meet_target_gender, Timestamp meet_regist_date, String meet_partner,
			String meet_state) {
		super();
		this.meet_num = meet_num;
		this.meet_category = meet_category;
		this.meet_name = meet_name;
		this.meet_sub_category = meet_sub_category;
		this.meet_addr = meet_addr;
		this.meet_writer = meet_writer;
		this.meet_target_gender = meet_target_gender;
		this.meet_regist_date = meet_regist_date;
		this.meet_partner = meet_partner;
		this.meet_state = meet_state;
	}
	public int getMeet_num() {
		return meet_num;
	}
	public void setMeet_num(int meet_num) {
		this.meet_num = meet_num;
	}
	public String getMeet_category() {
		return meet_category;
	}
	public void setMeet_category(String meet_category) {
		this.meet_category = meet_category;
	}
	public String getMeet_name() {
		return meet_name;
	}
	public void setMeet_name(String meet_name) {
		this.meet_name = meet_name;
	}
	public int getMeet_sub_category() {
		return meet_sub_category;
	}
	public void setMeet_sub_category(int meet_sub_category) {
		this.meet_sub_category = meet_sub_category;
	}
	public int getMeet_addr() {
		return meet_addr;
	}
	public void setMeet_addr(int meet_addr) {
		this.meet_addr = meet_addr;
	}
	public String getMeet_writer() {
		return meet_writer;
	}
	public void setMeet_writer(String meet_writer) {
		this.meet_writer = meet_writer;
	}
	public int getMeet_target_gender() {
		return meet_target_gender;
	}
	public void setMeet_target_gender(int meet_target_gender) {
		this.meet_target_gender = meet_target_gender;
	}
	public Timestamp getMeet_regist_date() {
		return meet_regist_date;
	}
	public void setMeet_regist_date(Timestamp meet_regist_date) {
		this.meet_regist_date = meet_regist_date;
	}
	public String getMeet_partner() {
		return meet_partner;
	}
	public void setMeet_partner(String meet_partner) {
		this.meet_partner = meet_partner;
	}
	public String getMeet_state() {
		return meet_state;
	}
	public void setMeet_state(String meet_state) {
		this.meet_state = meet_state;
	}
	@Override
	public String toString() {
		return "MeetInfoDTO [meet_num=" + meet_num + ", meet_category=" + meet_category + ", meet_name=" + meet_name
				+ ", meet_sub_category=" + meet_sub_category + ", meet_addr=" + meet_addr + ", meet_writer="
				+ meet_writer + ", meet_target_gender=" + meet_target_gender + ", meet_regist_date=" + meet_regist_date
				+ ", meet_partner=" + meet_partner + ", meet_state=" + meet_state + "]";
	}
}
