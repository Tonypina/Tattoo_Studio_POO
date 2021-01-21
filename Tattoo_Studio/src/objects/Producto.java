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


class Main{
    public static void main(String [] e){

        Producto pro = new Producto(7,"Merceddes","Electrico",57,100000.5,"Pumas UNAM");
        pro.setIdPro(7);
        pro.setModeloPro("Mercedes");
        pro.setTipoPro("Electrico");
        pro.setCantidadPro(57);
        pro.setPrecioPro(100000.5);
        pro.setProvedor("Pumas UNAM");
        System.out.println(pro.getIdPro()+"\n");
        System.out.println(pro.getModeloPro()+"\n");
        System.out.println(pro.getTipoPro()+"\n");
        System.out.println(pro.getCantidadPro()+"\n");
        System.out.println(pro.getPrecioPro()+"\n");
        System.out.println(pro.getProvedor()+"\n");
        //Producto p = new Producto(p.getIdPro(), p.getModeloPro(), p.getTipoPro(), p.getCantidadPro(), p.getPrecioPro(), p.getProvedor());
        
        //System.out.println(p);
    }
}
