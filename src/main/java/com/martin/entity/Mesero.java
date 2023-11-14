package com.martin.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mesero")
public class Mesero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellido;
	private Date fechaContratacion;
	private int edad;
	
	
}
