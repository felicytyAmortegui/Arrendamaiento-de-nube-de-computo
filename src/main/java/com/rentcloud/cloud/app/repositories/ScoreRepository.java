/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.Score;
import com.rentcloud.cloud.app.repositories.crud.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yurany Amortegui
 */
@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository repository;
    
          /**
     * SELECT * FROM
     * @return Retorna todos los registros de la tabla
     */
    public List<Score> getAll(){
        return (List<Score>) repository.findAll();
    }
    
    /**
     * SELECT * FROM TABLE WHERE ID=id
     * @param id
     * @return Retorna un registro por el ID
     */
    public Optional<Score> getScore(int id){
        return repository.findById(id);
    }
    
    
    /**
     * INSERT & UPDATE
     * @param score
     * @return Admin Actualiza registro ya existente o Crea un nuevo registro
     */
    public Score save(Score  score){
        return repository.save(score);
    }
    
    /**
     * DELETE FROM TABLE
     * @param score 
     */
    public void delete (Score score){
        repository.delete(score);
    }
    
}
