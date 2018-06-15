package com.ssm.pojo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class TblUser {
	@NotNull(message = "{id}")
	private Long id;
	@NotEmpty(message = "{name}")
	private String name;

	private String password;
	@NotEmpty
	@Email(message = "{email}")
	private String email;
	@Past
	@DateTimeFormat(iso=ISO.DATE)
	private Date date;

	public TblUser() {
		super();
	}

	public TblUser(Long id, String name, String password, String email, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}