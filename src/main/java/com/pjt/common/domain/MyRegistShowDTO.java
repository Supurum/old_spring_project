package com.pjt.common.domain;

import java.security.Timestamp;

public class MyRegistShowDTO {

	private String meet_name;
	private String meet_writer;
	private Timestamp meet_regist_date;
	private String main_category_name;
	private String meet_partner;
	private String category_name;
	private String state_name;
	private String loc_name;
	private String user_photo;

	public String getMeet_name() {
		return meet_name;
	}

	public void setMeet_name(String meet_name) {
		this.meet_name = meet_name;
	}

	public String getMeet_writer() {
		return meet_writer;
	}

	public void setMeet_writer(String meet_writer) {
		this.meet_writer = meet_writer;
	}

	public Timestamp getMeet_regist_date() {
		return meet_regist_date;
	}

	public void setMeet_regist_date(Timestamp meet_regist_date) {
		this.meet_regist_date = meet_regist_date;
	}

	public String getMain_category_name() {
		return main_category_name;
	}

	public void setMain_category_name(String main_category_name) {
		this.main_category_name = main_category_name;
	}

	public String getMeet_partner() {
		return meet_partner;
	}

	public void setMeet_partner(String meet_partner) {
		this.meet_partner = meet_partner;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getLoc_name() {
		return loc_name;
	}

	public void setLoc_name(String loc_name) {
		this.loc_name = loc_name;
	}

	public String getUser_photo() {
		return user_photo;
	}

	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}

	@Override
	public String toString() {
		return "MyRegistShowDTO [meet_name=" + meet_name + ", meet_writer=" + meet_writer + ", meet_regist_date="
				+ meet_regist_date + ", main_category_name=" + main_category_name + ", meet_partner=" + meet_partner
				+ ", category_name=" + category_name + ", state_name=" + state_name + ", loc_name=" + loc_name
				+ ", user_photo=" + user_photo + "]";
	}

	public MyRegistShowDTO(String meet_name, String meet_writer, Timestamp meet_regist_date, String main_category_name,
			String meet_partner, String category_name, String state_name, String loc_name, String user_photo) {
		super();
		this.meet_name = meet_name;
		this.meet_writer = meet_writer;
		this.meet_regist_date = meet_regist_date;
		this.main_category_name = main_category_name;
		this.meet_partner = meet_partner;
		this.category_name = category_name;
		this.state_name = state_name;
		this.loc_name = loc_name;
		this.user_photo = user_photo;
	}

	public MyRegistShowDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
