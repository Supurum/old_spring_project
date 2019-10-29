package com.pjt.common.domain;

public class PartnerInfoDTO {
	private int meet_num;
	private String user_name;
	private String user_id;
	private String user_photo;
	private String gender_name;
	private String religion_name;
	private String loc_name;
	private String meet_place;
	private int user_age;
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_photo() {
		return user_photo;
	}
	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}
	public String getGender_name() {
		return gender_name;
	}
	public void setGender_name(String gender_name) {
		this.gender_name = gender_name;
	}
	public String getReligion_name() {
		return religion_name;
	}
	public void setReligion_name(String religion_name) {
		this.religion_name = religion_name;
	}
	public String getLoc_name() {
		return loc_name;
	}
	public void setLoc_name(String loc_name) {
		this.loc_name = loc_name;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	
	public int getMeet_num() {
		return meet_num;
	}
	public void setMeet_num(int meet_num) {
		this.meet_num = meet_num;
	}
	public String getMeet_place() {
		return meet_place;
	}
	public void setMeet_place(String meet_place) {
		this.meet_place = meet_place;
	}
	@Override
	public String toString() {
		return "PartnerInfoDTO [meet_num=" + meet_num + ", user_name=" + user_name + ", user_id=" + user_id
				+ ", user_photo=" + user_photo + ", gender_name=" + gender_name + ", religion_name=" + religion_name
				+ ", loc_name=" + loc_name + ", meet_place=" + meet_place + ", user_age=" + user_age + "]";
	}
	
}
