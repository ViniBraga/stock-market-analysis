package com.vinibraga.stockmarket.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class Candle {

	private Double open;
	private Double close;
	private Double high;
	private Double low;
	private Long volume;
	private ZonedDateTime zonedDateTime; 
	private LocalDate localDate; 
	
}
