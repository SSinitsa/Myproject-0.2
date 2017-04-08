package com.ssinitsa.training.culinary.datamodel;

import java.sql.Timestamp;

public class User {
	private Integer id;
	private String login;
	private String password;
	private Timestamp registrated;
	private String firstName;
	private String lastName;
	private String email;
	private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegistrated() {
		return registrated;
	}

	public void setRegistrated(Timestamp registrated) {
		this.registrated = registrated;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", registrated=" + registrated
				+ ", first_name=" + firstName + ", last_name=" + lastName + ", e-mail=" + email + ", role=" + role
				+ "]";

	}
}
