
import java.util.*;
class Tatuador {
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
class Ticket {
    private int id;
    private boolean clip;
    private boolean prod;
    private double pagado;
    private double total;
    private Tatuador tatuador;
    private boolean visita;
    private double cambio;
    private ArrayList<Producto> productos;


    public Ticket(int id, boolean clip, boolean prod, double pagado, double total, Tatuador tatuador, boolean visita, double cambio, ArrayList<Producto> productos) {
        this.id = id;
        this.clip = clip;
        this.prod = prod;
        this.pagado = pagado;
        this.total = total;
        this.tatuador = tatuador;
        this.visita = visita;
        this.cambio = cambio;
        this.productos = productos;
    }

    // Sobrecarga de constructor para la Base de Datos.
    public Ticket(boolean clip, boolean prod, double pagado, double total, Tatuador tatuador, boolean visita, double cambio, ArrayList<Producto> productos) {
        this.clip = clip;
        this.prod = prod;
        this.pagado = pagado;
        this.total = total;
        this.tatuador = tatuador;
        this.visita = visita;
        this.cambio = cambio;
        this.productos = productos;
    }

    public boolean isVisita(){
        return visita;
    }

    public void setVisita(boolean visita){
        this.visita = visita;
    }

    public double getCambio(){
        return cambio;
    }

    public void setCambio(double cambio){
        this.cambio = cambio;
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

    public double getPagado() {
        return pagado;
    }

    public double getTotal() {
        return total;
    }

    public Tatuador getTatuador() {
        return tatuador;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
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

    public void setPagado(double pagado) {
        this.pagado = pagado;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTatuador(Tatuador tatuador) {
        this.tatuador = tatuador;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
  }
class Producto {
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
  public Producto(String modeloPro, String tipoPro, int cantidadPro, double precioPro, Proveedor proveedor){
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
class Proveedor {
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

class ProcesoPago{
  public static void main(String[] args) {
    double totalG = 0;
    double pago = 0;
    double comiclip = 0.1;
    double monto=0;
    double comision=0;
    //double proveedor=0;
    ArrayList<Proveedor> pr = new ArrayList<Proveedor>();
    ArrayList<Producto> p = new ArrayList<Producto>();
    //p = null;
    Proveedor p1 = new Proveedor("Juan","Juanperez@lopez.com", 0.5, 0.0);
    Proveedor p2 = new Proveedor("Julio","Jerez@op.com", 0.3, 0.0);
    Producto pro1 = new Producto("Gandalf","Barabara", 10, 500.0, p1);
    Producto pro2 = new Producto("Gal","Bar", 10, 100.0, p1);
    //Producto pro3 = new Producto("Got","abara", 1000, p2);
    //Producto pro4 = new Producto("GG","Gimbli", 1000, p2);
    p.add(pro1);
    p.add(pro2);
    //p.add(pro3);
    //p.add(pro4);
    pr.add(p1);
    pr.add(p2);
    Tatuador ta = new Tatuador("juanito","perez","lopez","tatu4u@home.com",1,200);
    Ticket t = new Ticket(true, true, 0, 1000.0, ta, false, 0, p);
    double total = t.getTotal();

    if (t.isProd()){
      ArrayList<Proveedor> proveedoresArr = pr;
      ArrayList<Producto> productosArr = t.getProductos();
      double totalProv=0;
      double totalProd=0; 
      for(Producto prod:productosArr){
        total+=prod.getPrecioPro();
        for(Proveedor prov:proveedoresArr){
          if (prod.getProveedor().getNombre().equals(prov.getNombre())){ //El objeto Producto aún no contiene un objeto Proveedor.
            total-=prod.getPrecioPro();
            //t.setTotal(total-prod.getPrecioPro());
            System.out.println(total);  //Reducir Stock
            monto += prod.getPrecioPro()*(prov.getMargen()); //Se registra el margen de ganancia para BabaYaga
            totalProv = prov.getTotal();
            prov.setTotal(totalProv + prod.getPrecioPro()*(1-prov.getMargen())); //Es necesario registrar los márgenes como 50, 60, etc. y mandarlos como 0.5, 0.6, etc.
            //Model.modificarProveedor(prov);
            //Model.actualizarStock(prod.getIdPro(), prod.getCantidadPro()-1);
            System.out.println("Ganancia del proveedor: "+prod.getPrecioPro()*(1-prov.getMargen()));
          }
        }
      }
    }
    switch(t.getTatuador().getRango()){
      case 1:
        comision = 0.6;
        break;
      case 2:
        comision = 0.5;
        break;
      case 3:         //Comentar con Vista
        if(t.isVisita()){ //Necesitamos este booleano.
          comision = 0.6;
        }else{
          comision = 0.4;
        }
        break;
    }

    monto += t.getTotal() - t.getTotal()*comision;
    System.out.println("Ganancia del estudio "+monto);
    totalG+=monto;
    System.out.println("Total del estudio "+totalG);
    pago = t.getTatuador().getTotal()+comision*t.getTotal();
    System.out.println("Ganancia del tatuador "+comision*t.getTotal());
    System.out.println("Total del tatuador "+pago);
    t.getTatuador().setTotal(t.getTatuador().getTotal()+comision*t.getTotal());
    //Model.modificarTatuador(t.getTatuador());
  }
}
