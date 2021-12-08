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
@Table(name = "car")
public class Car {
	
	@Id
	@Column(name = "carno")
	private String number;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "carname")
	private String name;
	
	@NotNull
	@Size(max = 30)
	@Column(name = "carmf")
	private String mf;
	
	@NotNull
	@Column(name = "caryear")
	private int year;
	
	@NotNull
	@Column(name = "carprice")
	private int price;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "carstatus")
	private Status status = Status.YES;
}
