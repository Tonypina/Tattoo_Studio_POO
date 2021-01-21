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
    private int contatco;
    private float comision;

    public Tatuador(int id, String nombre, String ap_pat, String ap_mat, int contatco, float comision) {
        this.id = id;
        this.nombre = nombre;
        this.ap_pat = ap_pat;
        this.ap_mat = ap_mat;
        this.contatco = contatco;
        this.comision = comision;
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

    public int getContatco() {
        return contatco;
    }

    public float getComision() {
        return comision;
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

    public void setContatco(int contatco) {
        this.contatco = contatco;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }
}
