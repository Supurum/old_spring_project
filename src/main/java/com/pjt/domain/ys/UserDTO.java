package com.pjt.domain.ys;

public class UserDTO {
	private String user_id;
	private String user_name; 
	private int user_gender; 
	private int user_age; 
	private String user_photo;
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(String user_id, String user_name, int user_gender, int user_age, String user_photo) {
		super();
		this.user_name = user_name;
		this.user_id = user_id;
		this.user_gender = user_gender;
		this.user_age = user_age;
		this.user_photo = user_photo;
	}
	
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
	public int getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(int user_gender) {
		this.user_gender = user_gender;
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

	@Override
	public String toString() {
		return "UserInfoVO [user_id=" + user_id + ", user_name=" + user_name+", user_gender=" + user_gender + ", user_age=" + user_age
				+ ", user_photo=" + user_photo + "]";
	}
}
