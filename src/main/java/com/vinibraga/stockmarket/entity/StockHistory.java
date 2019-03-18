package com.vinibraga.stockmarket.entity;

import java.util.Map;

import lombok.Data;

@Data
public class StockHistory {

	private String name;
	private Map<String, Candle> history;
	
}
