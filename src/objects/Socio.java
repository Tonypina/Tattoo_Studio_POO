package objects;

public class Socio{
  private String nombre;
  private String contacto;
  private boolean rango;
  private double total;

  public Socio(String nombre, String contacto, boolean rango){
    this.nombre = nombre;
    this.contacto = contacto;
    this.rango = rango;

  }
  public String getNombre() {
        return nombre;
  }

  public String getContacto() {
        return contacto;
  }

  public String getRango() {
        return rango;
  }

  public String setNombre() {
        this.nombre = nombre;
  }

  public String setContacto() {
        this.contacto = contacto;
  }

  public String setRango() {
        this.rango = rango;
  }
