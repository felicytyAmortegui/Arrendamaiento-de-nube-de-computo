/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.services;

import com.rentcloud.cloud.app.entities.Admin;
import com.rentcloud.cloud.app.repositories.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yurany Amortegui
 */
@Service
public class AdminService {
    
   @Autowired
    private AdminRepository repository;
    
    /**
     * GET
     * @return Lista de admin.
     */
    public List<Admin> getAll(){
        return repository.getAll();
    }
    
    /**
     * GET/{id}
     * @param adminId
     * @return 
     */
    public Optional<Admin> getAdmin(int adminId){
        return repository.getAdmin(adminId);
    }
    
    /**
     * POST
     * @param admin
     * @return 
     */
    public Admin save(Admin admin){
        //Consultar si se envía el ID
        if(admin.getIdAdmin()==null){
            return repository.save(admin);
        }else{
            //Consultar si existe el registro.
            Optional<Admin> existAdmin = repository.getAdmin(admin.getIdAdmin());
            if(existAdmin.isPresent()){
                return admin;
            }else{
                return repository.save(admin);
            }
        }
    }
    
    /**
     * UPDATE
     * @param admin
     * @return 
     */
    public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin> existAdmin = repository.getAdmin(admin.getIdAdmin());
            if(existAdmin.isPresent()){
                if(admin.getName()!=null){
                    existAdmin.get().setName(admin.getName());
                }
                if(admin.getEmail()!=null){
                    existAdmin.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    existAdmin.get().setPassword(admin.getPassword());
                }
                return repository.save(existAdmin.get());
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }
    
    /**
     * DELETE
     * @param adminId
     * @return 
     */
    public boolean delete(int adminId){
        Boolean respuesta = getAdmin(adminId).map(admin -> {
            repository.delete(admin);
            return true;
        }).orElse(false);
        return respuesta;
    }
    
}

