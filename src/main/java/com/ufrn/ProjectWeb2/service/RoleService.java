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

import com.ufrn.ProjectWeb2.model.Role;
import com.ufrn.ProjectWeb2.repository.RoleRepository;


@RestController
public class RoleService {

	@Autowired
	private RoleRepository rr;
	
	@RequestMapping("/role")
	public List<Role> getRole() {
		return (List<Role>) rr.findAll();
	}

	@PostMapping("/role")
	public Role newRole(@RequestBody Role rm) {
		return rr.save(rm);
	}

	@PutMapping("/role/{id}")
	public Role updateRole(@RequestBody Role newRole, @PathVariable Long id) {
		return rr.findById(id).map(role -> {
			role.setType(newRole.getType());
			return rr.save(role);
		}).orElseGet(() -> {
			newRole.setId(id);
			return rr.save(newRole);
		});
	}

	
	@DeleteMapping("/role/{id}")
	public void deleteRole(@PathVariable Long id) {
	    rr.delete(new Role(id));
	}
	
}
