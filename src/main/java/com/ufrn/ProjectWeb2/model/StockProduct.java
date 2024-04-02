package com.ufrn.ProjectWeb2.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StockProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USR")
    long id;
    long idStock;
    Date entryDate;
    Date departureDate;
    
	public StockProduct(Long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdStock() {
		return idStock;
	}
	public void setIdStock(long idStock) {
		this.idStock = idStock;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
    
    
	
}
