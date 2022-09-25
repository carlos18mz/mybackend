package com.nttdata.mybackend.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.mybackend.models.Client;
import com.nttdata.mybackend.repositories.IClientRepository;
import com.nttdata.mybackend.resources.inputs.ClientInput;
import com.nttdata.mybackend.services.IClientService;

@Service
public class ClientService implements IClientService {

  @Autowired
  IClientRepository clientRepository;

  @Override
  public Client save(Client t) throws Exception {
    return clientRepository.save(t);
  }

  @Override
  public void deleteById(Integer id) throws Exception {
    clientRepository.deleteById(id);
  }

  @Override
  public Optional<Client> findById(Integer id) throws Exception {
    return clientRepository.findById(id);
  }

  @Override
  public List<Client> findAll() throws Exception {
    return clientRepository.findAll();
  }

  @Override
  public Client update(Integer id, Object obj) throws Exception {
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
    return clientRepository.save(getClient);
  } 
  
}
