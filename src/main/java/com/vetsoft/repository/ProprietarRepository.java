package com.vetsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vetsoft.entity.Proprietar;

public interface ProprietarRepository extends JpaRepository<Proprietar,Long>{
@Query("SELECT p FROM Proprietar p WHERE CONCAT(p.nume, ' ', p.telefon, ' ', p.email, ' ', p.restante) LIKE %?1%")
		
		
	public List<Proprietar>findAll(String keyword);
}
