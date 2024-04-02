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

import com.ufrn.ProjectWeb2.model.Moviment;
import com.ufrn.ProjectWeb2.repository.MovimentRepository;

@RestController
public class MovimentService {
	
	@Autowired
	private MovimentRepository mr;
	
	@RequestMapping("/moviment")
	public List<Moviment> getMoviment() {
		return (List<Moviment>) mr.findAll();
	}

	@PostMapping("/moviment")
	public Moviment newMoviment(@RequestBody Moviment mv) {
		return mr.save(mv);
	}

	@PutMapping("/moviment/{id}")
	public Moviment updateMoviment(@RequestBody Moviment newMoviment, @PathVariable Long id) {
		return mr.findById(id).map(moviment -> {
			moviment.setDescription(newMoviment.getDescription());
			return mr.save(moviment);
		}).orElseGet(() -> {
			newMoviment.setId(id);
			return mr.save(newMoviment);
		});
	}

	
	@DeleteMapping("/moviment/{id}")
	public void deleteMoviment(@PathVariable Long id) {
	    mr.delete(new Moviment(id));
	}
	
}
