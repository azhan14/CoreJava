package com.neosoft;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "tempexchange")
public class TempExchange {
	
	@Id
	@NonNull
	private Long id;
	
	@NonNull
	@Column(name = "conversion_from")
	private String from;
	
	@Column(name = "conversion_to")
	@NonNull
	private String to;
	
	@NonNull
	private BigDecimal conversionMultiple;
	
	private String environment;
}
