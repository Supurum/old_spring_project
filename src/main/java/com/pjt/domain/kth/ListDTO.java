package com.pjt.domain.kth;

import java.sql.Timestamp;

public class ListDTO {
	private int meet_num;
	private String meet_name;
	private int meet_peoplenum;
	private String meet_writer;
	private Timestamp meet_regist_date;
	private String meet_state;
	private String state_name;
	private String loc_name;
	private String user_photo;
	private int meet_maxpeoplenum;

	public ListDTO() {
		super();
	}

	public ListDTO(int meet_num, String meet_name, int meet_peoplenum, String meet_writer, Timestamp meet_regist_date,
			String meet_state, String state_name, String loc_name, String user_photo, int meet_maxpeoplenum) {
		super();
		this.meet_num = meet_num;
		this.meet_name = meet_name;
		this.meet_peoplenum = meet_peoplenum;
		this.meet_writer = meet_writer;
		this.meet_regist_date = meet_regist_date;
		this.meet_state = meet_state;
		this.state_name = state_name;
		this.loc_name = loc_name;
		this.user_photo = user_photo;
		this.meet_maxpeoplenum = meet_maxpeoplenum;
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

	public int getMeet_peoplenum() {
		return meet_peoplenum;
	}

	public void setMeet_peoplenum(int meet_peoplenum) {
		this.meet_peoplenum = meet_peoplenum;
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

	public String getMeet_state() {
		return meet_state;
	}

	public void setMeet_state(String meet_state) {
		this.meet_state = meet_state;
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

	public int getMeet_maxpeoplenum() {
		return meet_maxpeoplenum;
	}

	public void setMeet_maxpeoplenum(int meet_maxpeoplenum) {
		this.meet_maxpeoplenum = meet_maxpeoplenum;
	}

	@Override
	public String toString() {
		return "ListDTO [meet_num=" + meet_num + ", meet_name=" + meet_name + ", meet_peoplenum=" + meet_peoplenum
				+ ", meet_writer=" + meet_writer + ", meet_regist_date=" + meet_regist_date + ", meet_state="
				+ meet_state + ", state_name=" + state_name + ", loc_name=" + loc_name + ", user_photo=" + user_photo
				+ ", meet_maxpeoplenum=" + meet_maxpeoplenum + "]";
	}

}
