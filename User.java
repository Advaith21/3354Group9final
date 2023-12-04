package com.otm.login;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String email;
	private String username;
	private String password;
	private String date;
	private String time;
	
	public User(String username, String password, String date, String time) {
		this.username = username;
		this.date = date;
		this.time = time;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getDob() {
		return date;
	}

	public String getTime() {
		return time;
	}
	
	public String toString() {
		return "user: " + username + ", email: " + email + ", password: " +  password + ", date: " + date + ", time: " + time;
	}

}
