/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.Message;
import com.rentcloud.cloud.app.repositories.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yurany Amortegui
 */
@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository repository;
    
        /**
     * SELECT * FROM
     * @return Retorna todos los registros de la tabla
     */
    public List<Message> getAll(){
        return (List<Message>) repository.findAll();
    }
    
    /**
     * SELECT * FROM TABLE WHERE ID=id
     * @param id
     * @return Retorna un registro por el ID
     */
    public Optional<Message> getMessage(int id){
        return repository.findById(id);
    }
    
    
    /**
     * INSERT & UPDATE
     * @param message
     * @return Admin Actualiza registro ya existente o Crea un nuevo registro
     */
    public Message save(Message  message){
        return repository.save(message);
    }
    
    /**
     * DELETE FROM TABLE
     * @param message 
     */
    public void delete (Message message){
        repository.delete(message);
    }
}
