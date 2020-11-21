package com.navyug.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.navyug.model.Account;

@Repository
public interface AccountRepo extends CrudRepository<Account, Integer> {

}
