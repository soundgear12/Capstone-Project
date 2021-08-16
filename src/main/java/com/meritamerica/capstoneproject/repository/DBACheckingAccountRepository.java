package com.meritamerica.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.capstoneproject.models.DBACheckingAccount;

@Repository
public interface DBACheckingAccountRepository extends JpaRepository<DBACheckingAccount, Integer> {

}
