package com.meritamerica.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.capstoneproject.models.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

}
