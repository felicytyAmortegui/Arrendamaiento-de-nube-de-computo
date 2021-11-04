/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.services;

import com.rentcloud.cloud.app.entities.Reservation;
import com.rentcloud.cloud.app.repositories.CountClient;
import com.rentcloud.cloud.app.repositories.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yurany Amortegui
 *
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    /**
     * GET
     *
     * @return Lista de admin.
     */
    public List<Reservation> getAll() {
        return repository.getAll();
    }

    /**
     * GET/{id}
     *
     * @param reservationId
     * @return
     */
    public Optional<Reservation> getReservation(int reservationId) {
        return repository.getReservation(reservationId);
    }

    /**
     * POST
     *
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation) {
        //Consultar si se envía el ID
        if (reservation.getIdReservation() == null) {
            return repository.save(reservation);
        } else {
            //Consultar si existe el registro.
            Optional<Reservation> existReservation = repository.getReservation(reservation.getIdReservation());
            if (existReservation.isPresent()) {
                return reservation;
            } else {
                return repository.save(reservation);
            }
        }
    }

    /**
     * UPDATE
     *
     * @param reservation
     * @return
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> existReservation = repository.getReservation(reservation.getIdReservation());
            if (existReservation.isPresent()) {
                if (reservation.getStartDate() != null) {
                    existReservation.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    existReservation.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    existReservation.get().setStatus(reservation.getStatus());
                }
                return repository.save(existReservation.get());
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * DELETE
     *
     * @param reservationId
     * @return
     */
    public boolean delete(int reservationId) {
        Boolean respuesta = getReservation(reservationId).map(reservation -> {
            repository.delete(reservation);
            return true;
        }).orElse(false);
        return respuesta;
    }

    /**
     * Metodo publico para generar el status de las reservaciones.
     * @return 
     */
    public StatusReservation getReservationsStatusReport() {
        List<Reservation> completed = repository.getReservationByStatus("completed");
        List<Reservation> cancelled = repository.getReservationByStatus("cancelled");
        return new StatusReservation(completed.size(), cancelled.size());
    }

    /**
     * Metodo para mostrar la fecha de feservacion.
     * @param dateA
     * @param dateB
     * @return 
     */
    public List<Reservation> getReservationPeriod(String dateA, String dateB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date aDate = new Date();
        Date bDate = new Date();

        try {
            aDate = parser.parse(dateA);
            bDate = parser.parse(dateB);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (aDate.before(bDate)) {
            return repository.getReservationPeriod(aDate, bDate);
        } else {
            return new ArrayList<>();
        }

    }
/**
 * Metodo para mostrar la lista top client.
 * @return 
 */
    public List<CountClient> getTopClients() {
        return repository.getTopClients();
    }

}
