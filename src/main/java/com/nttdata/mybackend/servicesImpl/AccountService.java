package com.nttdata.mybackend.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.mybackend.models.Account;
import com.nttdata.mybackend.models.Client;
import com.nttdata.mybackend.repositories.IAccountRepository;
import com.nttdata.mybackend.repositories.IClientRepository;
import com.nttdata.mybackend.resources.inputs.AccountInput;
import com.nttdata.mybackend.resources.outputs.AccountOutput;
import com.nttdata.mybackend.services.IAccountService;

@Service
public class AccountService implements IAccountService {

  @Autowired
  IAccountRepository accountRepository;

  @Autowired
  IClientRepository clientRepository;

  public AccountOutput save(Integer clientId,Account t) throws Exception {
    try {
      Client getClient = clientRepository.findById(clientId).get();
      if(getClient.getId()!=null) {
        t.setClient(getClient);
        return toAccountOutput(accountRepository.save(t));
      } else 
        throw new Exception("Client doesnt exists");
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public void deleteById(Integer id) throws Exception {
    try{ 
      accountRepository.deleteById(id);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public AccountOutput findById(Integer id) throws Exception {
    try{ 
      return toAccountOutput(accountRepository.findById(id).get());
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public List<AccountOutput> findAll() throws Exception {
    try{ 
      List<Account> getAccounts = accountRepository.findAll();
      List<AccountOutput> accountsOutput = new ArrayList<>();
      for (Account a:getAccounts) {
        accountsOutput.add(toAccountOutput(a));
      }
      return accountsOutput;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
    
  }

  public AccountOutput update(Integer id, Object obj) throws Exception {
    try{ 
      AccountInput accountData = (AccountInput) obj;
      Account getAccount = accountRepository.findById(id).get();
      getAccount.setAccountNumber(accountData.getAccountNumber());
      getAccount.setAccountType(accountData.getAccountType());
      getAccount.setInitialAmount(accountData.getInitialAmount());
      getAccount.setState(accountData.getState());
      return toAccountOutput(accountRepository.save(getAccount));
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
    
  }
  
  public AccountOutput toAccountOutput(Account a) {
    return new AccountOutput(a.getAccountNumber(), a.getAccountType(), a.getInitialAmount(), a.getState(), a.getClient().getName());
  }
}
