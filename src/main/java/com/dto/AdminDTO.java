package com.dto;

public class AdminDTO {
	private String name;
	private String pass;
	private String phone;

	public AdminDTO() {
		// TODO Auto-generated constructor stub
	}

	public AdminDTO(String name, String pass, String phone) {
		super();
		this.name = name;
		this.pass = pass;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
  
}
