/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.controllers;

import com.rentcloud.cloud.app.entities.Category;
import com.rentcloud.cloud.app.services.CategoryService;
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
@RequestMapping("Category")
@CrossOrigin(origins = "*")
public class CategoryController {
    
     @Autowired
    private CategoryService service;
    
 /**
  * GET
  * @return 
  */
    @GetMapping("/all")
    public List<Category> getCategory(){
        return service.getAll();
    }
    
    /**
     * GET
     * @param categoryId
     * @return 
     */
    @GetMapping("id")
    public Optional <Category> getCategory(@PathVariable("id") int categoryId){
        return service.getCategory(categoryId);
        }
    
    /**
     * POST
     * @param category
     * @return 
     */
       @PostMapping("/save")
       @ResponseStatus(HttpStatus.CREATED)
       public  Category save (@RequestBody Category category){
           return service.save (category);
       }
       /**
        * PUT
        * @param category
        * @return 
        */
       @PutMapping("/update")
       @ResponseStatus(HttpStatus.CREATED)
       public  Category update (@RequestBody Category category){
           return  service.update(category);
       }
       
       /**
        * DELETE
        * @param categoryId
        * @return 
        */
       @DeleteMapping("/{id}")
       @ResponseStatus(HttpStatus.NO_CONTENT)
       public boolean delete (@PathVariable("id")  int categoryId){
           return service.delete(categoryId);
       }
    
}
