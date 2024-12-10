package com.proje.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proje.web.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Long> {
	 Optional<Account> findByUsername(String username);
}
