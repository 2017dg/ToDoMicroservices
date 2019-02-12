package com.quicktutorials.learnmicroservices.ToDoMicroservices.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "todos")
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	@Getter
	@Setter
	private Integer id;
	
	@Column(name = "DESCRIPTION")
	@Getter
	@Setter
	@NotNull
	@NotBlank
	@NotEmpty
	private String description;
	
	@Column(name = "DATE")
	@Getter
	@Setter
	private Date date;
	
	@Column(name = "PRIORITY")
	@Getter
	@Setter
	@NotNull
	@NotBlank
	@NotEmpty
	private String priority;
	
	@Column(name = "FK_USER")
	@Getter
	@Setter
	@NotNull
	@NotBlank
	@NotEmpty
	private String fkUser;
	
	@PrePersist
	void getTimeOperation() {
		this.date=new Date();
	}
	
}
