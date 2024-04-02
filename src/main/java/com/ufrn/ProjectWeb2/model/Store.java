package com.ufrn.ProjectWeb2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Store {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USR")
    long id;
    String name;
    String address;
    long idStock;
    
	public Store(Long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getIdStock() {
		return idStock;
	}
	public void setIdStock(long idStock) {
		this.idStock = idStock;
	}
    
    
	
}
