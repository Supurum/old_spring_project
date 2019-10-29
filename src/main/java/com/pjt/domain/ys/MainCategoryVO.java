package com.pjt.domain.ys;

public class MainCategoryVO {
	private int main_category_num;
	private String main_category_name;
	private String main_category_url;
	public MainCategoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MainCategoryVO(int main_category_num, String main_category_name, String main_category_url) {
		super();
		this.main_category_num = main_category_num;
		this.main_category_name = main_category_name;
		this.main_category_url = main_category_url;
	}
	public int getMain_category_num() {
		return main_category_num;
	}
	public void setMain_category_num(int main_category_num) {
		this.main_category_num = main_category_num;
	}
	public String getMain_category_name() {
		return main_category_name;
	}
	public void setMain_category_name(String main_category_name) {
		this.main_category_name = main_category_name;
	}
	public String getMain_category_url() {
		return main_category_url;
	}
	public void setMain_category_url(String main_category_url) {
		this.main_category_url = main_category_url;
	}
	@Override
	public String toString() {
		return "MainCategoryVO [main_category_num=" + main_category_num + ", main_category_name=" + main_category_name
				+ ", main_category_url=" + main_category_url + "]";
	}
}
