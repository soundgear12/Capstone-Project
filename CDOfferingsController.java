package com.meritamerica.capstoneproject.controllers;

import com.meritamerica.capstoneproject.models.CDOffering;
import com.meritamerica.capstoneproject.services.CDOfferingsService;

import java.util.List;

@RestController
@RequestMapping("/api/cdofferings")
public class CDOfferingsController {

    @Autowired
    CDOfferingsService cdOfferingsService;

    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('admin')")
    public CDOffering addCDOffering(@RequestBody CDOffering cdOffering) {
        return cdOfferingsService.addCDOffering(cdOffering);
    }

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public List<CDOffering> getCDOfferings() {
        return cdOfferingsService.getCDOfferings();
    }
}
