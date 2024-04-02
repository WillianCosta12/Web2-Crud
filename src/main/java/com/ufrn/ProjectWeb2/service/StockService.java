package com.ufrn.ProjectWeb2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.ProjectWeb2.model.Stock;
import com.ufrn.ProjectWeb2.repository.StockRepository;


@RestController
public class StockService {

	@Autowired
	private StockRepository sr;
	
	@RequestMapping("/stock")
	public List<Stock> getStock() {
		return (List<Stock>) sr.findAll();
	}

	@PostMapping("/stock")
	public Stock newStock(@RequestBody Stock sm) {
		return sr.save(sm);
	}

	@PutMapping("/stock/{id}")
	public Stock updateStock(@RequestBody Stock newStock, @PathVariable Long id) {
		return sr.findById(id).map(stock -> {
			return sr.save(stock);
		}).orElseGet(() -> {
			newStock.setId(id);
			return sr.save(newStock);
		});
	}

	
	@DeleteMapping("/stock/{id}")
	public void deleteStock(@PathVariable Long id) {
	    sr.delete(new Stock(id));
	}
	
	
}
