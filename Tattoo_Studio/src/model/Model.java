package model;
import java.sql.*;
import objects.*;

/**
 *
 * @author
 */
public class Model {
    private static Connection cn;
    private static PreparedStatement pst;
    
    public static ArrayList<Tatuador> getTatuadores(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("SELECT * FROM tatuador");
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Tatuador> at = new ArrayList<>();
            
            while(rs.next()){
                at.add(new Tatuador(rs.getInt("id"), rs.getString("nombre"), rs.getString("ap_paterno"), rs.getString("ap_materno"), rs.getInt("celTatuador"), rs.getFloat("comisionTatuador")));
            }
            
            return at;
            
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static void insertarTatuador( Tatuador t ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("INSERT INTO tatuador VALUES(?,?,?,?,?,?)");
            pst.setString(1, "");
            pst.setString(2, t.getNombre());
            pst.setString(3, t.getAp_pat());
            pst.setString(4, t.getAp_mat());
            pst.setString(5, Float.toString(t.getComision()));
            pst.setString(6, Integer.toString(t.getContatco()));
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static Tatuador buscarTatuador( int id ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("SELECT * FROM TATUADOR WHERE id = ?");
            pst.setString(1, Integer.toString(id));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
                return new Tatuador(rs.getInt("id"), rs.getString("nombre"), rs.getString("ap_paterno"), rs.getString("ap_materno"), rs.getInt("celuTatuador"), rs.getFloat("comisionTatuador"));
  
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static void modificarTatuador( int id, int contacto ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("UPDATE tatuador SET celuTatuador = ? WHERE id = " + id);
            pst.setString(1, Integer.toString(contacto));
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void modificarTatuador( int id, float comision ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("UPDATE tatuador SET comisionTatuador = ? WHERE id = " + id);
            pst.setString(1, Float.toString(comision));
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void modificarTatuador( int id, String nombre, String apPat, String apMat ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("UPDATE tatuador SET nombre = ?, ap_paterno = ?, ap_materno = ? WHERE id = " + id);
            pst.setString(1, nombre.trim());
            pst.setString(2, apPat.trim());
            pst.setString(3, apMat.trim());
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void modificarTatuador( int id, String nombre, String apPat, String apMat, int contacto ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("UPDATE tatuador SET nombre = ?, ap_paterno = ?, ap_materno = ?, celuTatuador = ? WHERE id = " + id);
            pst.setString(1, nombre.trim());
            pst.setString(2, apPat.trim());
            pst.setString(3, apMat.trim());
            pst.setString(4, Integer.toString(contacto));
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void modificarTatuador( int id, String nombre, String apPat, String apMat, int contacto, float comision ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("UPDATE tatuador SET nombre = ?, ap_paterno = ?, ap_materno = ?, celuTatuador = ?, comisionTatuador = ? WHERE id = " + id);
            pst.setString(1, nombre.trim());
            pst.setString(2, apPat.trim());
            pst.setString(3, apMat.trim());
            pst.setString(4, Integer.toString(contacto));
            pst.setString(5, Float.toString(comision));
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void eliminarTatuador( int id ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("DELETE FROM tatuador WHERE id = ?" + id);
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void insertarUsuario(){
    }
    
    public static Usuario buscarUsuario() {    
        return null;
    }
    
    public static void eliminarUsuario(){
    }
    
    public static boolean autetnicacion( String usuario, String contrasena ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("SELECT * FROM usuario WHERE nombre = ?");
            pst.setString(2, usuario); 
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                if(contrasena.equals(rs.getString("constrasena"))){
                    return true;
                }
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return false;
    }
    
    // Producto
    
    public static void insertarProducto( Producto pro ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?,?)");
            pst.setString(1, "");
            pst.setString(2, pro.getModeloPro());
            pst.setString(3, pro.getTipoPro());
            pst.setString(4, Integer.toString(pro.getCantidadPro()));
            pst.setString(5, Double.toString(pro.getPrecioPro()));
            pst.setString(6, pro.getProvedor());
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }


    public static Producto buscarProducto( int idPro ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("SELECT * FROM producto WHERE id = ?");
            pst.setString(1, Integer.toString(idPro));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
                return new Producto(rs.getInt("id"), rs.getString("modelo"), rs.getString("tipo"), rs.getInt("cantidad"), rs.getDouble("precio"), rs.getString("Provedor"));
  
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    
    
}
