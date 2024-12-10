package com.proje.web.service;

import java.util.List;

import com.proje.web.entityDTO.AccountDTO;


public interface AccountService {

	List<AccountDTO> getAccounts();
	
	AccountDTO getAccount(Long id);
	
	AccountDTO createAccount(AccountDTO accountDTO);
	
	public void delete(Long id);
	
	public AccountDTO update(Long id, AccountDTO accountDTO);
	
	
	
	
}
