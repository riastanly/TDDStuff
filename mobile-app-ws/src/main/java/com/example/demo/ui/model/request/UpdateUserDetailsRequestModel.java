package com.example.demo.ui.model.request;

import jakarta.validation.constraints.NotNull;

public class UpdateUserDetailsRequestModel {
	@NotNull(message = "fname cant be null")
	private String fname;
	@NotNull(message = "lname cant be null")
	private String lname;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
}
