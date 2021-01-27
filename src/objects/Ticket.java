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
public class Ticket {
    private int id;
    private boolean clip;
    private boolean prod;
    private double anticipo;
    private double total;
    private Tatuador tatuador;
    private Producto compra;
    private boolean visita;
    

    public Ticket(int id, boolean clip, boolean prod, double anticipo, double total, Tatuador tatuador, Producto compra) {
        this.id = id;
        this.clip = clip;
        this.prod = prod;
        this.anticipo = anticipo;
        this.total = total;
        this.tatuador = tatuador;
        this.compra = compra;
    }

    // Sobrecarga de constructor para la Base de Datos.
    public Ticket(boolean clip, boolean prod, double anticipo, double total, Tatuador tatuador, Producto compra) {
        this.clip = clip;
        this.prod = prod;
        this.anticipo = anticipo;
        this.total = total;
        this.tatuador = tatuador;
        this.compra = compra;
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

    public double getAnticipo() {
        return anticipo;
    }

    public double getTotal() {
        return total;
    }

    public Tatuador getTatuador() {
        return tatuador;
    }

    public Producto getCompra() {
        return compra;
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

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTatuador(Tatuador tatuador) {
        this.tatuador = tatuador;
    }

    public void setCompra(Producto compra) {
        this.compra = compra;
    }
}
