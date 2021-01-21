 public class Producto {
    private int idPro;
    private String modeloPro;
    private String tipoPro;
    private int cantidadPro;
    private double precioPro;
    private String provedor;
    
    public Producto(int idPro, String modeloPro, String tipoPro, int cantidadPro, double precioPro, String provedor){
        this.idPro = idPro;
        this.modeloPro = modeloPro;
        this.tipoPro = tipoPro;
        this.cantidadPro = cantidadPro;
        this.precioPro = precioPro;
        this.provedor = provedor;
        
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
    
    public void setProvedor(String provedor){
        this.provedor = provedor;
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
    
    public String getProvedor(){
        return provedor;
    }
   

}

