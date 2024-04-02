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

import com.ufrn.ProjectWeb2.model.TypeMovement;
import com.ufrn.ProjectWeb2.repository.TypeMovementRepository;


@RestController
public class TypeMovementService {

	@Autowired
	private TypeMovementRepository tr;
	
	@RequestMapping("/typeMovement")
	public List<TypeMovement> getTypeMovement() {
		return (List<TypeMovement>) tr.findAll();
	}

	@PostMapping("/typeMovement")
	public TypeMovement newTypeMovement(@RequestBody TypeMovement tm) {
		return tr.save(tm);
	}

	@PutMapping("/typeMovement/{id}")
	public TypeMovement updateTypeMovement(@RequestBody TypeMovement newTypeMovement, @PathVariable Long id) {
		return tr.findById(id).map(tm -> {
			tm.setType(newTypeMovement.getType());
			return tr.save(tm);
		}).orElseGet(() -> {
			newTypeMovement.setId(id);
			return tr.save(newTypeMovement);
		});
	}

	
	@DeleteMapping("/typeMovement/{id}")
	public void deleteTypeMovement(@PathVariable Long id) {
	    tr.delete(new TypeMovement(id));
	}
	
	
}
