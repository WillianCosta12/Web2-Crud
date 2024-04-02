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

import com.ufrn.ProjectWeb2.model.Product;
import com.ufrn.ProjectWeb2.repository.ProductRepository;


@RestController
public class ProductService {

	@Autowired
	private ProductRepository pr;
	
	@RequestMapping("/product")
	public List<Product> getProduct() {
		return (List<Product>) pr.findAll();
	}

	@PostMapping("/product")
	public Product newProduct(@RequestBody Product pm) {
		return pr.save(pm);
	}

	@PutMapping("/product/{id}")
	public Product updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
		return pr.findById(id).map(product -> {
			product.setName(newProduct.getName());
			product.setDescription(newProduct.getDescription());
			product.setCostPrice(newProduct.getCostPrice());
			product.setSalePrice(newProduct.getSalePrice());
			product.setStockQuantity(newProduct.getStockQuantity());
			return pr.save(product);
		}).orElseGet(() -> {
			newProduct.setId(id);
			return pr.save(newProduct);
		});
	}

	
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable Long id) {
	    pr.delete(new Product(id));
	}
	
}
