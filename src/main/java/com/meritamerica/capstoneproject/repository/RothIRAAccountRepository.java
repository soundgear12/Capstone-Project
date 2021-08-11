package com.meritamerica.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.capstoneproject.models.RothIRAAccount;
@Repository
public interface RothIRAAccountRepository extends JpaRepository<RothIRAAccount, Integer> {

}
