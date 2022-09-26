package com.nttdata.mybackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nttdata.mybackend.models.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
  @Query("select a from Account a where a.accountNumber = (:accountNumber)")
  Account findAccountByAccountNumber(@Param("accountNumber") String accountNumber);

}
