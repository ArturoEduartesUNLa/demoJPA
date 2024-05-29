package com.example.demoJPA.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoJPA.entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Serializable> {

}
