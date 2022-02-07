package com.esanti.backendcash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esanti.backendcash.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
