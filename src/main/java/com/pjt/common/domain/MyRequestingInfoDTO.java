package com.pjt.common.domain;

import java.sql.Timestamp;

public class MyRequestingInfoDTO {

	private String meet_num;
	private String meet_writer;
	private String gender_name;
	private Timestamp regist_date;
	private String accept_yn;

	
	
	public MyRequestingInfoDTO() {
		super();
	}

	public MyRequestingInfoDTO(String meet_num, String meet_writer, String gender_name, Timestamp regist_date,
			String accept_yn) {
		super();
		this.meet_num = meet_num;
		this.meet_writer = meet_writer;
		this.gender_name = gender_name;
		this.regist_date = regist_date;
		this.accept_yn = accept_yn;
	}

	public String getMeet_num() {
		return meet_num;
	}

	public void setMeet_num(String meet_num) {
		this.meet_num = meet_num;
	}

	public String getMeet_writer() {
		return meet_writer;
	}

	public void setMeet_writer(String meet_writer) {
		this.meet_writer = meet_writer;
	}

	public String getGender_name() {
		return gender_name;
	}

	public void setGender_name(String gender_name) {
		this.gender_name = gender_name;
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

	@Override
	public String toString() {
		return "MyRequestingInfoDTO [meet_num=" + meet_num + ", meet_writer=" + meet_writer + ", gender_name="
				+ gender_name + ", regist_date=" + regist_date + ", accept_yn=" + accept_yn + "]";
	}

}
