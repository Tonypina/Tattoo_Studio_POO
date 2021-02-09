/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;
import java.util.*;
/**
 *
 * @author Airam
 */
public class Ticket {
    private int id;
    private boolean clip;
    private boolean prod;
    private double subtotalTatuaje;
    private double subtotalPerforacion;
    private double total;
    private int dia;
    private int mes;
    private int anio;
    private Tatuador tatuador;
    private Proveedor perforador;
    private boolean visita;
    private ArrayList<Producto> productos;

    // Sobrecarga de constructor para base de datos

    public Ticket(int id, boolean clip, boolean prod, double subtotalTatuaje, double subtotalPerforacion, double total, int dia, int mes, int anio, Tatuador tatuador, Proveedor perforador, boolean visita, ArrayList<Producto> productos) {
        this.id = id;
        this.clip = clip;
        this.prod = prod;
        this.subtotalTatuaje = subtotalTatuaje;
        this.subtotalPerforacion = subtotalPerforacion;
        this.total = total;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.tatuador = tatuador;
        this.perforador = perforador;
        this.visita = visita;
        this.productos = productos;
    }

    public Ticket(boolean clip, boolean prod, double subtotalTatuaje, double subtotalPerforacion, double total, Tatuador tatuador, Proveedor perforador, boolean visita, ArrayList<Producto> productos) {
        this.clip = clip;
        this.prod = prod;
        this.subtotalTatuaje = subtotalTatuaje;
        this.subtotalPerforacion = subtotalPerforacion;
        this.total = total;
        this.tatuador = tatuador;
        this.perforador = perforador;
        this.visita = visita;
        this.productos = productos;
    }

    public boolean isVisita(){
        return visita;
    }
    
    public void setVisita(boolean visita){
        this.visita = visita;
    }

    public void setSubtotalTatuaje(double subtotalTatuaje) {
        this.subtotalTatuaje = subtotalTatuaje;
    }

    public void setSubtotalPerforacion(double subtotalPerforacion) {
        this.subtotalPerforacion = subtotalPerforacion;
    }

    public double getSubtotalTatuaje() {
        return subtotalTatuaje;
    }

    public double getSubtotalPerforacion() {
        return subtotalPerforacion;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }
    
    
    
    public int getId() {
        return id;
    }

    public boolean isClip() {
        return clip;
    }

    public boolean isProd() {
        return prod;
    }

   

    public double getTotal() {
        return total;
    }

    public Tatuador getTatuador() {
        return tatuador;
    }
    
    public Proveedor getPerforador(){
        return perforador;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClip(boolean clip) {
        this.clip = clip;
    }

    public void setProd(boolean prod) {
        this.prod = prod;
    }


    public void setTotal(double total) {
        this.total = total;
    }

    public void setTatuador(Tatuador tatuador) {
        this.tatuador = tatuador;
    }
    
    public void setPerforador(Proveedor perforador){
        this.perforador = perforador;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }}
