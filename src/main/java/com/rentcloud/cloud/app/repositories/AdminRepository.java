/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.Admin;
import com.rentcloud.cloud.app.repositories.crud.AdminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yurany Amortegui
 */

@Repository
public class AdminRepository{
    
    @Autowired
    private AdminCrudRepository repository;
    
    /**
     * SELECT * FROM
     * @return Retorna todos los registros de la tabla
     */
    public List<Admin> getAll(){
        return (List<Admin>) repository.findAll();
    }
    
    /**
     * SELECT * FROM TABLE WHERE ID=id
     * @param id
     * @return Retorna un registro por el ID
     */
    public Optional<Admin> getAdmin(int id){
        return repository.findById(id);
    }
    
    
    /**
     * INSERT & UPDATE
     * @param admin
     * @return Admin Actualiza registro ya existente o Crea un nuevo registro
     */
    public Admin save(Admin admin){
        return repository.save(admin);
    }
    
    /**
     * DELETE FROM TABLE
     * @param admin 
     */
    public void delete (Admin admin){
        repository.delete(admin);
    }
}

