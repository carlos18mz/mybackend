package com.nttdata.mybackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nttdata.mybackend.models.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer> {
  
}
