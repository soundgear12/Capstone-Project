package com.meritamerica.capstoneproject.controllers;

import com.meritamerica.capstoneproject.exceptions.AccountNotFoundException;
import com.meritamerica.capstoneproject.models.AccountHolder;
import com.meritamerica.capstoneproject.models.AccountHolderContactDetails;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountHolderController {

    private AccountHolderService accountHolderService;

    @PostMapping(value = "/accountholder")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('admin')")
    public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder) {
        return accountHolderService.addAccountHolder(accountHolder);
    }

    @GetMapping(value = "/accountholder")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('admin')")
    public List<AccountHolder> getAccountHolders() {
        return accountHolderService.getAccountHolders();
    }

    @GetMapping(value = "/Me/accountholder/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('AccountHolder')")
    public AccountHolder getAccountHolderViaId(@PathVariable Integer id) throws AccountNotFoundException {
        AccountHolder accountHolder;
        try {
            log.info("Getting Account Holder ${id}");
            accountHolder = accountHolderService.getAccountHolderViaId(id);
        } catch (Exception e) {
            log.debug("Getting Account Holder by ID" + e);
            throw new AccountNotFoundException("Account ${id} not found");
        }
        log.info("Grabbing Account Holder ${id}");
        return accountHolder;
    }

    @GetMapping(value = "/accountholder/{id}/contactInfo")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('admin')")
    public AccountHolderContactInfo addContactInfo(@PathVariable Integer id, @RequestBody AccountHolderContactInfo accountHolderContactInfo) {
        return  accountHolderService.addContactInfo(id, accountHolderContactInfo);
    }

}
