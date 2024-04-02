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

import com.ufrn.ProjectWeb2.model.StockProduct;
import com.ufrn.ProjectWeb2.repository.StockProductRepository;


@RestController
public class StockProductService {

	@Autowired
	private StockProductRepository sr;
	
	@RequestMapping("/stockProduct")
	public List<StockProduct> getStockProduct() {
		return (List<StockProduct>) sr.findAll();
	}

	@PostMapping("/stockProduct")
	public StockProduct newStockProduct(@RequestBody StockProduct sm) {
		return sr.save(sm);
	}

	@PutMapping("/stockProduct/{id}")
	public StockProduct updateStockProduct(@RequestBody StockProduct newStockProduct, @PathVariable Long id) {
		return sr.findById(id).map(sp -> {
			sp.setEntryDate(newStockProduct.getEntryDate());
			sp.setDepartureDate(newStockProduct.getDepartureDate());
			return sr.save(sp);
		}).orElseGet(() -> {
			newStockProduct.setId(id);
			return sr.save(newStockProduct);
		});
	}

	
	@DeleteMapping("/stockProduct/{id}")
	public void deleteStockProduct(@PathVariable Long id) {
	    sr.delete(new StockProduct(id));
	}
	
}
