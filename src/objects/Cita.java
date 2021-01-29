/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author Airam
 */
public class Cita {
 private int id;
    private String nombreCliente;
    private int diaInicio;
    private int mesInicio;
    private int anioInicio;
    private int diaFinal;
    private int mesFinal;
    private int anioFinal;
    private int idTatuador;

    public Cita(int id, String nombreCliente, int diaInicio, int mesInicio, int anioInicio, int diaFinal, int mesFinal, int anioFinal, int idTatuador) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.diaInicio = diaInicio;
        this.mesInicio = mesInicio;
        this.anioInicio = anioInicio;
        this.diaFinal = diaFinal;
        this.mesFinal = mesFinal;
        this.anioFinal = anioFinal;
        this.idTatuador = idTatuador;
    }
    
    // Sobrecarga de constructor para la base de datos.
    public Cita(String nombreCliente, int diaInicio, int mesInicio, int anioInicio, int diaFinal, int mesFinal, int anioFinal, int idTatuador) {
        this.nombreCliente = nombreCliente;
        this.diaInicio = diaInicio;
        this.mesInicio = mesInicio;
        this.anioInicio = anioInicio;
        this.diaFinal = diaFinal;
        this.mesFinal = mesFinal;
        this.anioFinal = anioFinal;
        this.idTatuador = idTatuador;
    }

    public int getIdTatuador(){
        return idTatuador;
    }
    
    public int getIdCita() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
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

    public void setIdTatuador(int idTatuador){
        this.idTatuador = idTatuador;
    }
    
    public void setIdCita(int id) {
        this.id = id;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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
    
}
