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
    
    public static void eliminarTatuador( Tatuador t ){
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
}
