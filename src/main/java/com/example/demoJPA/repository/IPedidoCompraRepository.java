package com.example.demoJPA.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoJPA.entity.PedidoCompra;

public interface IPedidoCompraRepository extends JpaRepository<PedidoCompra, Serializable> {

}
