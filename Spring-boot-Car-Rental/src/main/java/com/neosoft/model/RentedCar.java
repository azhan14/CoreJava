package com.neosoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "rentedcar")
public class RentedCar {
	
	@Id
	@NotNull
	@Column(name = "carno")
	private String number;
	
	@NotNull
	@Column(name = "custid")
	private int id;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "custname")
	private String name;
	
	@NotNull
	@Column(name = "carprice")
	private int price;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "returnstatus")
	private Status returnstatus = Status.NO;
}
