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
    private Calendar fecha;
    private String nombreCliente;
    private float anticipo;
    private float precio;
    private int duración; //En minutos

    public Cita(Calendar fecha, String nombreCliente, float anticipo, float precio, int duración) {
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.anticipo = anticipo;
        this.precio = precio;
        this.duración = duración;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
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

    public Calendar getFecha() {
        return fecha;
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
