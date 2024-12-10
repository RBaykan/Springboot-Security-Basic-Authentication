package com.proje.web.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proje.web.entity.Account;

import com.proje.web.entityDTO.AccountDTO;
import com.proje.web.exception.AccountNotFound;
import com.proje.web.mapper.AccountMapper;
import com.proje.web.repository.AccountRepository;
import com.proje.web.service.AccountService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
	
	private final AccountRepository repository;
	
	

	@Override
	public AccountDTO createAccount(AccountDTO accountDTO) {
		// TODO Auto-generated  stub
		Account account = AccountMapper.AccountDTOToAccount(accountDTO);
		Account savedAccount = repository.save(account);
		
		return AccountMapper.AccountToAccountDTO(savedAccount);
	}

	@Override
	public AccountDTO getAccount(Long id) {
		
		Account account = repository.findById(id)
				.orElseThrow(() -> new AccountNotFound("Account not found by id:" + id));
		
		return AccountMapper.AccountToAccountDTO(account);
	}

	@Override
	public List<AccountDTO> getAccounts() {
		
		List<Account> accounts = repository.findAll();
		return accounts.stream().map(
				(account) -> AccountMapper.AccountToAccountDTO(account)
				).collect(Collectors.toList());
				
	}
	
	@Override
	public void delete(Long id) {
		
		Account account = repository.findById(id)
				.orElseThrow(() -> new AccountNotFound("Account not found by id:" + id));
		
		repository.delete(account);
		
	}
	
	
	@Override
	public AccountDTO update(Long id, AccountDTO accountDTO) {
		Account account = repository.findById(id)
				.orElseThrow(() -> new AccountNotFound("Account not found by id:" + id));
		
		account.builder()
		.firstname(accountDTO.getFirstname())
		.lastname(accountDTO.getLastname())
		.username(accountDTO.getUsername())
		.password(accountDTO.getPassword())
		.roles(accountDTO.getRoles())
		.email(accountDTO.getEmail()).build();
		
		repository.save(account);
		
	
		
		return 	AccountMapper.AccountToAccountDTO(account);
	}


}
