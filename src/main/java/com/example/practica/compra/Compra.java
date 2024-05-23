package com.example.practica.compra;


import java.util.Date;

import com.example.practica.cliente.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Compra 
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String concepto;
    private float valor;
    private Date fechaCompra;     

    @ManyToOne Cliente cliente; 
}    

