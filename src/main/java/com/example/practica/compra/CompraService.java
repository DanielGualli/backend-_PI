package com.example.practica.compra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.practica.cliente.Cliente;

@Service
public class CompraService 
{
    @Autowired
    private CompraRepository compraRepository;

    //Para crear
    public Compra save(Compra entity)
    {
        return compraRepository.save(entity);
    }

    //Para seleccionar por id
    public Compra findById(Long id)
    {
        return compraRepository.findById(id).orElse(null);
    }

    //Para seleccionar todos los datos
    public List<Compra> findAll()
    {
        return compraRepository.findAll();
    }

    //Borrar por id
    public void deleteById(Long id)
    {
        compraRepository.deleteById(id);
    }

    //Actualizar parcialmente los campos
    public ResponseEntity<Compra> updateCompra(Long id, Compra entityActualizada)
    {
        try
        {
            Compra compraExistente =findById(id);

            if(compraExistente==null)
            {
                return ResponseEntity.notFound().build();
            }
            //Actualizar los campos correspondientes
            if(entityActualizada.getConcepto()!=null)
            {
                compraExistente.setConcepto(entityActualizada.getConcepto());
            }

            //Para el valor
            if(entityActualizada.getValor()!=0)
            {
                compraExistente.setValor(entityActualizada.getValor());
            }

            //Para la fecha
            if(entityActualizada.getFechaCompra()!=null)
            {
                compraExistente.setFechaCompra(entityActualizada.getFechaCompra());
            }

            //Guardar
            Compra compraGuardada = save(compraExistente);

            return ResponseEntity.ok(compraGuardada);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
