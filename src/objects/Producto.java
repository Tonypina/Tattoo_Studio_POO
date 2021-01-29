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
public class Producto {
 private int idPro;
    private String modeloPro;
    private String tipoPro;
    private int cantidadPro;
    private double precioPro;
    private Proveedor proveedor;
    
    public Producto(int idPro, String modeloPro, String tipoPro, int cantidadPro, double precioPro, Proveedor proveedor){
        this.idPro = idPro;
        this.modeloPro = modeloPro;
        this.tipoPro = tipoPro;
        this.cantidadPro = cantidadPro;
        this.precioPro = precioPro;
        this.proveedor = proveedor;  
    }
    
    public void setIdPro(int idPro){
        this.idPro = idPro;
    }
    
    public void setModeloPro(String modeloPro){
        this.modeloPro = modeloPro;
    }
    
    public void setTipoPro(String tipoPro){
        this.tipoPro = tipoPro;
    }
    
    public void setCantidadPro(int cantidadPro){
        this.cantidadPro = cantidadPro;
    }
    
    public void setPrecioPro(double precioPro){
        this.precioPro = precioPro;
    }
    
    public void setProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
    }
    
    public int getIdPro() {
        return idPro;
    }
    
    public String getModeloPro() {
        return modeloPro;
    }
    
    public String getTipoPro() {
        return tipoPro;
    }
    
    public int getCantidadPro() {
        return cantidadPro;
    }
    
    public double getPrecioPro() {
        return precioPro;
    }
    
    public Proveedor getProveedor(){
        return proveedor;
    }
   

}
