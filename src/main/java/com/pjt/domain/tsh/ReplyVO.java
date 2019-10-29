package com.pjt.domain.tsh;

import java.sql.Timestamp;

public class ReplyVO {
	private int re_rno;
	private int re_bno;
	private String re_text;
	private String re_replyer;
	private Timestamp re_regdate;
	private Timestamp re_updatedate;

	public ReplyVO() {
		super();
	}

	public ReplyVO(int re_rno, int re_bno, String re_text, String re_replyer, Timestamp re_regdate,
			Timestamp re_updatedate) {
		super();
		this.re_rno = re_rno;
		this.re_bno = re_bno;
		this.re_text = re_text;
		this.re_replyer = re_replyer;
		this.re_regdate = re_regdate;
		this.re_updatedate = re_updatedate;
	}

	public int getRe_rno() {
		return re_rno;
	}

	public void setRe_rno(int re_rno) {
		this.re_rno = re_rno;
	}

	public int getRe_bno() {
		return re_bno;
	}

	public void setRe_bno(int re_bno) {
		this.re_bno = re_bno;
	}

	public String getRe_text() {
		return re_text;
	}

	public void setRe_text(String re_text) {
		this.re_text = re_text;
	}

	public String getRe_replyer() {
		return re_replyer;
	}

	public void setRe_replyer(String re_replyer) {
		this.re_replyer = re_replyer;
	}

	public Timestamp getRe_regdate() {
		return re_regdate;
	}

	public void setRe_regdate(Timestamp re_regdate) {
		this.re_regdate = re_regdate;
	}

	public Timestamp getRe_updatedate() {
		return re_updatedate;
	}

	public void setRe_updatedate(Timestamp re_updatedate) {
		this.re_updatedate = re_updatedate;
	}

	@Override
	public String toString() {
		return "ReplyVO [re_rno=" + re_rno + ", re_bno=" + re_bno + ", re_text=" + re_text + ", re_replyer="
				+ re_replyer + ", re_regdate=" + re_regdate + ", re_updatedate=" + re_updatedate + "]";
	}

}
