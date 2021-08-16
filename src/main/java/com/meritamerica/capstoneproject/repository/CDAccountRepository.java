package com.meritamerica.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.capstoneproject.models.CDAccount;

@Repository
public interface CDAccountRepository extends JpaRepository<CDAccount, Long> {

}
