package com.meritamerica.capstoneproject.controllers;

import org.springframework.http.HttpStatus;

import com.meritamerica.capstoneproject.exceptions.AccountNotFoundException

	@CrossOrigin(origins="http//localhost3000")
	@RestController
	@RequestMapping("/api")
	@PostMapping(value = "/checkingaccounts")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('admin')")

	@GetMapping(value = "/checkingaccounts")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasAuthority('admin')")
	public PersonalCheckingAccount getCheckingAccounts(@PathVariable.id) throws InvalidArgumentException {
    	return accountHolderService.getCheckingAccounts(id);
	}

	@PostMapping(value = "/savingsaccounts")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('admin')")
	public SavingsAccount addSavingsAccount(@RequestBody SavingsAccount savingsAccount, @PathVariable Integer id) throws AccountNotFoundException, ExceedsAvailableBalanceException, InvalidArgumentException {
    	return accountsService.addSavingsAccount(id, savingsAccount);
	}

	@GetMapping(value = "/savingsaccounts")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasAuthority('admin')")
	public SavingsAccount getSavingsAccounts(@PathVariable Integer id) throws AccountNotFoundException {
		return accountHolderService.getSavingsAccounts(id);
	}

	@PostMapping(value = "/cdaccounts")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('admin')")
	public CDAccount addCDAccount(@RequestBody CDAccount cdAccount, @PathVariable Integer id) throws AccountNotFoundException, ExceedsAvailableBalanceException, InvalidArgumentException {
    	return accountsService.addCDAccount(id, cdAccount);
	}

	@GetMapping(value = "/cdaccounts")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasAuthority('admin')")
	public List<CDAccount> getCDAccountsById(@PathVariable Integer id) throws AccountNotFoundException {
		return accountHolderService.getCDAccounts(id);
	}
}