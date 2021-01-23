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
public class Tatuador {
    private int id;
    private String nombre;
    private String ap_pat;
    private String ap_mat;
    private String contacto;
    private double comision;
    private double total;

    public Tatuador(int id, String nombre, String ap_pat, String ap_mat, String contacto, double comision, double total) {
        this.id = id;
        this.nombre = nombre;
        this.ap_pat = ap_pat;
        this.ap_mat = ap_mat;
        this.contacto = contacto;
        this.comision = comision;
        this.total = total;
    }
    
    public int getId(){
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getAp_pat() {
        return ap_pat;
    }

    public String getAp_mat() {
        return ap_mat;
    }

    public String getContacto() {
        return contacto;
    }

    public double getComision() {
        return comision;
    }
    
    public double getTotal(){
        return total;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAp_pat(String ap_pat) {
        this.ap_pat = ap_pat;
    }

    public void setAp_mat(String ap_mat) {
        this.ap_mat = ap_mat;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
    
    public void setTotal(double Tatuador){
        this.tatuador = tatuador;
    }
}
