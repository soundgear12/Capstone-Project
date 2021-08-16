package com.meritamerica.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.meritamerica.capstoneproject.models.PersonalCheckingAccount;

@Repository
public interface PersonalCheckingAccountRepository extends JpaRepository<PersonalCheckingAccount, Long> {

}
