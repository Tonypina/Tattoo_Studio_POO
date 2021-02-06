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
    private int dia;
    private int mes;
    private int anio;
    private int idTatuador;

    public Cita(int id, String nombreCliente, int dia, int mes, int anio, int idTatuador) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.idTatuador = idTatuador;
    }
    
    // Sobrecarga de constructor para la base de datos.
    public Cita(String nombreCliente, int dia, int mes, int anio, int idTatuador) {
        this.nombreCliente = nombreCliente;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
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
        return dia;
    }

    public int getMesInicio() {
        return mes;
    }

    public int getAnioInicio() {
        return anio;
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

    public void setDiaInicio(int dia) {
        this.dia = dia;
    }

    public void setMesInicio(int mes) {
        this.mes = mes;
    }

    public void setAnioInicio(int anio) {
        this.anio = anio;
    }

}
