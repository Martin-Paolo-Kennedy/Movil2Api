package com.martin.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "plato")
public class Plato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String descripcion;
	private Double precio;
	
}
