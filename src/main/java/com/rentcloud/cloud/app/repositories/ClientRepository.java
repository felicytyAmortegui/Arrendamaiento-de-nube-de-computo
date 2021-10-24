/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.Client;
import com.rentcloud.cloud.app.repositories.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yurany Amortegui
 */
@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository repository;
    
        /**
     * SELECT * FROM
     * @return Retorna todos los registros de la tabla
     */
    public List<Client> getAll(){
        return (List<Client>) repository.findAll();
    }
    
    /**
     * SELECT * FROM TABLE WHERE ID=id
     * @param id
     * @return Retorna un registro por el ID
     */
    public Optional<Client> getClient(int id){
        return repository.findById(id);
    }
    
    
    /**
     * INSERT & UPDATE
     * @param client
     * @return Admin Actualiza registro ya existente o Crea un nuevo registro
     */
    public Client save(Client  client){
        return repository.save(client);
    }
    
    /**
     * DELETE FROM TABLE
     * @param client 
     */
    public void delete (Client client){
        repository.delete(client);
    }
    
}
