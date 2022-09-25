package com.nttdata.mybackend.services;

import java.util.List;
import java.util.Optional;

public interface ICrudService<T> {
  public T save(T t) throws Exception;
  public void deleteById(Integer id) throws Exception;
  public Optional<T> findById(Integer id) throws Exception;
  public List<T> findAll() throws Exception;
  public T update(Integer id, Object obj) throws Exception;
}
