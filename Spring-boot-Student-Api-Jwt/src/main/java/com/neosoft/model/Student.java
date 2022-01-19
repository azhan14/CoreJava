package com.neosoft.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 30)
	private String firstName;
	
	@NotNull
	@Size(max = 30)
	private String lastName;
	
	@NotNull
	@Size(max = 30)
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "proj_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Project project;
}
