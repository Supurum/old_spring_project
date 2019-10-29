package com.pjt.domain.ys;

public class RequestMatchDTO {
	private String id;
	private String name;
	private int user_age;
	private int user_gender;
	private int aim;
	
	
	public RequestMatchDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestMatchDTO(String id, String name, int user_age, int aim, int user_gender) {
		super();
		this.id = id;
		this.name = name;
		this.user_age = user_age;
		this.aim = aim;
		this.user_gender = user_gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return user_age;
	}
	public void setAge(int age) {
		this.user_age = age;
	}
	public int getAim() {
		return aim;
	}
	public void setAim(int aim) {
		this.aim = aim;
	}
	public int getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(int user_gender) {
		this.user_gender = user_gender;
	}
	@Override
	public String toString() {
		return "RequestMatchVO [id=" + id + ", name=" + name + ", user_age=" + user_age + ", aim=" + aim + ", user_gender="
				+ user_gender + "]";
	}
}
