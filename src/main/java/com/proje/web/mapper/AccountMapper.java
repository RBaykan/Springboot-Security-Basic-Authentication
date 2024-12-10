package com.proje.web.mapper;


import com.proje.web.entity.Account;
import com.proje.web.entityDTO.AccountDTO;



public class AccountMapper {
	
	public static Account AccountDTOToAccount(AccountDTO accountDTO) {
		
		return Account.builder()
				.id(accountDTO.getId())
				.firstname(accountDTO.getFirstname())
				.lastname(accountDTO.getLastname())
				.username(accountDTO.getUsername())
				.password(accountDTO.getPassword())
				.email(accountDTO.getEmail())
				.roles(accountDTO.getRoles())
				.createdAccountTime(accountDTO.getCreatedAccountTime())
				.build();
		
		
	}
	
	public static AccountDTO AccountToAccountDTO(Account account) {
		
		return AccountDTO.builder()
				.id(account.getId())
				.firstname(account.getFirstname())
				.lastname(account.getLastname())
				.username(account.getUsername())
				.password(account.getPassword())
				.email(account.getEmail())
				.roles(account.getRoles())
				.createdAccountTime(account.getCreatedAccountTime())
				.build();
		 
	}

}
