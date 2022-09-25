package com.nttdata.mybackend.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.mybackend.models.Movement;
import com.nttdata.mybackend.repositories.IMovementRepository;
import com.nttdata.mybackend.resources.inputs.MovementInput;
import com.nttdata.mybackend.services.IMovementService;

@Service
public class MovementService implements IMovementService {

  @Autowired
  IMovementRepository movementRepository;

  @Override
  public Movement save(Movement t) throws Exception {
    return movementRepository.save(t);
  }

  @Override
  public void deleteById(Integer id) throws Exception {
    movementRepository.deleteById(id);
  }

  @Override
  public Optional<Movement> findById(Integer id) throws Exception {
    return movementRepository.findById(id);
  }

  @Override
  public List<Movement> findAll() throws Exception {
    return movementRepository.findAll();
  }

  @Override
  public Movement update(Integer id, Object obj) throws Exception {
    MovementInput movementData = (MovementInput) obj;
    Movement getMovement = movementRepository.findById(id).get();
    getMovement.setDate(movementData.getDate());
    getMovement.setType(movementData.getType());
    getMovement.setValue(movementData.getValue());
    getMovement.setAmount(movementData.getAmount());
    return movementRepository.save(getMovement);
  }
  
}
