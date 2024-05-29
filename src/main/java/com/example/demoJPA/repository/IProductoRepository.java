package com.example.demoJPA.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoJPA.entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Serializable> {

}
