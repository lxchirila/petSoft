package com.vetsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vetsoft.entity.Pacient;

public interface PacientRepository extends JpaRepository<Pacient, Long> {
	@Query("SELECT p FROM Pacient p WHERE CONCAT(p.varsta, ' ',p.specie, ' ',p.sex, ' ',p.restante, ' ',p.nume, ' ', p.achitat, ' ', p.proprietar, ' ', p.rasa) LIKE %?1%")
	public List<Pacient> findAll(String keyword);
}
