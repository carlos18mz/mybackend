package com.nttdata.mybackend.repositories;

import com.nttdata.mybackend.models.Movement;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovementRepository extends JpaRepository<Movement, Integer> {
  @Query(value = "from Movement m where m.date BETWEEN :startDate AND :endDate")
  public List<Movement> getAllBetweenDates(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
}
