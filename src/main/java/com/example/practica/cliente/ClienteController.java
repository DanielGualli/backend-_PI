package com.example.practica.cliente;


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
@RequestMapping(value ="/api/")
@Tag(name="Controller de cliente")
public class ClienteController 
{
    @Autowired 
    private ClienteService clienteService;
    
    //Metodo para guardar
    @PostMapping(value = "cliente")
    @Operation(sumary = "Guarda un cliente")
    public Cliente save(@RequestBody Cliente entity)
    {
        return clienteService.save(entity);
    }

    //Para Seleccionar por id
    @GetMapping(value = "cliente/{id}")
    public Cliente findById(@PathVariable("id") Long id)
    {
        return clienteService.findById(id);
    }

    //Borrado por id
    @DeleteMapping(value = "cliente/{id}")
    public void deleteById(@PathVariable("id") Long id)
    {
        clienteService.deleteById(id);
    }

    //Seleccionar todos
    @GetMapping(value = "cliente")
    public List<Cliente> findById()
    {
        return clienteService.findAll();
    }

    //Actualizacion parcial
    @PutMapping(value = "cliente/{id}" )
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente entity)
    {
        return clienteService.actualizarCliente(id, entity);
    }

}