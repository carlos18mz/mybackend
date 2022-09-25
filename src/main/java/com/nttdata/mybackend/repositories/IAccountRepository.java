package com.nttdata.mybackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.mybackend.models.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
  
}
