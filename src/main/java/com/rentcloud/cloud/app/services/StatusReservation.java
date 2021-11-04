/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.services;

/**
 *
 * @author User
 */
public class StatusReservation {
    private int completed;
    private int cancelled;

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

    public StatusReservation(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }
}
