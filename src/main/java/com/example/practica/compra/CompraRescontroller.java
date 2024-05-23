package com.example.practica.compra;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/")
public class CompraRescontroller 
{
    
    //Inyeccion de dependencias
    @Autowired
    private CompraService compraService;

    //Para guardar
    @PostMapping(value = "compra")
    public Compra save(@RequestBody Compra entity)
    {
        return compraService.save(entity);
    }

    //Selec by id
    @GetMapping(value = "compra/{id}")
    public Compra findById(@PathVariable("id") Long id)
    {
        return compraService.findById(id);
    }

    //Selecc de todos
    @GetMapping(value = "compra")
    public List<Compra> findAll()
    {
        return compraService.findAll();
    }

    //Para borrar
    @DeleteMapping(value = "compra/{id}")
    public void deleteById(@PathVariable("id") Long id)
    {
        compraService.deleteById(id);
    }

    //Actualizar por campos
    @PutMapping(value = "compra/{id}")
    public ResponseEntity<Compra> updateCompra(@PathVariable("id") Long id, @RequestBody Compra entity)
    {
        return compraService.updateCompra(id, entity);
    }
}
