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
                at.add(new Tatuador(rs.getInt("idTatuador"), rs.getString("nombre"), rs.getString("ap_paterno"), rs.getString("ap_materno"), rs.getInt("contacto"), rs.getFloat("comision")));
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
            pst.setString(6, Integer.toString(t.getContatco()));
            pst.setString(5, Float.toString(t.getComision()));
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static Tatuador buscarTatuador( int id ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("SELECT * FROM TATUADOR WHERE idTatuador = ?");
            pst.setString(1, Integer.toString(id));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
                return new Tatuador(rs.getInt("idTatuador"), rs.getString("nombre"), rs.getString("ap_paterno"), rs.getString("ap_materno"), rs.getInt("contacto"), rs.getFloat("comision"));
  
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static void modificarTatuador( int id, String nombre, String apPat, String apMat, int contacto, float comision ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("UPDATE tatuador SET nombre = ?, ap_paterno = ?, ap_materno = ?, contacto = ?, comision = ? WHERE idTatuador = " + id);
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
            pst = cn.prepareStatement("DELETE FROM tatuador WHERE idTatuador = ?" + id);
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static ArrayList<Cita> getCitas( int idTatuador ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("SELECT * FROM cita WHERE idTatuador = " + idTatuador);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                ArrayList<Cita> ac = new ArrayList<>();
                while(rs.next()){
                    ac.add(new Cita(rs.getInt("idCita"), rs.getInt("diaInicio"), rs.getInt("mesInicio"), 
                            rs.getInt("anioInicio"), rs.getInt("diaFinal"), 
                            rs.getInt("mesFinal"), rs.getInt("anioFinal"), 
                            rs.getString("nomClienteCita"), rs.getFloat("anticipo"), 
                            rs.getFloat("precio"), rs.getInt("duracion")));
                }
                return ac;
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static void insertarCita( Cita c ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("INSERT INTO cita VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, "");
            pst.setString(2, c.getNombreCliente());
            pst.setString(3, Integer.toString(c.getDiaInicio()));
            pst.setString(4, Integer.toString(c.getMesInicio()));
            pst.setString(5, Integer.toString(c.getAnioInicio()));
            pst.setString(6, Integer.toString(c.getDiaFinal()));
            pst.setString(7, Integer.toString(c.getMesFinal()));
            pst.setString(8, Integer.toString(c.getAnioFinal()));
            pst.setString(9, Float.toString(c.getAnticipo()));
            pst.setString(10, Float.toString(c.getPrecio()));
            pst.setString(11, Integer.toString(c.getDuracion()));
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void modificarCita( int id ){
        
    }
    
    public static void eliminarCita( int id ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("DELETE FROM cita WHERE idCita = ?" + id);
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    
    public static boolean autetnicacion( String usuario, String contrasena ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("SELECT * FROM usuario WHERE username = ?");
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
            pst = cn.prepareStatement("SELECT * FROM producto WHERE idProducto = ?");
            pst.setString(1, Integer.toString(idPro));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
                return new Producto(rs.getInt("idProducto"), rs.getString("modeloPro"), rs.getString("tipoPro"), rs.getInt("cantidadPro"), rs.getDouble("precioPro"), rs.getString("provedor"));
  
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    //Usuario
    
    public static void insertarUsuario(Usuario u){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("\"INSERT INTO usuario VALUES(?,?,?,?,?,?)\"");
            pst.setString(1, "");
            pst.setString(2, u.getnombre());
            pst.setString(3, u.getAp_paterno());
            pst.setString(4, u.getAp_materno());
            pst.setString(5, u.getpass());
            pst.setString(6, u.getusername());
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static Usuario buscarUsuario(int id) {  
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("SELECT * FROM usuario WHERE idUsuario = ?");
            pst.setString(1, Integer.toString(id));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
                return new Usuario(rs.getInt("idUsuario"), rs.getString("nombre"), rs.getString("ap_paterno"),rs.getString("ap_paterno"),rs.getString("username"));
  
        }catch(SQLException e){
            e.getMessage();
        }
        return null;  
    }

    public static void modificarUsuario(int id, String nombre, String apPaterno, String apMaterno){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("UPDATE usuario SET nombre = ?, ap_paterno = ?, ap_materno = ? WHERE id = " + id);
            pst.setString(1, nombre.trim());
            pst.setString(2, apPat.trim());
            pst.setString(3, apMat.trim());
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }

   }

    public static void modificarUsuario(String pass, String username){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("UPDATE usuario SET pass = ?, username = ?);
            pst.setString(1, pass());
            pst.setString(2, username.trim());
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void eliminarUsuario(int id){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("DELETE FROM usuario WHERE idUsuario = " + id);
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
}
