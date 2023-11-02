package com.facens.ac2.controller.form;

import com.facens.ac2.model.User;
import com.facens.ac2.repository.UserRepository;

public class UserForm {
	private String name;
	private String email;
	private String password;
	
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User convert(UserRepository userRepository) {
		return new User(name, email, password);
	}
}
