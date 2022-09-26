package com.nttdata.mybackend.servicesImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.mybackend.models.Account;
import com.nttdata.mybackend.models.Movement;
import com.nttdata.mybackend.repositories.IAccountRepository;
import com.nttdata.mybackend.repositories.IMovementRepository;
import com.nttdata.mybackend.resources.inputs.MovementInput;
import com.nttdata.mybackend.resources.outputs.MovementClientOutput;
import com.nttdata.mybackend.resources.outputs.MovementOutput;
import com.nttdata.mybackend.services.IMovementService;

@Service
public class MovementService implements IMovementService {

  @Autowired
  IMovementRepository movementRepository;

  @Autowired
  IAccountRepository accountRepository;

  public MovementOutput save(String accountNumber, Movement t) throws Exception {
   try {
    Account getAccount = accountRepository.findAccountByAccountNumber(accountNumber);
    if(getAccount.getId()!=null){
      if(t.getAmount() < 0 && getAccount.getInitialAmount() + t.getAmount() < 0)
        throw new Exception("Not enough balance");
      getAccount.setInitialAmount(getAccount.getInitialAmount() + t.getAmount());
      t.setAccount(getAccount);
      return toMovementOutput(movementRepository.save(t));
    } else {
      throw new Exception("Account doesnt exists");
    }
   } catch (Exception e) {
      throw new Exception(e.getMessage());
   }
  }

  public void deleteById(Integer id) throws Exception {
    try {
      movementRepository.deleteById(id);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public MovementOutput findById(Integer id) throws Exception {
    try {
      return toMovementOutput(movementRepository.findById(id).get());
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public List<MovementOutput> findAll() throws Exception {
    try {
      List<Movement> getMovements = movementRepository.findAll();
      List<MovementOutput> movementOutputs = new ArrayList<>();
      for (Movement m: getMovements) {
        movementOutputs.add(toMovementOutput(m));
      }
      return movementOutputs;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public List<MovementClientOutput> findByDates(Date from, Date to) throws Exception {
    try {
      List<Movement> getMovements = movementRepository.getAllBetweenDates(from, to);
      List<MovementClientOutput> movementOutputs = new ArrayList<>();
      for (Movement m: getMovements) {
        movementOutputs.add(new MovementClientOutput(
          m.getDate(), 
          m.getAccount().getClient().getName(), 
          m.getAccount().getAccountNumber(), 
          m.getAccount().getAccountType(),
          m.getAccount().getInitialAmount() - m.getAmount(),
          m.getAccount().getState(), 
          m.getAmount(), 
          m.getAccount().getInitialAmount()));
      }
      return movementOutputs;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public MovementOutput update(Integer id, Object obj) throws Exception {
    try {
      Movement movementData = (Movement) obj;
      Movement getMovement = movementRepository.findById(id).get();
      getMovement.setDate(movementData.getDate());
      getMovement.setType(movementData.getType());
      getMovement.setValue(movementData.getValue());
      getMovement.setAmount(movementData.getAmount());
      return toMovementOutput(movementRepository.save(getMovement));
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }
  
  public MovementOutput toMovementOutput(Movement m) {
    String movement = "";
    if(m.getAmount() > 0 )
      movement = String.format("Depósito de %s ", m.getAmount());
    else
      movement = String.format("Retiro de %s ", m.getAmount() * -1); 
    return new MovementOutput(m.getAccount().getAccountNumber(),m.getAccount().getAccountType(), m.getAccount().getInitialAmount(), m.getAccount().getState(), movement);
  }
}
