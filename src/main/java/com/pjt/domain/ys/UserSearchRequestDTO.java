package com.pjt.domain.ys;

public class UserSearchRequestDTO extends SearchCriteria{
	private String searchChar;
	private int aint;
	private int lint;
	private int rint;
	private int user_gender;
	public UserSearchRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSearchRequestDTO(String searchChar, int aint, int lint, int rint, int user_gender) {
		super();
		this.searchChar = searchChar;
		this.aint = aint;
		this.lint = lint;
		this.rint = rint;
		this.user_gender = user_gender;
	}
	public String getSearchChar() {
		return searchChar;
	}
	public void setSearchChar(String searchChar) {
		this.searchChar = searchChar;
	}
	public int getAint() {
		return aint;
	}
	public void setAint(int aint) {
		this.aint = aint;
	}
	public int getLint() {
		return lint;
	}
	public void setLint(int lint) {
		this.lint = lint;
	}
	public int getRint() {
		return rint;
	}
	public void setRint(int rint) {
		this.rint = rint;
	}
	public int getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(int user_gender) {
		this.user_gender = user_gender;
	}
	@Override
	public String toString() {
		return "UserSearchRequestDTO [searchChar=" + searchChar + ", aint=" + aint + ", lint=" + lint + ", rint=" + rint
				+ ", user_gender=" + user_gender + "]";
	}
}
