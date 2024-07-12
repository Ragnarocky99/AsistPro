package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.domain.Individuo;

public interface IndividuoDao extends CrudRepository<Individuo, Long> {
}
