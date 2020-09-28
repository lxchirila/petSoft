package com.vetsoft.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "pacienti")
public class Pacient {
	@Id
	@GeneratedValue
	private Long id;
	private String nume;
	private String specie;
	private String rasa;
	private String sex;
	private int varsta;
	private String proprietar;
	private double achitat;
	private double restante;
}
