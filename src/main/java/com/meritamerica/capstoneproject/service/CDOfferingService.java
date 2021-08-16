package com.meritamerica.capstoneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.capstoneproject.models.CDOffering;
import com.meritamerica.capstoneproject.repository.CDOfferingsRepository;

@Service
public class CDOfferingService {

	@Autowired
	CDOfferingsRepository cdOfferingsRepo;
	
	public CDOffering addCDOffering(CDOffering cdOffering) {
		return cdOfferingsRepo.save(cdOffering);
	}
	
	public List<CDOffering> getCDOfferings() {
		
		return cdOfferingsRepo.findAll();
	}
}
