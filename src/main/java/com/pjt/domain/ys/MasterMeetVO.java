package com.pjt.domain.ys;

import java.sql.Timestamp;

public class MasterMeetVO {
	private int meet_num; 
	private String main_category_name; 
	private String category_name; 
	private String meet_name; 
	private String loc_name; 
	private String user_nickname; 
	private Timestamp meet_regist_date; 
		
	public MasterMeetVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MasterMeetVO(int meet_num, String main_category_name, String category_name, String meet_name,
			String loc_name, String user_nickname, Timestamp meet_regist_date) {
		super();
		this.meet_num = meet_num;
		this.main_category_name = main_category_name;
		this.category_name = category_name;
		this.meet_name = meet_name;
		this.loc_name = loc_name;
		this.user_nickname = user_nickname;
		this.meet_regist_date = meet_regist_date;
	}

	public int getMeet_num() {
		return meet_num;
	}

	public void setMeet_num(int meet_num) {
		this.meet_num = meet_num;
	}

	public String getMain_category_name() {
		return main_category_name;
	}

	public void setMain_category_name(String main_category_name) {
		this.main_category_name = main_category_name;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getMeet_name() {
		return meet_name;
	}

	public void setMeet_name(String meet_name) {
		this.meet_name = meet_name;
	}

	public String getLoc_name() {
		return loc_name;
	}

	public void setLoc_name(String loc_name) {
		this.loc_name = loc_name;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public Timestamp getMeet_regist_date() {
		return meet_regist_date;
	}

	public void setMeet_regist_date(Timestamp meet_regist_date) {
		this.meet_regist_date = meet_regist_date;
	}

	@Override
	public String toString() {
		return "MasterMeetVO [meet_num=" + meet_num + ", main_category_name=" + main_category_name + ", category_name="
				+ category_name + ", meet_name=" + meet_name + ", loc_name=" + loc_name + ", user_nickname="
				+ user_nickname + ", meet_regist_date=" + meet_regist_date + "]";
	}
}
