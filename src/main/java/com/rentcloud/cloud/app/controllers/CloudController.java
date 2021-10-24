/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.controllers;

import com.rentcloud.cloud.app.entities.Cloud;
import com.rentcloud.cloud.app.services.CloudService;
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
 * @author Yrany Amortegui
 */
@RestController
@RequestMapping("Cloud")
public class CloudController {
    
     @Autowired
    private CloudService service;
    
 /**
  * GET
  * @return 
  */
    @GetMapping("/all")
    public List<Cloud> getCloud(){
        return service.getAll();
    }
    
    /**
     * 
     * @param cloudId
     * @return 
     */
    @GetMapping("id")
    public Optional <Cloud> getCloud(@PathVariable("id") int cloudId){
        return service.getCloud(cloudId);
        }
    
    /**
     * POST
     * @param cloud
     * @return 
     */
       @PostMapping("/save")
       @ResponseStatus(HttpStatus.CREATED)
       public  Cloud save (@RequestBody Cloud cloud){
           return service.save (cloud);
       }
       /**
        * PUT
        * @param cloud
        * @return 
        */
       @PutMapping("/update")
       @ResponseStatus(HttpStatus.CREATED)
       public  Cloud update (@RequestBody Cloud cloud){
           return  service.update(cloud);
       }
       /**
        * DELETE
        * @param cloudId
        * @return 
        */
       @DeleteMapping("/id")
       @ResponseStatus(HttpStatus.NO_CONTENT)
       public boolean delete (@PathVariable("id")  int cloudId){
           return service.delete(cloudId);
       }
    
}
