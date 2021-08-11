package com.meritamerica.capstoneproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.capstoneproject.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	//Optional<User> findByUserName(String userName);
	
	//boolean existsByUsername(String userName);
	
}
