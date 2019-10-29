package com.pjt.domain.ys;

public class MeetUpdateDTO {
	private int meet_num;
	private String user_id;
	
	public MeetUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MeetUpdateDTO(int meet_num, String user_id) {
		super();
		this.meet_num = meet_num;
		this.user_id = user_id;
	}

	public int getMeet_num() {
		return meet_num;
	}

	public void setMeet_num(int meet_num) {
		this.meet_num = meet_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "MeetUpdateVO [meet_num=" + meet_num + ", user_id=" + user_id + "]";
	}
	
}
