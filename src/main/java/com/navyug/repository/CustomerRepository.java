package com.navyug.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.navyug.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
