package com.meritamerica.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.capstoneproject.models.AccountHolder;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {

}
