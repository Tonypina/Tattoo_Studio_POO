package objects;

public class Socio{
    private int id;
    private String nombre;
    private String contacto;
    private boolean rango;
    private double total;

    public Socio(String nombre, String contacto, boolean rango, double total){
        this.nombre = nombre;
        this.contacto = contacto;
        this.rango = rango;
	this.total=total;
    }

    // Sobrecarga de constructor para base de datos
    public Socio(int id, String nombre, String contacto, boolean rango, double total){
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.rango = rango;
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
	
    public boolean isRango() {
    	return rango;
    }
	
    public void setRango(boolean rango) {
    	this.rango = rango;
    }
}
