package com.ufrn.ProjectWeb2.repository;

import org.springframework.data.repository.CrudRepository;

import com.ufrn.ProjectWeb2.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
