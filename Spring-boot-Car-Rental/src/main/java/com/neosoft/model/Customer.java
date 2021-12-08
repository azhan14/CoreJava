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
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "custid")
	private int id;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "custname")
	private String name;
	
	@NotNull
	@Size(max = 20)
	@Column(name = "custemail")
	private String email;
	
	@NotNull
	@Size(max = 40)
	@Column(name = "custpassword")
	private String password;
	
	@NotNull
	@Size(max = 13)
	@Column(name = "custcontact")
	private String contact;

	public Customer(@NotNull @Size(max = 65) String name, @NotNull @Size(max = 20) String email,
			@NotNull @Size(max = 40) String password, @NotNull @Size(max = 13) String contact) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
	}
}
