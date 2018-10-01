package com.programmer.gate.repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.domain.Models;;

public interface ModelRepo extends CrudRepository<Models, Integer> {

Optional<Models> findById(Integer id);
}
