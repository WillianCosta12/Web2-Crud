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

import com.ufrn.ProjectWeb2.model.Store;
import com.ufrn.ProjectWeb2.repository.StoreRepository;


@RestController
public class StoreService {

	@Autowired
	private StoreRepository sr;
	
	@RequestMapping("/store")
	public List<Store> getStore() {
		return (List<Store>) sr.findAll();
	}

	@PostMapping("/store")
	public Store newStore(@RequestBody Store sm) {
		return sr.save(sm);
	}

	@PutMapping("/store/{id}")
	public Store updateStore(@RequestBody Store newStore, @PathVariable Long id) {
		return sr.findById(id).map(store -> {
			store.setName(newStore.getName());
			store.setAddress(newStore.getAddress());
			return sr.save(store);
		}).orElseGet(() -> {
			newStore.setId(id);
			return sr.save(newStore);
		});
	}

	
	@DeleteMapping("/store/{id}")
	public void deleteStore(@PathVariable Long id) {
	    sr.delete(new Store(id));
	}
	
}
