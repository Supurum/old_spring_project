package com.pjt.domain.th;

public class Sub_Category_DTO {
	private int category_num;
	private String category_name;
	
	public int getCategory_num() {
		return category_num;
	}
	public void setCategory_num(int category_num) {
		this.category_num = category_num;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	@Override
	public String toString() {
		return "Sub_Category_DTO [category_num=" + category_num + ", category_name=" + category_name + "]";
	}
	
	
	
}
