package com.nttdata.mybackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.mybackend.models.Account;
import com.nttdata.mybackend.resources.inputs.AccountInput;
import com.nttdata.mybackend.resources.outputs.AccountOutput;
import com.nttdata.mybackend.servicesImpl.AccountService;

@CrossOrigin
@RestController
@RequestMapping("/api/accounts")
public class AccountsController {
  
  @Autowired
  private AccountService accountService;

  //Crear editar actualizar eliminar
  @PostMapping
  public ResponseEntity<?> createAccount(@RequestBody AccountInput accountInput) {
    try {
      AccountOutput result = accountService.save(accountInput.getClientId(), new Account(accountInput.getAccountNumber(), accountInput.getAccountType(), accountInput.getInitialAmount(), accountInput.getState()));
      return new ResponseEntity<AccountOutput>(result, HttpStatus.OK);
    } catch(Exception e){
      return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
    }
  }

  @PutMapping("/{accountId}")
  public ResponseEntity<?> updateAccount(@PathVariable(value = "accountId")int accountId, @RequestBody AccountInput accountInput) {
    try {
      AccountOutput result = accountService.update(accountId, accountInput);
      return new ResponseEntity<AccountOutput>(result, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
    }
  }

  @DeleteMapping("/{accountId}")
  public ResponseEntity<?> deleteAccount(@PathVariable(value = "accountId")int accountId) {
    try {
      accountService.deleteById(accountId);
      return new ResponseEntity<>("success", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
    }
  }

 
}
