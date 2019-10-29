package com.pjt.domain.ys;

public class UserVO {
	private String user_id; 
	private String user_pw; 
	private String user_name; 
	private int user_gender; 
	private int user_age; 
	private int user_addr; 
	private String user_tel; 
	private String user_photo; 
	private int user_religion;
	private String prev_user_pw;
	private String user_nickname;
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserVO(String user_id, String user_pw, String user_name, int user_gender, int user_age, int user_addr,
			String user_tel, String user_photo, int user_religion, String prev_user_pw, String user_nickname) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_gender = user_gender;
		this.user_age = user_age;
		this.user_addr = user_addr;
		this.user_tel = user_tel;
		this.user_photo = user_photo;
		this.user_religion = user_religion;
		this.prev_user_pw = prev_user_pw;
		this.user_nickname = user_nickname;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
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
	public int getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(int user_addr) {
		this.user_addr = user_addr;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getUser_photo() {
		return user_photo;
	}
	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}
	public int getUser_religion() {
		return user_religion;
	}
	public void setUser_religion(int user_religion) {
		this.user_religion = user_religion;
	}
	public String getPrev_user_pw() {
		return prev_user_pw;
	}
	public void setPrev_user_pw(String prev_user_pw) {
		this.prev_user_pw = prev_user_pw;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", user_gender="
				+ user_gender + ", user_age=" + user_age + ", user_addr=" + user_addr + ", user_tel=" + user_tel
				+ ", user_photo=" + user_photo + ", user_religion=" + user_religion + ", prev_user_pw=" + prev_user_pw
				+ ", user_nickname=" + user_nickname + "]";
	}
}
