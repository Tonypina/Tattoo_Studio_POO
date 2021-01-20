/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;
import java.util.*;
/**
 *
 * @author 
 */
public class Cita {
    private Calendar fechaInicio;
    private Calendar fechaFinal;
    private String nombreCliente;
    private float anticipo;
    private float precio;
    private int duración; //En minutos

    public Cita(Calendar fechaFinal, Calendar fechaInicio, String nombreCliente, float anticipo, float precio, int duración) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.nombreCliente = nombreCliente;
        this.anticipo = anticipo;
        this.precio = precio;
        this.duración = duración;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public void setFechaFinal(Calendar fechaFinal){
        this.fechaFinal = fechaFinal;
    }
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setAnticipo(float anticipo) {
        this.anticipo = anticipo;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setDuración(int duración) {
        this.duración = duración;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }
    
    public Calendar getFechaFinal() {
        return fechaFinal;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public float getAnticipo() {
        return anticipo;
    }

    public float getPrecio() {
        return precio;
    }

    public int getDuración() {
        return duración;
    }
}
