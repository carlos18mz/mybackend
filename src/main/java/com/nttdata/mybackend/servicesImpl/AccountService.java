package com.nttdata.mybackend.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.mybackend.models.Account;
import com.nttdata.mybackend.repositories.IAccountRepository;
import com.nttdata.mybackend.resources.inputs.AccountInput;
import com.nttdata.mybackend.services.IAccountService;

@Service
public class AccountService implements IAccountService {

  @Autowired
  IAccountRepository accountRepository;

  @Override
  public Account save(Account t) throws Exception {
    return accountRepository.save(t);
  }

  @Override
  public void deleteById(Integer id) throws Exception {
    accountRepository.deleteById(id);
  }

  @Override
  public Optional<Account> findById(Integer id) throws Exception {
    return accountRepository.findById(id);
  }

  @Override
  public List<Account> findAll() throws Exception {
    return accountRepository.findAll();
  }

  @Override
  public Account update(Integer id, Object obj) throws Exception {
    AccountInput accountData = (AccountInput) obj;
    Account getAccount = accountRepository.findById(id).get();
    getAccount.setAccountNumber(accountData.getAccountNumber());
    getAccount.setAccountType(accountData.getAccountType());
    getAccount.setInitialAmount(accountData.getInitialAmount());
    getAccount.setState(accountData.getState());
    return accountRepository.save(getAccount);
  }
  
}
