/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.controllers;

import com.rentcloud.cloud.app.entities.Message;
import com.rentcloud.cloud.app.services.MessageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
 */
@RestController
@RequestMapping("Message")
public class MessageController {
    @Autowired
    private MessageService service;
    
 /**
  * GET
  * @return 
  */
    @GetMapping("/all")
    public List<Message> getMessage(){
        return service.getAll();
    }
    
    /**
     * 
     * @param messageId
     * @return 
     */
    @GetMapping("id")
    public Optional <Message> getMessage(@PathVariable("id") int messageId){
        return service.getMessage(messageId);
        }
    
    /**
     * POST
     * @param message
     * @return 
     */
       @PostMapping("/save")
       @ResponseStatus(HttpStatus.CREATED)
       public  Message save (@RequestBody Message message){
           return service.save (message);
       }
       /**
        * PUT
        * @param message
        * @return 
        */
       @PutMapping("/update")
       @ResponseStatus(HttpStatus.CREATED)
       public  Message update (@RequestBody Message message){
           return  service.update(message);
       }
       
       /**
        * DELETE
        * @param messageId
        * @return 
        */
       @DeleteMapping("/id")
       @ResponseStatus(HttpStatus.NO_CONTENT)
       public boolean delete (@PathVariable("id")  int messageId){
           return service.delete(messageId);
       }
    
}
