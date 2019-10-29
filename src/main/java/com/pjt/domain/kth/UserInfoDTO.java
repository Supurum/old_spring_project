package com.pjt.domain.kth;

public class UserInfoDTO {
	private int meet_num;
	private String meet_writer;
	private String meet_partner;
	private String user_name;
	private int user_age;
	private String user_photo;
	private String gender_name;

	public UserInfoDTO() {
		super();
	}

	public UserInfoDTO(int meet_num, String meet_writer, String meet_partner, String user_name, int user_age,
			String user_photo, String gender_name) {
		super();
		this.meet_num = meet_num;
		this.meet_writer = meet_writer;
		this.meet_partner = meet_partner;
		this.user_name = user_name;
		this.user_age = user_age;
		this.user_photo = user_photo;
		this.gender_name = gender_name;
	}

	public int getMeet_num() {
		return meet_num;
	}

	public void setMeet_num(int meet_num) {
		this.meet_num = meet_num;
	}

	public String getMeet_writer() {
		return meet_writer;
	}

	public void setMeet_writer(String meet_writer) {
		this.meet_writer = meet_writer;
	}

	public String getMeet_partner() {
		return meet_partner;
	}

	public void setMeet_partner(String meet_partner) {
		this.meet_partner = meet_partner;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getUser_age() {
		return user_age;
	}

	public void setUser_age(int user_age) {
		this.user_age = user_age;
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

	@Override
	public String toString() {
		return "UserInfoDTO [meet_num=" + meet_num + ", meet_writer=" + meet_writer + ", meet_partner=" + meet_partner
				+ ", user_name=" + user_name + ", user_age=" + user_age + ", user_photo=" + user_photo
				+ ", gender_name=" + gender_name + "]";
	}

}
