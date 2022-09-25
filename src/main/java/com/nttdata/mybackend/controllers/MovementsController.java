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

import com.nttdata.mybackend.models.Movement;
import com.nttdata.mybackend.resources.inputs.MovementInput;
import com.nttdata.mybackend.servicesImpl.MovementService;

@CrossOrigin
@RestController
@RequestMapping("/api/movements")
public class MovementsController {

  @Autowired
  private MovementService movementService;

  @PostMapping
  public ResponseEntity<?> createMovement(@RequestBody MovementInput movementInput) {
    try {
      Movement result = movementService.save(new Movement(movementInput.getDate(), movementInput.getType(), movementInput.getValue(), movementInput.getAmount()));
      return new ResponseEntity<Movement>(result, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);

    }
  }

  @PutMapping("/{movementId}")
  public ResponseEntity<?> updateMovement(@PathVariable(value = "movementId")int movementId, @RequestBody MovementInput movementInput) {
    try {
      Movement result = movementService.update(movementId,movementInput);
      return new ResponseEntity<Movement>(result, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
    }
  }

  @DeleteMapping("/{movementId}")
  public ResponseEntity<?> deleteAccount(@PathVariable(value = "movementId")int movementId) {
    try {
      movementService.deleteById(movementId);
      return new ResponseEntity<>("success", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);

    }
  }
  
}
