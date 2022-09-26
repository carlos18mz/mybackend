package com.nttdata.mybackend.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.mybackend.models.Movement;
import com.nttdata.mybackend.resources.inputs.MovementInput;
import com.nttdata.mybackend.resources.outputs.MovementClientOutput;
import com.nttdata.mybackend.resources.outputs.MovementOutput;
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
      Date d = new Date();
      MovementOutput result = movementService.save(movementInput.getAccountNumber(), new Movement(d, movementInput.getType(), movementInput.getValue(), movementInput.getAmount()));
      return new ResponseEntity<MovementOutput>(result, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);

    }
  }

  @PutMapping("/{movementId}")
  public ResponseEntity<?> updateMovement(@PathVariable(value = "movementId")int movementId, @RequestBody MovementInput movementInput) {
    try {
      MovementOutput result = movementService.update(movementId,movementInput);
      return new ResponseEntity<MovementOutput>(result, HttpStatus.OK);
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

  @GetMapping("/reports")
  public ResponseEntity<?> findByDates(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate, @RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate) {
    try {
      List<MovementClientOutput> result = movementService.findByDates(fromDate, toDate);
      return new ResponseEntity<List<MovementClientOutput>>(result, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
    }
  }

}
