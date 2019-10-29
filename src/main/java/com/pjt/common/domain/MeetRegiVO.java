package com.pjt.common.domain;

public class MeetRegiVO {
	private int meet_num;
	private int meet_category;
	private String meet_name;
	private int meet_sub_category;
	private int meet_addr;
	private String meet_writer;
	private String meet_state;
	private String meet_place;
	private int meet_maxpeoplenum;

	public MeetRegiVO() {
		super();
	}

	public MeetRegiVO(int meet_num, int meet_category, String meet_name, int meet_sub_category, int meet_addr,
			String meet_writer, String meet_state, int meet_maxpeoplenum) {
		super();
		this.meet_num = meet_num;
		this.meet_category = meet_category;
		this.meet_name = meet_name;
		this.meet_sub_category = meet_sub_category;
		this.meet_addr = meet_addr;
		this.meet_writer = meet_writer;
		this.meet_state = meet_state;
		this.meet_maxpeoplenum = meet_maxpeoplenum;
	}

	public int getMeet_num() {
		return meet_num;
	}

	public void setMeet_num(int meet_num) {
		this.meet_num = meet_num;
	}

	public int getMeet_category() {
		return meet_category;
	}

	public void setMeet_category(int meet_category) {
		this.meet_category = meet_category;
	}

	public String getMeet_name() {
		return meet_name;
	}

	public void setMeet_name(String meet_name) {
		this.meet_name = meet_name;
	}

	public int getMeet_sub_category() {
		return meet_sub_category;
	}

	public void setMeet_sub_category(int meet_sub_category) {
		this.meet_sub_category = meet_sub_category;
	}

	public int getMeet_addr() {
		return meet_addr;
	}

	public void setMeet_addr(int meet_addr) {
		this.meet_addr = meet_addr;
	}

	public String getMeet_writer() {
		return meet_writer;
	}

	public void setMeet_writer(String meet_writer) {
		this.meet_writer = meet_writer;
	}

	public String getMeet_state() {
		return meet_state;
	}

	public void setMeet_state(String meet_state) {
		this.meet_state = meet_state;
	}

	public int getMeet_maxpeoplenum() {
		return meet_maxpeoplenum;
	}

	public void setMeet_maxpeoplenum(int meet_maxpeoplenum) {
		this.meet_maxpeoplenum = meet_maxpeoplenum;
	}

	public String getMeet_place() {
		return meet_place;
	}

	public void setMeet_place(String meet_place) {
		this.meet_place = meet_place;
	}

	@Override
	public String toString() {
		return "MeetRegiVO [meet_num=" + meet_num + ", meet_category=" + meet_category + ", meet_name=" + meet_name
				+ ", meet_sub_category=" + meet_sub_category + ", meet_addr=" + meet_addr + ", meet_writer="
				+ meet_writer + ", meet_state=" + meet_state + ", meet_place=" + meet_place + ", meet_maxpeoplenum="
				+ meet_maxpeoplenum + "]";
	}
	
}
