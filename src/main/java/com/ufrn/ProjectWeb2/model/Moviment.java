package com.ufrn.ProjectWeb2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Moviment {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USR")
	    long id;
	    long idUser;
	    long idStockProduct;
	    long idTypeMovement;
	    String description;
	    
		public Moviment(Long id) {
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
		public long getIdStockProduct() {
			return idStockProduct;
		}
		public void setIdStockProduct(long idStockProduct) {
			this.idStockProduct = idStockProduct;
		}
		public long getIdTypeMovement() {
			return idTypeMovement;
		}
		public void setIdTypeMovement(long idTypeMovement) {
			this.idTypeMovement = idTypeMovement;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	    
	    
	
}
