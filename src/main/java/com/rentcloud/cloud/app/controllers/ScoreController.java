/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.controllers;

import com.rentcloud.cloud.app.entities.Score;
import com.rentcloud.cloud.app.services.ScoreService;
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
 */
@RestController
@RequestMapping("Score")
@CrossOrigin(origins = "*")
public class ScoreController {
    @Autowired
    private ScoreService service;
    
 /**
  * GET
  * @return 
  */
    @GetMapping("/all")
    public List<Score> getScore(){
        return service.getAll();
    }
    
    /**
     * GET
     * @param scoreId
     * @return 
     */
    @GetMapping("id")
    public Optional <Score> getScore(@PathVariable("id") int scoreId){
        return service.getScore(scoreId);
        }
    
    /**
     * POST
     * @param score
     * @return 
     */
       @PostMapping("/save")
       @ResponseStatus(HttpStatus.CREATED)
       public  Score save (@RequestBody Score score){
           return service.save (score);
       }
       /**
        * PUT
        * @param score
        * @return 
        */
       @PutMapping("/update")
       @ResponseStatus(HttpStatus.CREATED)
       public  Score update (@RequestBody Score score){
           return  service.update(score);
       }
       
       /**
        * DELETE
        * @param scoreId
        * @return 
        */
       @DeleteMapping("/id")
       @ResponseStatus(HttpStatus.NO_CONTENT)
       
       public boolean delete (@PathVariable("id")  int scoreId){
           return service.delete(scoreId);
       }
}
