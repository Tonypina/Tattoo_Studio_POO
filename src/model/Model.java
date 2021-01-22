package model;
import java.sql.*;
import objects.*;
import java.util.*;

/**
 *
 * @author
 */
public class Model {
    private static Connection cn;
    private static PreparedStatement pst;
    
    // Tatuador
    
    public static ArrayList<Tatuador> getTatuadores(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("SELECT * FROM tatuador ORDER BY nombre");
            
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
    
    // Citas
    
    public static ArrayList<Cita> getCitas( int idTatuador ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("SELECT * FROM cita WHERE idTatuador = " + idTatuador + " ORDER BY nomClienteCita");
            
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
    
    public static void modificarCita( int id, String nombreCliente, int diaInicio, int mesInicio, int anioInicio, int diaFinal, int mesFinal, int anioFinal, float anticipo, float precio, int duracion ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("UPDATE cita SET nomClienteCita = ?, "
                                    + "diaInicio = ?, mesInicio = ?, anioInicio = ?, "
                                    + "diaFinal = ?, mesFinal = ?, anioFinal = ?, "
                                    + "anticipo = ?, precio = ?, duracion = ? WHERE idTatuador = " + id);
            pst.setString(1, nombreCliente);
            pst.setString(2, Integer.toString(diaInicio));
            pst.setString(3, Integer.toString(mesInicio));
            pst.setString(4, Integer.toString(anioInicio));
            pst.setString(5, Integer.toString(diaFinal));
            pst.setString(6, Integer.toString(mesFinal));
            pst.setString(7, Integer.toString(anioFinal));
            pst.setString(8, Float.toString(anticipo));
            pst.setString(9, Float.toString(precio));
            pst.setString(10, Integer.toString(duracion));
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
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
    
    // Producto
    
    public static ArrayList<Producto> getProductos(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("SELECT * FROM producto ORDER BY tipoPro");
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Producto> pd = new ArrayList<>();
            
            while(rs.next()){
                pd.add(new Producto(rs.getInt("idProducto"), rs.getString("modeloPro"), rs.getString("tipoPro"), rs.getInt("cantidadPro"), rs.getDouble("precioPro"), rs.getString("proveedor")));
            }
            
            return pd;
            
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static ArrayList<Producto> getTipos( String tipoPro ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("SELECT * FROM producto WHERE tipoPro = " + tipoPro + " ORDER BY tipoPro");
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                ArrayList<Producto> tp = new ArrayList<>();
                while(rs.next()){
                    tp.add(new Producto(rs.getInt("idProducto"), rs.getString("modeloPro"), 
                                        rs.getString("tipoPro"), rs.getInt("cantidadPro"), 
                                        rs.getDouble("precioPro"), rs.getString("proveedor")));
                }
                return tp;
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static void insertarProducto( Producto pro ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?,?)");
            pst.setString(1, "");
            pst.setString(2, pro.getModeloPro());
            pst.setString(3, pro.getTipoPro());
            pst.setString(4, Integer.toString(pro.getCantidadPro()));
            pst.setString(5, Double.toString(pro.getPrecioPro()));
            pst.setString(6, pro.getProveedor());
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
                return new Producto(rs.getInt("idProducto"), rs.getString("modeloPro"), rs.getString("tipoPro"), rs.getInt("cantidadPro"), rs.getDouble("precioPro"), rs.getString("proveedor"));
  
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
        
    public static void modificarProducto( int idPro, String modeloPro, String tipoPro, int cantidadPro, double precioPro, String proveedor){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("UPDATE producto SET modeloPro = ?, tipoPro = ?, cantidadPro = ?, precioPro = ?, proveedor = ? WHERE idProducto = " + idPro);
            pst.setString(1, modeloPro.trim());
            pst.setString(2, tipoPro.trim());
            pst.setString(3, Integer.toString(cantidadPro));
            pst.setString(4, Double.toString(precioPro));
            pst.setString(5, proveedor.trim());
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    
    public static void eliminarProducto( int idPro ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("DELETE FROM producto WHERE idProducto = " + idPro);
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    
    public static void actualizarStock(int idPro, int cantidadPro){
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("UPDATE producto SET cantidadPro = ? WHERE idProducto = " + idPro);
            
            pst.setString(1, Integer.toString(cantidadPro));

        }catch(SQLException e ){
            e.getMessage();
        }
    }
    
    
    //Usuario
    
    public static ArrayList<Usuario> getUsuarios(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("SELECT * FROM usuario");
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Usuario> at = new ArrayList<>();
            
            while(rs.next()){
                at.add(new Usuario(rs.getInt("idUsuario"), rs.getString("nombre"), 
                                   rs.getString("ap_paterno"), rs.getString("ap_materno"), 
                                   rs.getString("username"), rs.getString("pass")));
            }
            
            return at;
            
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static void insertarUsuario(Usuario u){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("\"INSERT INTO usuario VALUES(?,?,?,?,?,?)\"");
            pst.setString(1, "");
            pst.setString(2, u.getNombre());
            pst.setString(3, u.getAp_paterno());
            pst.setString(4, u.getAp_materno());
            pst.setString(5, u.getPass());
            pst.setString(6, u.getUsername());
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

    public static void modificarUsuario(int idUsuario, String nombre, String ap_paterno, String ap_materno,String pass, String username){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("UPDATE usuario SET nombre = ?, ap_paterno = ?, ap_materno = ?, pass = ?, username = ? WHERE id = " + idUsuario);
            pst.setString(1, nombre.trim());
            pst.setString(2, ap_paterno.trim());
            pst.setString(3, ap_materno.trim());
            pst.setString(4, pass);
            pst.setString(5, username.trim());
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
    
    public static boolean autetnicacion( String username, String pass ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localost/tattoo_studio_db", "root", "toor");
            pst = cn.prepareStatement("SELECT * FROM usuario WHERE username = ?");
            pst.setString(2, username); 
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                if(pass.equals(rs.getString("pass"))){
                    return true;
                }
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return false;
    }
}
