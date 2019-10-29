package com.pjt.domain.ys;

public class SearchCriteria extends Criteria {
	private String searchChar;
	private int AsearchInt;
	private int LsearchInt;
	private int RsearchInt;
	public SearchCriteria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchCriteria(String searchChar, int asearchInt, int lsearchInt, int rsearchInt) {
		super();
		this.searchChar = searchChar;
		AsearchInt = asearchInt;
		LsearchInt = lsearchInt;
		RsearchInt = rsearchInt;
	}
	public String getSearchChar() {
		return searchChar;
	}
	public void setSearchChar(String searchChar) {
		this.searchChar = searchChar;
	}
	public int getAsearchInt() {
		return AsearchInt;
	}
	public void setAsearchInt(int asearchInt) {
		AsearchInt = asearchInt;
	}
	public int getLsearchInt() {
		return LsearchInt;
	}
	public void setLsearchInt(int lsearchInt) {
		LsearchInt = lsearchInt;
	}
	public int getRsearchInt() {
		return RsearchInt;
	}
	public void setRsearchInt(int rsearchInt) {
		RsearchInt = rsearchInt;
	}
	@Override
	public String toString() {
		return "SearchCriteria [searchChar=" + searchChar + ", AsearchInt=" + AsearchInt + ", LsearchInt=" + LsearchInt
				+ ", RsearchInt=" + RsearchInt + "]";
	}
}
