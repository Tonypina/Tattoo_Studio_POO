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
    private static ResultSet rs;
    // Estudio
    
    public static void aumentarGanancia( double aumento ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            double ganancia = obtenerGanancia();
            pst = cn.prepareStatement("UPDATE estudio SET ganancia = ? WHERE idEstudio = 1");
            pst.setString(1, Double.toString(aumento+ganancia));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static double obtenerGanancia(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("SELECT * FROM estudio WHERE idEstudio = 1");
            rs = pst.executeQuery();
            cn.close();
            pst.close();
            return rs.getDouble("ganancia");
        }catch(SQLException e){
            e.getMessage();
        }
        return 0.0;
    }
    
    public static double obtenerReinversion(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("SELECT * FROM estudio WHERE idEstudio = 1");
            rs = pst.executeQuery();
            cn.close();
            pst.close();
            return rs.getDouble("reinversion");
        }catch(SQLException e){
            e.getMessage();
        }
        return 0.0;
    }
    
    public static void aumentarReinversion( double aumento ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            double reinversion = obtenerReinversion();
            pst = cn.prepareStatement("UPDATE estudio SET reinversion = ? WHERE idEstudio = 1");
            pst.setString(1, Double.toString(reinversion+aumento));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static double obtenerPagoProveedores(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("SELECT * FROM estudio WHERE idEstudio = 1");
            rs = pst.executeQuery();
            cn.close();
            pst.close();
            return rs.getDouble("pagoProveedores");
        }catch(SQLException e){
            e.getMessage();
        }
        return 0.0;
    }
    
    public static void aumentarPagoProveedores( double aumento ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            double pagoProveedores = obtenerPagoProveedores();
            pst = cn.prepareStatement("UPDATE estudio SET pagoProveedores = ? WHERE idEstudio = 1");
            pst.setString(1, Double.toString(pagoProveedores+aumento));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    // Tatuador
    
    public static ArrayList<Tatuador> getTatuadores(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("SELECT * FROM tatuador ORDER BY nombre");
            
            rs = pst.executeQuery();
            
            ArrayList<Tatuador> at = new ArrayList<>();
            
            while(rs.next()){
                at.add(new Tatuador( rs.getInt("idTatuador"), rs.getString("nombre"), 
                                     rs.getString("ap_paterno"), rs.getString("ap_materno"), 
                                     rs.getString("contacto"), rs.getInt("rango"), rs.getDouble("total")));
            }
            pst.close();
            cn.close();
            return at;
            
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static void insertarTatuador( Tatuador t ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            System.out.println("Entré a la base");
            pst = cn.prepareStatement("INSERT INTO tatuador VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, "");
            pst.setString(2, t.getNombre());
            pst.setString(3, t.getAp_pat());
            pst.setString(4, t.getAp_mat());
            pst.setString(5, t.getContacto());
            pst.setString(6, Integer.toString(t.getRango()));
            pst.setString(7, Double.toString(t.getTotal()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static Tatuador buscarTatuador( int id ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("SELECT * FROM TATUADOR WHERE idTatuador = ?");
            pst.setString(1, Integer.toString(id));
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                pst.close();
                cn.close();
                return new Tatuador(rs.getInt("idTatuador"), rs.getString("nombre"), 
                                    rs.getString("ap_paterno"), rs.getString("ap_materno"), 
                                    rs.getString("contacto"), rs.getInt("rango"), rs.getDouble("total"));
            }
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static ArrayList<Tatuador> buscarTatuador( String nombre ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("SELECT * FROM tatuador WHERE nombre = ? ORDER BY nombre");
            pst.setString(1, nombre);
            
            rs = pst.executeQuery();

            ArrayList<Tatuador> at = new ArrayList<>();
            
            while(rs.next()){
                at.add(new Tatuador(rs.getInt("idTatuador"), rs.getString("nombre"), 
                                    rs.getString("ap_paterno"), rs.getString("ap_materno"), 
                                    rs.getString("contacto"), rs.getInt("rango"), rs.getDouble("total")));
            }
            pst.close();
            cn.close();
            return at;
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static void modificarTatuador( Tatuador t ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("UPDATE tatuador SET nombre = ?, ap_paterno = ?, ap_materno = ?, contacto = ?, rango = ?, total = ? WHERE idTatuador = " + t.getId());
            pst.setString(1, t.getNombre().trim());
            pst.setString(2, t.getAp_pat().trim());
            pst.setString(3, t.getAp_mat().trim());
            pst.setString(4, t.getContacto());
            pst.setString(5, Integer.toString(t.getRango()));
            pst.setString(6, Double.toString(t.getTotal()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void eliminarTatuador( int id ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("DELETE FROM tatuador WHERE idTatuador = " + id);
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    // Citas
    
    public static ArrayList<Cita> getCitas( int idTatuador ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("SELECT * FROM cita WHERE idTatuador = " + idTatuador + " ORDER BY nomClienteCita");
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                ArrayList<Cita> ac = new ArrayList<>();
                while(rs.next()){
                    ac.add(new Cita(rs.getInt("idCita"), rs.getInt("diaInicio"), rs.getInt("mesInicio"), 
                            rs.getInt("anioInicio"), rs.getInt("diaFinal"), 
                            rs.getInt("mesFinal"), rs.getInt("anioFinal"), 
                            rs.getString("nomClienteCita"), rs.getDouble("anticipo"), 
                            rs.getDouble("precio"), rs.getInt("duracion")));
                }
                pst.close();
                cn.close();
                return ac;
            }
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static void insertarCita( Cita c ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("INSERT INTO cita(idCita, nombreCliente, diaInicio, mesInicio, anioInicio, diaFinal, mesFinal, anioFinal, anticipo, duracion, idTatuador) "
                                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, "");
            pst.setString(2, c.getNombreCliente());
            pst.setString(3, Integer.toString(c.getDiaInicio()));
            pst.setString(4, Integer.toString(c.getMesInicio()));
            pst.setString(5, Integer.toString(c.getAnioInicio()));
            pst.setString(6, Integer.toString(c.getDiaFinal()));
            pst.setString(7, Integer.toString(c.getMesFinal()));
            pst.setString(8, Integer.toString(c.getAnioFinal()));
            pst.setString(9, Double.toString(c.getAnticipo()));
            pst.setString(10, Double.toString(c.getPrecio()));
            pst.setString(11, Integer.toString(c.getDuracion()));
            pst.setString(12, Integer.toString(c.getNombreTatuador().getId()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void modificarCita( int idCita, String nombreCliente, int diaInicio, int mesInicio, int anioInicio, int diaFinal, int mesFinal, int anioFinal, float anticipo, float precio, int duracion ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("UPDATE cita SET nomClienteCita = ?, "
                                    + "diaInicio = ?, mesInicio = ?, anioInicio = ?, "
                                    + "diaFinal = ?, mesFinal = ?, anioFinal = ?, "
                                    + "anticipo = ?, precio = ?, duracion = ? WHERE idTatuador = " + idCita);
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
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void eliminarCita( int id ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("DELETE FROM cita WHERE idCita = ?" + id);
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    // Producto
    
    public static ArrayList<Producto> getProductos(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("SELECT * FROM producto ORDER BY tipoPro");
            
            rs = pst.executeQuery();
            
            ArrayList<Producto> pd = new ArrayList<>();
            
            while(rs.next()){
                pd.add(new Producto(rs.getInt("idProducto"), rs.getString("modeloPro"), rs.getString("tipoPro"), rs.getInt("cantidadPro"), rs.getDouble("precioPro"), rs.getString("proveedor")));
            }
            
            pst.close();
            cn.close();
            return pd;
            
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static ArrayList<Producto> getTipos( String tipoPro ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("SELECT * FROM producto WHERE tipoPro = " + tipoPro + " ORDER BY tipoPro");
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                ArrayList<Producto> tp = new ArrayList<>();
                while(rs.next()){
                    tp.add(new Producto(rs.getInt("idProducto"), rs.getString("modeloPro"), 
                                        rs.getString("tipoPro"), rs.getInt("cantidadPro"), 
                                        rs.getDouble("precioPro"), rs.getString("proveedor")));
                }
                pst.close();
                cn.close();
                return tp;
            }
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static void insertarProducto( Producto pro ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?,?)");
            pst.setString(1, "");
            pst.setString(2, pro.getModeloPro());
            pst.setString(3, pro.getTipoPro());
            pst.setString(4, Integer.toString(pro.getCantidadPro()));
            pst.setString(5, Double.toString(pro.getPrecioPro()));
            pst.setString(6, pro.getProveedor());
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }

    public static Producto buscarProducto( int idPro ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("SELECT * FROM producto WHERE idProducto = ?");
            pst.setString(1, Integer.toString(idPro));
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                pst.close();
                cn.close();
                return new Producto(rs.getInt("idProducto"), rs.getString("modeloPro"), rs.getString("tipoPro"), rs.getInt("cantidadPro"), rs.getDouble("precioPro"), rs.getString("proveedor"));
            }
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
        
    public static void modificarProducto( int idPro, String modeloPro, String tipoPro, int cantidadPro, double precioPro, String proveedor){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("UPDATE producto SET modeloPro = ?, tipoPro = ?, cantidadPro = ?, precioPro = ?, proveedor = ? WHERE idProducto = " + idPro);
            pst.setString(1, modeloPro.trim());
            pst.setString(2, tipoPro.trim());
            pst.setString(3, Integer.toString(cantidadPro));
            pst.setString(4, Double.toString(precioPro));
            pst.setString(5, proveedor.trim());
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void eliminarProducto( int idPro ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("DELETE FROM producto WHERE idProducto = " + idPro);
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void actualizarStock(int idPro, int cantidadPro){
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("UPDATE producto SET cantidadPro = ? WHERE idProducto = " + idPro);
            
            pst.setString(1, Integer.toString(cantidadPro));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e ){
            e.getMessage();
        }
    }
    
    //Usuario
    
    public static ArrayList<Usuario> getUsuarios(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("SELECT * FROM usuario");
            
            rs = pst.executeQuery();
            
            ArrayList<Usuario> at = new ArrayList<>();
            
            while(rs.next()){
                at.add(new Usuario(rs.getInt("idUsuario"), rs.getString("nombre"), 
                                   rs.getString("ap_paterno"), rs.getString("ap_materno"), 
                                   rs.getString("username")));
            }
            pst.close();
            cn.close();
            return at;
            
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static void insertarUsuario(Usuario u){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("INSERT INTO usuario VALUES(?,?,?,?,?,?)");
            pst.setString(1, "");
            pst.setString(2, u.getNombre());
            pst.setString(3, u.getAp_paterno());
            pst.setString(4, u.getAp_materno());
            pst.setString(5, u.getPass());
            pst.setString(6, u.getUsername());
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static Usuario buscarUsuario(int id) {  
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("SELECT * FROM usuario WHERE idUsuario = ?");
            pst.setString(1, Integer.toString(id));
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                pst.close();
                cn.close();
                return new Usuario(rs.getInt("idUsuario"), rs.getString("nombre"), 
                                   rs.getString("ap_paterno"),rs.getString("ap_paterno"), 
                                   rs.getString("username"));
            }
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return null;  
    }

    public static void modificarUsuario(int idUsuario, String nombre, String ap_paterno, String ap_materno,String pass, String username){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("UPDATE usuario SET nombre = ?, ap_paterno = ?, ap_materno = ?, pass = ?, username = ? WHERE id = " + idUsuario);
            pst.setString(1, nombre.trim());
            pst.setString(2, ap_paterno.trim());
            pst.setString(3, ap_materno.trim());
            pst.setString(4, pass);
            pst.setString(5, username.trim());
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }

   }
    
    public static void eliminarUsuario(int id){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("DELETE FROM usuario WHERE idUsuario = " + id);
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static boolean autetnicacion( String username, String pass ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("SELECT * FROM usuario WHERE username = ?" + username); 
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                if(pass.equals(rs.getString("pass"))){
                    pst.close();
                    cn.close();
                    return true;
                }
            }
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return false;
    }
    
    //Socio
    
    public static ArrayList<Socio> getSocios(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("SELECT * FROM socio ORDER BY nombre");
            
            rs = pst.executeQuery();
            
            ArrayList<Socio> so = new ArrayList<>();
            
            while(rs.next()){
                so.add(new Socio( rs.getInt("idSocio"), rs.getString("nombre"), 
                                  rs.getString("contacto"), rs.getBoolean("rango"), rs.getDouble("total")));
            }
            pst.close();
            cn.close();
            return so;
            
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }

    
    
    public static void insertarSocio( Socio s ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            System.out.println("Entré a la base");
            pst = cn.prepareStatement("INSERT INTO socio VALUES(?,?,?,?,?)");
            pst.setString(1, "");
            pst.setString(2, s.getNombre());
            pst.setString(3, s.getContacto());
            if( s.isRango() ){
                pst.setString(4, "0");
            } else {
                pst.setString(4, "1");
            }
            pst.setString(5, Double.toString(s.getTotal()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }


    public static Socio buscarSocio( int id ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("SELECT * FROM socio WHERE idSocio = ?");
            pst.setString(1, Integer.toString(id));
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                pst.close();
                cn.close();
                return new Socio(rs.getInt("idSocio"), rs.getString("nombre"), rs.getString("contacto"), rs.getBoolean("rango"), rs.getDouble("total"));
            }
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }



    public static void modificarSocio( Socio s ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("UPDATE socio SET nombre = ?, comision = ? WHERE idSocio = " + s.getId());
            pst.setString(1, s.getNombre().trim());
            pst.setString(2, s.getContacto().trim());
            if( s.isRango() ){
                pst.setString(3, "0");
            } else {
                pst.setString(3, "1");
            }
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }


    public static void eliminarSocio( int id ){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            pst = cn.prepareStatement("DELETE FROM socio WHERE idSocio = " + id);
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }

    public static void main(String a[]){
        Model.insertarTatuador(new Tatuador("a","b","c","d",1,2.5));
    }
    
}
