package com.neosoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "renter")
public class Renter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Size(max = 20)
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Size(max = 40)
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Size(max = 13)
	@Column(name = "contact")
	private String contact;

	public Renter(@NotNull @Size(max = 65) String name, @NotNull @Size(max = 20) String email,
			@NotNull @Size(max = 40) String password, @NotNull @Size(max = 13) String contact) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
	}
}
