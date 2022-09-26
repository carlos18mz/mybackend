package com.nttdata.mybackend.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.mybackend.models.Client;
import com.nttdata.mybackend.repositories.IClientRepository;
import com.nttdata.mybackend.resources.inputs.ClientInput;
import com.nttdata.mybackend.resources.outputs.ClientOutput;
import com.nttdata.mybackend.services.IClientService;

@Service
public class ClientService implements IClientService {

  @Autowired
  IClientRepository clientRepository;

  public ClientOutput save(Integer id, Client t) throws Exception {
    try {
      return toClientOutput(clientRepository.save(t));
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public void deleteById(Integer id) throws Exception {
    try {
      clientRepository.deleteById(id);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public ClientOutput findById(Integer id) throws Exception {
    try {
      return toClientOutput(clientRepository.findById(id).get());
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public List<ClientOutput> findAll() throws Exception {
    try {
      List<Client> getClients = clientRepository.findAll();
      List<ClientOutput> clientOutputs = new ArrayList<>();
      for (Client c: getClients) {
        clientOutputs.add(toClientOutput(c));
      } 
      return clientOutputs;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
    
  }

  public ClientOutput update(Integer id, Object obj) throws Exception {
    try {
      ClientInput clientData = (ClientInput) obj;
      Client getClient = clientRepository.findById(id).get();
      getClient.setName(clientData.getName());
      getClient.setGenre(clientData.getGenre());
      getClient.setAge(clientData.getAge());
      getClient.setDirection(clientData.getDirection());
      getClient.setPhone(clientData.getPhone());
      getClient.setIdentification(clientData.getIdentification());
      getClient.setPassword(clientData.getPassword());
      getClient.setState(clientData.getState());
      return toClientOutput(clientRepository.save(getClient));
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  } 
  
  public ClientOutput toClientOutput(Client c) {
    return new ClientOutput(c.getName(), c.getDirection(), c.getPhone(), c.getPassword(), c.getState());
  }
}
