package com.pjt.domain.tsh;

import java.sql.Timestamp;
import java.util.Arrays;

public class BoardVO {

	private int tbl_bno;
	private String tbl_title;
	private String tbl_content;
	private String tbl_writer;
	private Timestamp tbl_regdate;
	private int tbl_viewcnt;
	private int tbl_replycnt;

	private String[] files;

	public BoardVO() {
		super();
	}

	public BoardVO(int tbl_bno, String tbl_title, String tbl_content, String tbl_writer, Timestamp tbl_regdate,
			int tbl_viewcnt, int tbl_replycnt, String[] files) {
		super();
		this.tbl_bno = tbl_bno;
		this.tbl_title = tbl_title;
		this.tbl_content = tbl_content;
		this.tbl_writer = tbl_writer;
		this.tbl_regdate = tbl_regdate;
		this.tbl_viewcnt = tbl_viewcnt;
		this.tbl_replycnt = tbl_replycnt;
		this.files = files;
	}

	public int getTbl_bno() {
		return tbl_bno;
	}

	public void setTbl_bno(int tbl_bno) {
		this.tbl_bno = tbl_bno;
	}

	public String getTbl_title() {
		return tbl_title;
	}

	public void setTbl_title(String tbl_title) {
		this.tbl_title = tbl_title;
	}

	public String getTbl_content() {
		return tbl_content;
	}

	public void setTbl_content(String tbl_content) {
		this.tbl_content = tbl_content;
	}

	public String getTbl_writer() {
		return tbl_writer;
	}

	public void setTbl_writer(String tbl_writer) {
		this.tbl_writer = tbl_writer;
	}

	public Timestamp getTbl_regdate() {
		return tbl_regdate;
	}

	public void setTbl_regdate(Timestamp tbl_regdate) {
		this.tbl_regdate = tbl_regdate;
	}

	public int getTbl_viewcnt() {
		return tbl_viewcnt;
	}

	public void setTbl_viewcnt(int tbl_viewcnt) {
		this.tbl_viewcnt = tbl_viewcnt;
	}

	public int getTbl_replycnt() {
		return tbl_replycnt;
	}

	public void setTbl_replycnt(int tbl_replycnt) {
		this.tbl_replycnt = tbl_replycnt;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "BoardVO [tbl_bno=" + tbl_bno + ", tbl_title=" + tbl_title + ", tbl_content=" + tbl_content
				+ ", tbl_writer=" + tbl_writer + ", tbl_regdate=" + tbl_regdate + ", tbl_viewcnt=" + tbl_viewcnt
				+ ", tbl_replycnt=" + tbl_replycnt + ", files=" + Arrays.toString(files) + "]";
	}

}
