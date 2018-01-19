package com.ankit.web;

import com.opensymphony.xwork2.ActionSupport;

public class UserLogin extends ActionSupport {

	private String name;
	private String email;
	private int random;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRandom() {
		return random;
	}

	public void setRandom(int random) {
		this.random = random;
	}

	public  String login() {
		
		random=(int)( Math.random()*10);
		System.out.println("Name->"+name+" random->"+random);
		return SUCCESS;
	}
}
