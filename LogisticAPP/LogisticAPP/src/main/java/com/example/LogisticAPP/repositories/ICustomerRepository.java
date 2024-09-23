package com.example.LogisticAPP.repositories;

import com.example.LogisticAPP.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer>{
}
