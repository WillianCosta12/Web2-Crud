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

import com.ufrn.ProjectWeb2.model.Permission;
import com.ufrn.ProjectWeb2.repository.PermissionRepository;

@RestController
public class PermissionService {

	@Autowired
	private PermissionRepository pr;
	
	@RequestMapping("/permission")
	public List<Permission> getPermission() {
		return (List<Permission>) pr.findAll();
	}

	@PostMapping("/permission")
	public Permission newPermission(@RequestBody Permission pm) {
		return pr.save(pm);
	}

	@PutMapping("/permission/{id}")
	public Permission updatePermission(@RequestBody Permission newPermission, @PathVariable Long id) {
		return pr.findById(id).map(permission -> {
			permission.setPermission(newPermission.getPermission());
			return pr.save(permission);
		}).orElseGet(() -> {
			newPermission.setId(id);
			return pr.save(newPermission);
		});
	}

	
	@DeleteMapping("/permission/{id}")
	public void deletePermission(@PathVariable Long id) {
	    pr.delete(new Permission(id));
	}
	
	
}
