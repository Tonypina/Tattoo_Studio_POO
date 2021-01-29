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
public class Tatuador {
  private int id;
    private String nombre;
    private String ap_pat;
    private String ap_mat;
    private String contacto;
    private int rangoInt;
    private boolean Principal;
    private boolean Aprendiz;
    private boolean Secundario;
    public boolean[] RangoArr = new boolean [3];
    boolean[] Rango = {Principal, Aprendiz, Secundario};
    private double total;
  
    public Tatuador(String nombre, String ap_pat, String ap_mat, String contacto, int rangoInt, double total){
      this.nombre = nombre;
      this.ap_pat = ap_pat;
      this.ap_mat = ap_mat;
      this.contacto = contacto;
      this.total = total;
      this.rangoInt = rangoInt;
      switch (rangoInt) {
        case 1:
          this.Rango[0]=true;
          break;
        case 2:
          this.Rango[1]=true;
          break;
        case 3:
          this.Rango[2]=true;
          break;
      }
    }
    
    // Sobrecarga del contructor para la base de datos.
    public Tatuador(int id, String nombre, String ap_pat, String ap_mat, String contacto, int rangoInt, double total){
        this.id = id;
        this.nombre = nombre;
        this.ap_pat = ap_pat;
        this.ap_mat = ap_mat;
        this.contacto = contacto;
        this.total = total;
        this.rangoInt = rangoInt;
        switch (rangoInt) {
          case 1:
            this.Rango[0]=true;
            break;
          case 2:
            this.Rango[1]=true;
            break;
          case 3:
            this.Rango[2]=true;
            break;
        }
    }
    
    public double getTotal(){
        return total;
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
    
    public int getRango() {
        return rangoInt;
    }
    public void setTotal(double total){
        this.total = total;
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
    
    public void setRango(int rango) {
        this.rangoInt = rango;
    }
}
