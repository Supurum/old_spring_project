package com.pjt.common.domain;

import java.sql.Timestamp;

public class JoinDTO {
	private int join_idx;
	private int meet_num;
	private String meet_name;
	private String user_id;
	private String user_name;
	private Timestamp regist_date;
	private String accept_yn;
	private String user_photo;
	
	public JoinDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JoinDTO(int join_idx, int meet_num, String meet_name, String user_id, String user_name,
			Timestamp regist_date, String accept_yn, String user_photo, String meet_partner) {
		super();
		this.join_idx = join_idx;
		this.meet_num = meet_num;
		this.meet_name = meet_name;
		this.user_id = user_id;
		this.user_name = user_name;
		this.regist_date = regist_date;
		this.accept_yn = accept_yn;
		this.user_photo = user_photo;
	}

	public int getJoin_idx() {
		return join_idx;
	}

	public void setJoin_idx(int join_idx) {
		this.join_idx = join_idx;
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

	public Timestamp getRegist_date() {
		return regist_date;
	}

	public void setRegist_date(Timestamp regist_date) {
		this.regist_date = regist_date;
	}

	public String getAccept_yn() {
		return accept_yn;
	}

	public void setAccept_yn(String accept_yn) {
		this.accept_yn = accept_yn;
	}

	public String getUser_photo() {
		return user_photo;
	}

	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}

	@Override
	public String toString() {
		return "JoinDTO [join_idx=" + join_idx + ", meet_num=" + meet_num + ", meet_name=" + meet_name + ", user_id="
				+ user_id + ", user_name=" + user_name + ", regist_date=" + regist_date + ", accept_yn=" + accept_yn
				+ ", user_photo=" + user_photo  + "]";
	}

	

}
