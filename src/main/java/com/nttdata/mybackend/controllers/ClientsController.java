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

import com.nttdata.mybackend.models.Client;
import com.nttdata.mybackend.resources.inputs.ClientInput;
import com.nttdata.mybackend.resources.outputs.ClientOutput;
import com.nttdata.mybackend.servicesImpl.ClientService;

@CrossOrigin
@RestController
@RequestMapping("/api/clients")
public class ClientsController {
  @Autowired
  private ClientService clientService;

  @PostMapping
  public ResponseEntity<?> createClient(@RequestBody ClientInput clientInput) {
    try {
      ClientOutput result = clientService.save(null, new Client(clientInput.getName(), clientInput.getGenre(), clientInput.getAge(), clientInput.getDirection(), clientInput.getPhone(), clientInput.getIdentification(), clientInput.getPassword(), clientInput.getState()));
      return new ResponseEntity<ClientOutput>(result, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
    }
  }

  @PutMapping("/{clientId}")
  public ResponseEntity<?> updateClient(@PathVariable(value = "clientId")int clientId, @RequestBody ClientInput clientInput) {
    try {
      ClientOutput result = clientService.update(clientId, clientInput);
      return new ResponseEntity<ClientOutput>(result, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
    }
  }

  @DeleteMapping("/{clientId}")
  public ResponseEntity<?> deleteClient(@PathVariable(value = "clientId")int clientId) {
    try {
      clientService.deleteById(clientId);
      return new ResponseEntity<>("success", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
    }
  }

  
}
