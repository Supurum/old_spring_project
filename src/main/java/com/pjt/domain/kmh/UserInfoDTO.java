package com.pjt.domain.kmh;

public class UserInfoDTO {

	private String user_id;
	private String user_name;
	private int user_age;
	private String user_photo;
	private String gender_name;
	private String religion_name;
	private String loc_name;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	@Override
	public String toString() {
		return "UserInfoDTO [user_id=" + user_id + ", user_name=" + user_name + ", user_age=" + user_age
				+ ", user_photo=" + user_photo + ", gender_name=" + gender_name + ", religion_name=" + religion_name
				+ ", loc_name=" + loc_name + "]";
	}

	public UserInfoDTO(String user_id, String user_name, int user_age, String user_photo, String gender_name,
			String religion_name, String loc_name) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_age = user_age;
		this.user_photo = user_photo;
		this.gender_name = gender_name;
		this.religion_name = religion_name;
		this.loc_name = loc_name;
	}

	public UserInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
