package com.pjt.domain.ys;

public class PointVO {
	private String user_id;
	private String point_situation;
	private String pointlog_content;
	public PointVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PointVO(String user_id, String point_situation, String pointlog_content) {
		super();
		this.user_id = user_id;
		this.point_situation = point_situation;
		this.pointlog_content = pointlog_content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPoint_situation() {
		return point_situation;
	}
	public void setPoint_situation(String point_situation) {
		this.point_situation = point_situation;
	}
	public String getPointlog_content() {
		return pointlog_content;
	}
	public void setPointlog_content(String pointlog_content) {
		this.pointlog_content = pointlog_content;
	}
	@Override
	public String toString() {
		return "PointTradeVO [user_id=" + user_id + ", point_situation=" + point_situation + ", pointlog_content="
				+ pointlog_content + "]";
	}
}
