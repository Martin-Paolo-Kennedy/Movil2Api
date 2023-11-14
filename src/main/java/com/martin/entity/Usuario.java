package com.martin.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private String correo;
	private String nomUsu;
	private String pass;

}
