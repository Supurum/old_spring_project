package com.pjt.domain.ys;

public class LogVO {
	private String user_id;
	private String log_content;
	public LogVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LogVO(String user_id, String log_content) {
		super();
		this.user_id = user_id;
		this.log_content = log_content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getLog_content() {
		return log_content;
	}
	public void setLog_content(String log_content) {
		this.log_content = log_content;
	}
	@Override
	public String toString() {
		return "LogVO [user_id=" + user_id + ", log_content=" + log_content + "]";
	}
}
