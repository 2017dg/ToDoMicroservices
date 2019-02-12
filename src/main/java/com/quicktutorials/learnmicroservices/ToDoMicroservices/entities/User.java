package com.quicktutorials.learnmicroservices.ToDoMicroservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//validator= Hibernate validator
//data binding (email,name,pasword) -> new User(email, name, password)

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@Column(name = "EMAIL")
	@Getter
	@Setter
	@NotNull
	@NotBlank
	@NotEmpty
	private String email;

	@Getter
	@Setter
	@Column(name = "NAME")
	@NotNull
	@NotBlank
	@NotEmpty
	private String name;

	@Getter
	@Setter
	@Column(name = "PASSWORD")
	@NotNull
	@NotBlank
	@NotEmpty
	private String password;

	/*
	 * //using lobok u dont have to specify below stuffs public User(){} public
	 * User(String email, String name, String password) { super(); this.email =
	 * email; this.name = name; this.password = password; } public String getEmail()
	 * { return email; } public void setEmail(String email) { this.email = email; }
	 * public String getName() { return name; } public void setName(String name) {
	 * this.name = name; } public String getPassword() { return password; } public
	 * void setPassword(String password) { this.password = password; }
	 */
}
