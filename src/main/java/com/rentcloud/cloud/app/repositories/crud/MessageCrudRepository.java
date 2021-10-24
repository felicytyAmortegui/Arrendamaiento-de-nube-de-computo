/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.repositories.crud;

import com.rentcloud.cloud.app.entities.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Yurany Amortegui
 */
public interface MessageCrudRepository extends CrudRepository<Message,Integer>{
    
}
