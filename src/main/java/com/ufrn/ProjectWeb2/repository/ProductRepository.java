package com.ufrn.ProjectWeb2.repository;

import org.springframework.data.repository.CrudRepository;

import com.ufrn.ProjectWeb2.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
