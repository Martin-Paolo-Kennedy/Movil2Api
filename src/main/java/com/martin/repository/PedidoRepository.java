package com.martin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martin.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
