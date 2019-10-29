package com.pjt.domain.th;

public class MeetDTO {
	private String user_id;
	private String user_photo;
	private int user_age;
	private String loc_name;
	private String category_name;
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
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getLoc_name() {
		return loc_name;
	}
	public void setLoc_name(String loc_name) {
		this.loc_name = loc_name;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	@Override
	public String toString() {
		return "MeetDTO [user_id=" + user_id + ", user_photo=" + user_photo + ", user_age=" + user_age
				+ ", loc_name=" + loc_name + ", category_name=" + category_name + "]";
	}
	
	
}
