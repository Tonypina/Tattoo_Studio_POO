package objects;

class Tatuador{
  private String nombre;
  private String ap_pat;
  private String ap_mat;
  private String contacto;
  private int rangoInt;
  private double total;
  public boolean[] RangoArr = [Principal, Aprendiz, Secundario];

  Tatuador(String nombre, String ap_pat, String ap_mat, String contacto, Int rangoInt){
    this.nombre = nombre
    this.ap_pat = ap_pat;
    this.ap_mat = ap_mat;
    this.contacto = contacto;
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
    public double getRango() {
      return rangoInt;
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
    public void setRango(Int rango) {
      this.rangoInt = rango;
  }
}
