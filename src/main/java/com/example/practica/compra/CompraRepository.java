package com.example.practica.compra;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CompraRepository extends CrudRepository<Compra, Long>
{
    List<Compra> findAll();    
}
