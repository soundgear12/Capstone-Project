package com.meritamerica.capstoneproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.meritamerica.capstoneproject.models.CDOffering;
import com.meritamerica.capstoneproject.service.CDOfferingService;

@RestController
public class CDOfferingsController {
	
	@Autowired
	CDOfferingService cdOfferingService;
	
	@PostMapping(value = "/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering addCDOffering(@RequestBody CDOffering cdOffering) {
		return cdOfferingService.addCDOffering(cdOffering);
		
	}
	
	@GetMapping(value = "/CDOfferings")
	@ResponseStatus(HttpStatus.OK)
	public List<CDOffering> getCDOfferings() {
		return cdOfferingService.getCDOfferings();
	}

}
