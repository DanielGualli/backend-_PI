package com.example.practica.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService 
{
    //Para hacer inyecciones de dependencias
    @Autowired
    private ClienteRepository clienteRepository;
    
    //Para guardar
    public Cliente save(Cliente entity)
    {
        return clienteRepository.save(entity);
    }

    //Select by id
    public Cliente findById(Long id)
    {
        return clienteRepository.findById(id).orElse(null);
    }

    //Borrar 
    public void deleteById(Long id)
    {
        clienteRepository.deleteById(id);
    }

    //Seleccionar todos
    public List<Cliente> findAll()
    {
        return clienteRepository.findAll();
    }

    //Actualizar parcialmente
    public ResponseEntity<Cliente> actualizarCliente(Long id, Cliente entityActualizada)
    {
        try
        {
            // Verificar si el id del cliente existe
            Cliente clienteExistente = findById(id);

            if (clienteExistente == null)
            {
                return ResponseEntity.notFound().build();
            }

            //Actualizar los campos correspondientes
            if(entityActualizada.getNombre()!=null)
            {
                clienteExistente.setNombre(entityActualizada.getNombre());
            }

            //Actualizar el apellido
            if(entityActualizada.getApellido()!=null)
            {
                clienteExistente.setApellido(entityActualizada.getApellido());
            }

            //Actualizar el enable
            if(entityActualizada.getEnable()!=null)
            {
                clienteExistente.setEnable(entityActualizada.getEnable());
            }

            //Guardar los cambios
            Cliente clienteGuardado = save(clienteExistente);

            return  ResponseEntity.ok(clienteGuardado);

        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }
}