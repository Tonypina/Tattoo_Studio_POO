package objects;

public class Producto {
    private int idProducto;
    private String modeloPro;
    private String tipoPro;
    private int cantidadPro;
    private double precioPro;
    private String proveedor;
    
    public Producto(int idProducto, String modeloPro, String tipoPro, int cantidadPro, double precioPro, String proveedor){
        this.idProducto = idProducto;
        this.modeloPro = modeloPro;
        this.tipoPro = tipoPro;
        this.cantidadPro = cantidadPro;
        this.precioPro = precioPro;
        this.proveedor = proveedor;
        
    }
    
    public void setIdProducto(int idProducto){
        this.idProducto = idProducto;
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
    
    public void setProveedor(String proveedor){
        this.proveedor = proveedor;
    }
    
    public int getIdProducto() {
        return idProducto;
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
    
    public String getProveedor(){
        return proveedor;
    }
   

}

