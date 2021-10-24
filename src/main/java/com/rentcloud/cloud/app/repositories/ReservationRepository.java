/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.Reservation;
import com.rentcloud.cloud.app.repositories.crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yurany Amortegui
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository repository;
    
        /**
     * SELECT * FROM
     * @return Retorna todos los registros de la tabla
     */
    public List<Reservation> getAll(){
        return (List<Reservation>) repository.findAll();
    }
    
    /**
     * SELECT * FROM TABLE WHERE ID=id
     * @param id
     * @return Retorna un registro por el ID
     */
    public Optional<Reservation> getReservation(int id){
        return repository.findById(id);
    }
    
    
    /**
     * INSERT & UPDATE
     * @param reservation
     * @return Admin Actualiza registro ya existente o Crea un nuevo registro
     */
    public Reservation save(Reservation  reservation){
        return repository.save(reservation);
    }
    
    /**
     * DELETE FROM TABLE
     * @param reservation 
     */
    public void delete (Reservation reservation){
        repository.delete(reservation);
    }
    
}
