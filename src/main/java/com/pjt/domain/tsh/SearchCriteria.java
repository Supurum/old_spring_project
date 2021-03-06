package com.pjt.domain.tsh;

public class SearchCriteria extends Criteria {

	private String searchType;
	private String keyword;

	public SearchCriteria() {
		super();
	}

	public SearchCriteria(String searchType, String keyword) {
		super();
		this.searchType = searchType;
		this.keyword = keyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword 
				+ ", Criteria=" + super.toString()
				+ "]"
				+ hashCode();
	}
}
