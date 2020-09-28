package com.vetsoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetsoft.entity.Pacient;
import com.vetsoft.repository.PacientRepository;

@Service
@Transactional
public class PacientService {
	@Autowired
	private PacientRepository repository;

	public List<Pacient> listAll(String keyword) {
		if (keyword != null) {
			return repository.findAll(keyword);
		}
		return repository.findAll();
	}

	public void save(Pacient pacient) {
		repository.save(pacient);
	}

	public Pacient get(long id) {
		return repository.findById(id).get();
	}

	public void delete(long id) {
		repository.deleteById(id);

	}
}