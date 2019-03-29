package com.vinibraga.stockmarket.entity;

import lombok.Data;

@Data
public class Candle {

	private String open;
	private String close;
	private String high;
	private String low;
	private String volume;
	private String date; 
	
}
