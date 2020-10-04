package com.vetsoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetsoft.entity.Proprietar;
import com.vetsoft.repository.ProprietarRepository;

@Service
@Transactional
public class ProprietarService {
	@Autowired
	private ProprietarRepository repository;

	public List<Proprietar> listAll(String keyword) {
		if(keyword !=null ) {
			return repository.findAll(keyword);
		}
		return repository.findAll();
	}

	public void save(Proprietar proprietar) {
		repository.save(proprietar);
	}
	
	public Proprietar get(long id) {
		return repository.findById(id).get();
	}

	public void delete(long id) {
		repository.deleteById(id);

	}
}