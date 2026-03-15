package com.dto;


public class ClientDTO {
	private int client_id;
	private String client_Username;
	private String password;
	private String client_Phone;

	public ClientDTO() {
		// TODO Auto-generated constructor stub
	}

	public ClientDTO( String client_Username, String password, String client_Phone) {
		this.client_Username = client_Username;
		this.password = password;
		this.client_Phone = client_Phone;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getClient_Username() {
		return client_Username;
	}

	public void setClient_Username(String client_Username) {
		this.client_Username = client_Username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClient_Phone() {
		return client_Phone;
	}

	public void setClient_Phone(String client_Phone) {
		this.client_Phone = client_Phone;
	}

	
	
	
}
