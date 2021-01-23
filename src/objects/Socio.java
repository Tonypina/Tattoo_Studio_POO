package objects;

public class Socio{
  private int id;
  private String nombre;
  private String contacto;
  private boolean rango;

  public Socio(String nombre, String contacto, boolean rango){
    this.setNombre(nombre);
    this.setContacto(contacto);
    this.setRango(rango);

  }

  // Sobrecarga de constructor para base de datos
  public Socio(int id, String nombre, String contacto, boolean rango){
    this.id = id;
    this.setNombre(nombre);
    this.setContacto(contacto);
    this.setRango(rango);

  }

	public int getId(){
		return id;
	}
	
	public String getNombre() {
		return nombre;
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
