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
public class Proveedor {
    		private int id;
    	private String nombre;
    	private String contacto;
    	private double margen;
    	private double total;

	public Proveedor(String nombre, String contacto, double margen, double total){
		this.nombre = nombre;
       		this.contacto = contacto;
        	this.margen = margen;
		this.total=total;
	}
	//Sobrecarga de constructor
	public Proveedor(int id, String nombre, String contacto, double margen, double total){
		this.id =id;
		this.nombre = nombre;
       		this.contacto = contacto;
        	this.margen = margen;
		this.total=total;
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
	
    	public void setTotal(double total){
	    	this.total=total;
    	}
    	public void setNombre(String nombre) {
        	this.nombre = nombre;
    	}
	
    	public String getContacto() {
    		return contacto;
    	}
	
    	public void setContacto(String contacto) {
    		this.contacto = contacto;
    	}
	
    	public double getMargen() {
    		return margen;
    	}
	
    	public void setMargen(double margen) {
    		this.margen = margen;
    	}
}
