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
    private double pagado;
    private double total;
    private Tatuador tatuador;
    private boolean visita;
    private double cambio;
    private ArrayList<Producto> productos;
    

    public Ticket(int id, boolean clip, boolean prod, double pagado, double total, Tatuador tatuador, boolean visita, double cambio, ArrayList<Producto> productos) {
        this.id = id;
        this.clip = clip;
        this.prod = prod;
        this.pagado = pagado;
        this.total = total;
        this.tatuador = tatuador;
        this.visita = visita;
        this.cambio = cambio;
        this.productos = productos;
    }

    // Sobrecarga de constructor para la Base de Datos.
    public Ticket(boolean clip, boolean prod, double pagado, double total, Tatuador tatuador, boolean visita, double cambio, ArrayList<Producto> productos) {
        this.clip = clip;
        this.prod = prod;
        this.pagado = pagado;
        this.total = total;
        this.tatuador = tatuador;
        this.visita = visita;
        this.cambio = cambio;
        this.productos = productos;
    }

    public boolean isVisita(){
        return visita;
    }
    
    public void setVisita(boolean visita){
        this.visita = visita;
    }
    
    public double getCambio(){
        return cambio;
    }
    
    public void setCambio(double cambio){
        this.cambio = cambio;
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

    public double getPagado() {
        return pagado;
    }

    public double getTotal() {
        return total;
    }

    public Tatuador getTatuador() {
        return tatuador;
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

    public void setPagado(double pagado) {
        this.pagado = pagado;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTatuador(Tatuador tatuador) {
        this.tatuador = tatuador;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }}
