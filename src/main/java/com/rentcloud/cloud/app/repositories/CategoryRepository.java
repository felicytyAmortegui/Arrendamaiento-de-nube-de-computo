/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.Category;
import com.rentcloud.cloud.app.repositories.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yurany Amortegui
 */
@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository repository;
    
    /**
     * SELECT * FROM
     * @return Retorna todos los registros de la tabla
     */
    public List<Category> getAll(){
        return (List<Category>) repository.findAll();
    }
    
    /**
     * SELECT * FROM TABLE WHERE ID=id
     * @param id
     * @return Retorna un registro por el ID
     */
    public Optional<Category> getCategory(int id){
        return repository.findById(id);
    }
    
    
    /**
     * INSERT & UPDATE
     * @param category
     * @return Admin Actualiza registro ya existente o Crea un nuevo registro
     */
    public Category save(Category  category){
        return repository.save(category);
    }
    
    /**
     * DELETE FROM TABLE
     * @param category 
     */
    public void delete (Category category){
        repository.delete(category);
    }
    
}
