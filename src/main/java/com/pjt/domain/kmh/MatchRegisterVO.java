package com.pjt.domain.kmh;

// 매칭 등록에 필요한 유저 정보들.
public class MatchRegisterVO {

	private String user_photo;
	private String meet_name;
	private String category_name;
	private String loc_name;
	private String meet_writer;

	public String getUser_photo() {
		return user_photo;
	}

	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}

	public String getMeet_name() {
		return meet_name;
	}

	public void setMeet_name(String meet_name) {
		this.meet_name = meet_name;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getLoc_name() {
		return loc_name;
	}

	public void setLoc_name(String loc_name) {
		this.loc_name = loc_name;
	}

	public String getMeet_writer() {
		return meet_writer;
	}

	public void setMeet_writer(String meet_writer) {
		this.meet_writer = meet_writer;
	}

	@Override
	public String toString() {
		return "MatchRegisterVO [user_photo=" + user_photo + ", meet_name=" + meet_name + ", category_name="
				+ category_name + ", loc_name=" + loc_name + ", meet_writer=" + meet_writer + "]";
	}

	public MatchRegisterVO(String user_photo, String meet_name, String category_name, String loc_name,
			String meet_writer) {
		super();
		this.user_photo = user_photo;
		this.meet_name = meet_name;
		this.category_name = category_name;
		this.loc_name = loc_name;
		this.meet_writer = meet_writer;
	}

	public MatchRegisterVO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
