package com.martin.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orden")
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int cantidad;
	private String nota;
	private Double precioTotal;
	
	@ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name = "idPlato")
    private Plato plato;

    
}
