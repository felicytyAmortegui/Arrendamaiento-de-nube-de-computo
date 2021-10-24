/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.services;

import com.rentcloud.cloud.app.entities.Score;
import com.rentcloud.cloud.app.repositories.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yurany Amortegui
 */
@Service
public class ScoreService {
        @Autowired
    private ScoreRepository repository;
    
    /**
     * GET
     * @return Lista de admin.
     */
    public List<Score> getAll(){
        return repository.getAll();
    }
    
    /**
     * GET/{id}
     * @param scoreId
     * @return 
     */
    public Optional<Score> getScore(int scoreId){
        return repository.getScore(scoreId);
    }
    
    /**
     * POST
     * @param score
     * @return 
     */
    public Score save(Score score){
        //Consultar si se envía el ID
        if(score.getIdScore()==null){
            return repository.save(score);
        }else{
            //Consultar si existe el registro.
            Optional<Score> existScore = repository.getScore(score.getIdScore());
            if(existScore.isPresent()){
                return score;
            }else{
                return repository.save(score);
            }
        }
    }
    
    /**
     * UPDATE
     * @param score
     * @return 
     */
    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> existScore = repository.getScore(score.getIdScore());
            if(existScore.isPresent()){
                if(score.getMessageText()!=null){
                    existScore.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null){
                    existScore.get().setStars(score.getStars());
                }
                
                return repository.save(existScore.get());
            }else{
                return score;
            }
        }else{
            return score;
        }
    }
    
    /**
     * DELETE
     * @param scoreId
     * @return 
     */
    public boolean delete(int scoreId){
        Boolean respuesta = getScore(scoreId).map(score -> {
            repository.delete(score);
            return true;
        }).orElse(false);
        return respuesta;
    }
    
}
