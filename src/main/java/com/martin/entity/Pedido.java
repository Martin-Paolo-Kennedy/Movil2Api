package com.martin.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date fechaCreacion;
	
	@ManyToOne
    @JoinColumn(name = "orden_id" )
    private Orden orden;

    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;
}
