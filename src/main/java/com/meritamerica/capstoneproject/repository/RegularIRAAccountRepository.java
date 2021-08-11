package com.meritamerica.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.capstoneproject.models.RegularIRAAccount;

@Repository
public interface RegularIRAAccountRepository extends JpaRepository<RegularIRAAccount, Integer>{

}
