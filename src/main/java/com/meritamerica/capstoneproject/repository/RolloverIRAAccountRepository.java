package com.meritamerica.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.capstoneproject.models.RolloverIRAAccount;

@Repository
public interface RolloverIRAAccountRepository extends JpaRepository<RolloverIRAAccount, Integer>{

}
