package com.meritamerica.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.capstoneproject.models.SavingsAccount;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Integer> {

}
