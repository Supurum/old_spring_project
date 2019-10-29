package com.pjt.domain.th;

public class Criteria {

	private int page = 1;
	private int perPageNum = 6;
	private int startRow = 1;
	private int endRow = 6;

	public Criteria() {
		super();
	}
	
	public Criteria(int page) {
		this(page, 10);
	}

	public Criteria(int page, int perPageNum) {
		super();
		this.page = page;
		this.perPageNum = perPageNum;
		setStartRowEndRow(page, perPageNum);
	}
	
	private void setStartRowEndRow(int page, int perPageNum) {
		this.startRow = ((page - 1) * perPageNum) + 1;
		this.endRow = page * perPageNum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
		setStartRowEndRow(page, perPageNum);
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
		setStartRowEndRow(page, perPageNum);
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", startRow=" + startRow + ", endRow=" + endRow
				+ "]";
	}

	

}
