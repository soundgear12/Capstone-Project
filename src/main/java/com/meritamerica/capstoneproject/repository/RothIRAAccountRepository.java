package com.meritamerica.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.capstoneproject.models.RothIRAAccount;

public interface RothIRAAccountRepository extends JpaRepository<RothIRAAccount, Integer> {

}
