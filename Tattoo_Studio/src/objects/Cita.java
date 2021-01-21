/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;
/**
 *
 * @author 
 */
public class Cita {
    private int diaInicio;
    private int mesInicio;
    private int anioInicio;
    private int diaFinal;
    private int mesFinal;
    private int anioFinal;
    private String nombreCliente;
    private float anticipo;
    private float precio;
    private int duración; //En minutos

    public Cita(int diaInicio, int mesInicio, int anioInicio, int diaFinal, int mesFinal, int anioFinal, String nombreCliente, float anticipo, float precio, int duración) {
        this.diaInicio = diaInicio;
        this.mesInicio = mesInicio;
        this.anioInicio = anioInicio;
        this.diaFinal = diaFinal;
        this.mesFinal = mesFinal;
        this.anioFinal = anioFinal;
        this.nombreCliente = nombreCliente;
        this.anticipo = anticipo;
        this.precio = precio;
        this.duración = duración;
    }

    public int getDiaInicio() {
        return diaInicio;
    }

    public int getMesInicio() {
        return mesInicio;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public int getDiaFinal() {
        return diaFinal;
    }

    public int getMesFinal() {
        return mesFinal;
    }

    public int getAnioFinal() {
        return anioFinal;
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

    public void setDiaInicio(int diaInicio) {
        this.diaInicio = diaInicio;
    }

    public void setMesInicio(int mesInicio) {
        this.mesInicio = mesInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    public void setDiaFinal(int diaFinal) {
        this.diaFinal = diaFinal;
    }

    public void setMesFinal(int mesFinal) {
        this.mesFinal = mesFinal;
    }

    public void setAnioFinal(int anioFinal) {
        this.anioFinal = anioFinal;
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
}