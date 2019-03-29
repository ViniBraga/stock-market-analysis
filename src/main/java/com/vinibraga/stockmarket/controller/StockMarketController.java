package com.vinibraga.stockmarket.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.vinibraga.stockmarket.entity.AnalysisType;
import com.vinibraga.stockmarket.entity.Candle;
import com.vinibraga.stockmarket.entity.ResearchData;
import com.vinibraga.stockmarket.entity.Stock;
import com.vinibraga.stockmarket.entity.StockHistory;
import com.vinibraga.stockmarket.entity.StockInfo;
import com.vinibraga.stockmarket.entity.StockIntraday;
import com.vinibraga.stockmarket.service.StockMarketService;

import lombok.Getter;

@Controller
@RequestMapping("/stock")
public class StockMarketController {

	@Autowired
	private StockMarketService service;
	
	@Getter
	private StockHistory stockHistory;
	
	@Getter
	private StockIntraday stockIntraday;
	
	@Getter
	private StockInfo stockInfo;
	
	@GetMapping
	public String loadStock(Model model) {
		model.addAttribute("researchData", new ResearchData()); 
		List<Stock> stocks = service.getList();
		model.addAttribute("stocks", stocks);
		model.addAttribute("stockInfo", new StockInfo());
		model.addAttribute("stockHistory", new StockHistory());
        model.addAttribute("stockIntraday", new StockIntraday());
		return "stock";
	}
	
    @PostMapping
    public String loadStock(Model model, @Valid @ModelAttribute ResearchData researchData) {
    	stockInfo = service.getInfo(researchData.getSymbol());
    	model.addAttribute("stockInfo", stockInfo);
    	if(researchData.getAnalysisType().equals(AnalysisType.INTRADAY)) {
    		stockIntraday = service.getIntraday(researchData.getSymbol());
    		stockHistory = new StockHistory();
    	} else {
    		stockHistory = service.getHistory(researchData.getSymbol());
    		stockIntraday = new StockIntraday();
    	}   	
    	
    	List<Candle> history = stockHistory
    			.getHistory()
    			.values()
    			.stream()
    			.collect(Collectors.toList());
    	
    	Gson gson = new Gson();

        model.addAttribute("stockHistory", gson.toJson(history));
        model.addAttribute("stockIntraday", stockIntraday);
        return "stock";
    }
	
}
