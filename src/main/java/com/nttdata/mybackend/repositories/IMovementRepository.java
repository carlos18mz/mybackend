package com.nttdata.mybackend.repositories;

import com.nttdata.mybackend.models.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovementRepository extends JpaRepository<Movement, Integer> {
  
}
