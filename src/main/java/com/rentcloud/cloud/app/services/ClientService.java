/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.services;

import com.rentcloud.cloud.app.entities.Client;
import com.rentcloud.cloud.app.repositories.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yurany Amortegui
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    
    /**
     * GET
     * @return Lista de admin.
     */
    public List<Client> getAll(){
        return repository.getAll();
    }
    
    /**
     * GET/{id}
     * @param clientId
     * @return 
     */
    public Optional<Client> getClient(int clientId){
        return repository.getClient(clientId);
    }
    
    /**
     * POST
     * @param client
     * @return 
     */
    public Client save(Client client){
        //Consultar si se envía el ID
        if(client.getIdClient()==null){
            return repository.save(client);
        }else{
            //Consultar si existe el registro.
            Optional<Client> existClient = repository.getClient(client.getIdClient());
            if(existClient.isPresent()){
                return client;
            }else{
                return repository.save(client);
            }
        }
    }
    
    /**
     * UPDATE
     * @param client
     * @return 
     */
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> existClient = repository.getClient(client.getIdClient());
            if(existClient.isPresent()){
                if(client.getName()!=null){
                    existClient.get().setName(client.getName());
                }
                if(client.getEmail()!=null){
                    existClient.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    existClient.get().setPassword(client.getPassword());
                }
                if(client.getAge()!=null){
                    existClient.get().setAge(client.getAge());
                }
                return repository.save(existClient.get());
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    
    /**
     * DELETE
     * @param clientId
     * @return 
     */
    public boolean delete(int clientId){
        Boolean respuesta = getClient(clientId).map(client -> {
            repository.delete(client);
            return true;
        }).orElse(false);
        return respuesta;
    }
    
}
