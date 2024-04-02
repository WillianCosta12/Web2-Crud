package com.ufrn.ProjectWeb2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Permission {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USR")
    long id;
    long idUser;
    String permission;
    
	public Permission(Long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
    
    
	
}
