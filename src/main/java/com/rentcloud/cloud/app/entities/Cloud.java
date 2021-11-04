/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Yurany Amortegui
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cloud")
public class Cloud implements Serializable {
    
    /**
     * Generacion de tipo de dato
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private Integer year;
    private String name;
    private String description;
    
    /**
     * Relacion muchas nubes pueden tener una categoria
     */
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("clouds")
    private Category category;
    
    /**
     * Relacion una nube, un cliente, pueden tener muchos mensajes
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cloud")
    @JsonIgnoreProperties({"cloud","client"})
    private List<Message> messages;
    
    /**
     * Relacion una nube puede tener muchas reservaciones
     */

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cloud")
    @JsonIgnoreProperties({"cloud","messages"})
    public List<Reservation> reservations;
}

