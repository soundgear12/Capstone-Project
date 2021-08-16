package com.meritamerica.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.capstoneproject.models.CDOffering;

@Repository
public interface CDOfferingsRepository extends JpaRepository<CDOffering, Long>{

}
