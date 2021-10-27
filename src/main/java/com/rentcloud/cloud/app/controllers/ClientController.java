/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.controllers;

import com.rentcloud.cloud.app.entities.Client;
import com.rentcloud.cloud.app.services.ClientService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yurany Amortegui
 * 
 */
@RestController
@RequestMapping ("Client")
@CrossOrigin(origins = "*")
public class ClientController {
    
    @Autowired
    private ClientService service;
    
 /**
  * GET
  * @return 
  */
    @GetMapping("/all")
    public List<Client> getClient(){
        return service.getAll();
    }
    
    /**
     * 
     * @param clientId
     * @return 
     */
    @GetMapping("id")
    public Optional <Client> getClient(@PathVariable("id") int clientId){
        return service.getClient(clientId);
        }
    
    /**
     * POST
     * @param client
     * @return 
     */
       @PostMapping("/save")
       @ResponseStatus(HttpStatus.CREATED)
       public  Client save (@RequestBody Client client){
           return service.save (client);
       }
       /**
        * PUT
        * @param client
        * @return 
        */
       @PutMapping("/update")
       @ResponseStatus(HttpStatus.CREATED)
       public  Client update (@RequestBody Client client){
           return  service.update(client);
       }
       
       @DeleteMapping("/{id}")
       @ResponseStatus(HttpStatus.NO_CONTENT)
       public boolean delete (@PathVariable("id")  int clientId){
           return service.delete(clientId);
       }
    
}
