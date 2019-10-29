package com.pjt.common.domain;

import java.sql.Timestamp;

public class MessageVO {

	private int msg_num;
	private String targetid;
	private String sender;
	private String message;
	private Timestamp opendate;
	private Timestamp senddate;

	public MessageVO() {
		super();
	}

	public MessageVO(int msg_num, String targetid, String sender, String message, Timestamp opendate,
			Timestamp senddate) {
		super();
		this.msg_num = msg_num;
		this.targetid = targetid;
		this.sender = sender;
		this.message = message;
		this.opendate = opendate;
		this.senddate = senddate;
	}

	public int getMsg_num() {
		return msg_num;
	}

	public void setMsg_num(int msg_num) {
		this.msg_num = msg_num;
	}

	public String getTargetid() {
		return targetid;
	}

	public void setTargetid(String targetid) {
		this.targetid = targetid;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getOpendate() {
		return opendate;
	}

	public void setOpendate(Timestamp opendate) {
		this.opendate = opendate;
	}

	public Timestamp getSenddate() {
		return senddate;
	}

	public void setSenddate(Timestamp senddate) {
		this.senddate = senddate;
	}

	@Override
	public String toString() {
		return "MessageVO [msg_num=" + msg_num + ", targetid=" + targetid + ", sender=" + sender + ", message="
				+ message + ", opendate=" + opendate + ", senddate=" + senddate + "]";
	}

}
