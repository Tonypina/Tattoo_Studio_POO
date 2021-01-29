/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;
import objects.*;
import java.util.*;

/**
 *
 * @author
 */
public class Model {
    // Estudio
    
    public static void aumentarGanancia( double aumento ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            double ganancia = obtenerGanancia();
            PreparedStatement pst = cn.prepareStatement("UPDATE estudio SET ganancia = ? WHERE idEstudio = 1");
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
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM estudio WHERE idEstudio = 1");
            ResultSet rs = pst.executeQuery();
            Double ganancia = rs.getDouble("ganancia");
            cn.close();
            pst.close();
            return ganancia;
        }catch(SQLException e){
            e.getMessage();
        }
        return 0.0;
    }
    
    public static double obtenerReinversion(){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM estudio WHERE idEstudio = 1");
            ResultSet rs = pst.executeQuery();
            Double reinversion = rs.getDouble("reinversion");
            cn.close();
            pst.close();
            return reinversion;
        }catch(SQLException e){
            e.getMessage();
        }
        return 0.0;
    }
    
    public static void aumentarReinversion( double aumento ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            double reinversion = obtenerReinversion();
            PreparedStatement pst = cn.prepareStatement("UPDATE estudio SET reinversion = ? WHERE idEstudio = 1");
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
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM estudio WHERE idEstudio = 1");
            ResultSet rs = pst.executeQuery();
            Double pagoProveedores = rs.getDouble("pagoProveedores");
            cn.close();
            pst.close();
            return pagoProveedores;
        }catch(SQLException e){
            e.getMessage();
        }
        return 0.0;
    }
    
    public static void aumentarPagoProveedores( double aumento ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            double pagoProveedores = obtenerPagoProveedores();
            PreparedStatement pst = cn.prepareStatement("UPDATE estudio SET pagoProveedores = ? WHERE idEstudio = 1");
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
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM tatuador ORDER BY nombre");
            
            ResultSet rs = pst.executeQuery();
            
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
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");            
            PreparedStatement pst = cn.prepareStatement("INSERT INTO tatuador VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, "0");
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
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM tatuador WHERE idTatuador = ?");
            pst.setString(1, Integer.toString(id));
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Tatuador t = new Tatuador(rs.getInt("idTatuador"), rs.getString("nombre"), 
                                    rs.getString("ap_paterno"), rs.getString("ap_materno"), 
                                    rs.getString("contacto"), rs.getInt("rango"), rs.getDouble("total"));
                pst.close();
                cn.close();
                return t;
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
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM tatuador WHERE nombre = ? ORDER BY nombre");
            pst.setString(1, nombre);
            
            ResultSet rs = pst.executeQuery();

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
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE tatuador SET nombre = ?, ap_paterno = ?, ap_materno = ?, contacto = ?, rango = ?, total = ? WHERE idTatuador = " + t.getId());
            pst.setString(1, t.getNombre());
            pst.setString(2, t.getAp_pat());
            pst.setString(3, t.getAp_mat());
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
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("DELETE FROM tatuador WHERE idTatuador = " + id);
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
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM cita WHERE idTatuadorCita = " + idTatuador + " ORDER BY nomClienteCita");
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                ArrayList<Cita> ac = new ArrayList<>();
                while(rs.next()){
                    ac.add(new Cita(rs.getInt("idCita"), rs.getString("nomClienteCita"), 
                            rs.getInt("diaInicio"), rs.getInt("mesInicio"), 
                            rs.getInt("anioInicio"), rs.getInt("diaFinal"), 
                            rs.getInt("mesFinal"), rs.getInt("anioFinal"), rs.getInt("idTatuador")));
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
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO cita VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, "0");
            pst.setString(2, c.getNombreCliente());
            pst.setString(3, Integer.toString(c.getDiaInicio()));
            pst.setString(4, Integer.toString(c.getMesInicio()));
            pst.setString(5, Integer.toString(c.getAnioInicio()));
            pst.setString(6, Integer.toString(c.getDiaFinal()));
            pst.setString(7, Integer.toString(c.getMesFinal()));
            pst.setString(8, Integer.toString(c.getAnioFinal()));
            pst.setString(9, Integer.toString(c.getIdTatuador()));
            pst.executeUpdate();
            
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void modificarCita( Cita c ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE cita SET nomClienteCita = ?, "
                                    + "diaInicio = ?, mesInicio = ?, anioInicio = ?, "
                                    + "diaFinal = ?, mesFinal = ?, anioFinal = ? WHERE idCita = "+c.getIdCita());
            pst.setString(1, c.getNombreCliente());
            pst.setString(2, Integer.toString(c.getDiaInicio()));
            pst.setString(3, Integer.toString(c.getMesInicio()));
            pst.setString(4, Integer.toString(c.getAnioInicio()));
            pst.setString(5, Integer.toString(c.getDiaFinal()));
            pst.setString(6, Integer.toString(c.getMesFinal()));
            pst.setString(7, Integer.toString(c.getAnioFinal()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void eliminarCita( int id ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("DELETE FROM cita WHERE idCita = ?" + id);
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
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM producto ORDER BY tipoPro");
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Producto> pd = new ArrayList<>();
            
            if(rs.next()){
                Proveedor p = buscarProveedor(rs.getInt("idProveedorProducto"));
                do{
                    pd.add(new Producto(rs.getInt("idProducto"), rs.getString("modeloPro"), 
                            rs.getString("tipoPro"), rs.getInt("cantidadPro"), 
                            rs.getDouble("precioPro"), p));
                }while(rs.next());
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
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM producto WHERE tipoPro = " + tipoPro + " ORDER BY tipoPro");
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Producto> pd = new ArrayList<>();
            
            if(rs.next()){
                Proveedor p = buscarProveedor(rs.getInt("idProveedorProducto"));
                do{
                    pd.add(new Producto(rs.getInt("idProducto"), rs.getString("modeloPro"), 
                            rs.getString("tipoPro"), rs.getInt("cantidadPro"), 
                            rs.getDouble("precioPro"), p));
                }while(rs.next());
            }
            
            pst.close();
            cn.close();
            return pd;
            
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static void insertarProducto( Producto pro ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?,?)");
            pst.setString(1, "0");
            pst.setString(2, pro.getModeloPro());
            pst.setString(3, pro.getTipoPro());
            pst.setString(4, Integer.toString(pro.getCantidadPro()));
            pst.setString(5, Double.toString(pro.getPrecioPro()));
            pst.setString(6, Integer.toString(pro.getProveedor().getId()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }

    public static Producto buscarProducto( int idPro ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM producto WHERE idProducto = ?");
            pst.setString(1, Integer.toString(idPro));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Proveedor p = buscarProveedor(rs.getInt("idProveedorProducto"));
                Producto pr = new Producto(rs.getInt("idProducto"), rs.getString("modeloPro"),
                        rs.getString("tipoPro"), rs.getInt("cantidadPro"), 
                        rs.getDouble("precioPro"), p);
                pst.close();
                cn.close();
                return pr;
            }
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
        
    public static void modificarProducto(Producto p){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE producto SET modeloPro = ?, tipoPro = ?, cantidadPro = ?, precioPro = ?, idProveedorProducto = ? WHERE idProducto = " + p.getIdPro());
            pst.setString(1, p.getModeloPro());
            pst.setString(2, p.getTipoPro());
            pst.setString(3, Integer.toString(p.getCantidadPro()));
            pst.setString(4, Double.toString(p.getPrecioPro()));
            pst.setString(5, Integer.toString(p.getProveedor().getId()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void eliminarProducto( int idPro ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("DELETE FROM producto WHERE idProducto = " + idPro);
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void actualizarStock(int idPro, int cantidadPro){
        try {
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE producto SET cantidadPro = ? WHERE idProducto = " + idPro);
            
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
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM usuario ORDER BY nombre");
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Usuario> us = new ArrayList<>();
            
            while(rs.next()){
                us.add(new Usuario(rs.getInt("idUsuario"), rs.getString("nombre"), 
                                   rs.getString("ap_paterno"), rs.getString("ap_materno"), 
                                   rs.getString("username")));
            }
            pst.close();
            cn.close();
            return us;
            
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static void insertarUsuario(Usuario u){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO usuario VALUES(?,?,?,?,?,?)");
            pst.setString(1, "0");
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
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM usuario WHERE idUsuario = ?");
            pst.setString(1, Integer.toString(id));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Usuario u = new Usuario(rs.getInt("idUsuario"), rs.getString("nombre"), 
                                   rs.getString("ap_paterno"),rs.getString("ap_paterno"), 
                                   rs.getString("username"));
                pst.close();
                cn.close();
                return u;
            }
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return null;  
    }

    public static void modificarUsuario(Usuario u){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE usuario SET nombre = ?, ap_paterno = ?, ap_materno = ?, pass = ?, username = ? WHERE id = " + u.getId());
            pst.setString(1, u.getNombre());
            pst.setString(2, u.getAp_paterno());
            pst.setString(3, u.getAp_materno());
            pst.setString(4, u.getPass());
            pst.setString(5, u.getUsername());
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }

   }
    
    public static void eliminarUsuario(int id){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("DELETE FROM usuario WHERE idUsuario = " + id);
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static boolean autetnicacion( String username, String pass ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM usuario WHERE username = ?" + username); 
            
            ResultSet rs = pst.executeQuery();
            
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
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM socio ORDER BY nombre");
            
            ResultSet rs = pst.executeQuery();
            
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
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO socio VALUES(?,?,?,?,?)");
            pst.setString(1, "0");
            pst.setString(2, s.getNombre());
            pst.setString(3, s.getContacto());
            if( s.isRango() ){
                pst.setString(4, "0");
            } else {
                pst.setString(4, "1");
            }
            pst.setString(4, Double.toString(s.getTotal()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }

    public static Socio buscarSocio( int id ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM socio WHERE idSocio = ?");
            pst.setString(1, Integer.toString(id));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Socio s = new Socio(rs.getInt("idSocio"), rs.getString("nombre"), 
                                 rs.getString("contacto"), rs.getBoolean("rango"), rs.getDouble("total"));
                pst.close();
                cn.close();
                return s;
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
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE socio SET nombre = ?, contacto = ?, rango = ?, total = ? WHERE idSocio = " + s.getId());
            pst.setString(1, s.getNombre().trim());
            pst.setString(2, s.getContacto().trim());
            if( s.isRango() ){
                pst.setString(3, "0");
            } else {
                pst.setString(3, "1");
            }
            
            pst.setString(4, Double.toString(s.getTotal()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }

    public static void eliminarSocio( int id ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("DELETE FROM socio WHERE idSocio = " + id);
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
     //Proveedor
    public static void insertarProvedor( Proveedor p ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO proveedor VALUES(?,?,?,?,?)");
            pst.setString(1, "0");
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getContacto());
            pst.setString(4, Double.toString(p.getTotal()));
            pst.setString(5, Double.toString(p.getMargen()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static Proveedor buscarProveedor( int idProveedor ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM proveedor WHERE idProveedor = ?");
            pst.setString(1, Integer.toString(idProveedor));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Proveedor p = new Proveedor(rs.getInt("idProveedor"), rs.getString("nombre"), rs.getString("contacto"),
                                    rs.getDouble("margen"), rs.getDouble("total"));
                pst.close();
                cn.close();
                return p;
            }
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }

    public static void modificarProveedor(Proveedor p){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE proveedor SET nombre = ?, contacto = ?, total = ?, margen = ? WHERE idProveedor = " + p.getId());
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getContacto());
            pst.setString(3, Double.toString(p.getTotal()));
            pst.setString(4, Double.toString(p.getMargen()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static ArrayList<Proveedor> getProveedor(){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM proveedor");
            ResultSet rs = pst.executeQuery();
            ArrayList<Proveedor> p = new ArrayList<>();

            if(rs.next()){
                do{
                    p.add(new Proveedor(rs.getInt("idProveedor"), rs.getString("nombre"), rs.getString("contatco"), rs.getDouble("margen"), rs.getDouble("total")));
                }while(rs.next());
            }
            
            pst.close();
            cn.close();
            return p;
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }

    public static void eliminarProveedor( int id ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("DELETE FROM proveedor WHERE idProveedor = " + id);
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }

    //Ticket
    public static Ticket insertarTicket( Ticket t ){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO ticket VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, "");
            if(t.isClip()){
                pst.setString(2, "1");
            }else{
                pst.setString(2, "0");
            }
            if(t.isProd()){
                pst.setString(3, "1");
            }else{
                pst.setString(3, "0");
            }
            pst.setString(4, Double.toString(t.getPagado()));
            pst.setString(5, Double.toString(t.getTotal()));
            pst.setString(6, Integer.toString(t.getTatuador().getId()));
            if(t.isVisita()){
                pst.setString(7, "1");
            }else{
                pst.setString(7, "0");
            }
            pst.setString(8, Double.toString(t.getCambio()));
            System.out.println("Hola");
            pst.executeUpdate();
            ResultSet rs = pst.executeQuery("SELECT MAX(idTicket) FROM ticket");
            rs.next();
            System.out.println("Id: "+rs.getInt(1));
            t = buscarTicket( rs.getInt(1) );
            pst.close();
            cn.close();
            return t;
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }

    private static ArrayList<Producto> getVentas( int idTicket ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT idProductoVenta FROM venta WHERE idTicketVenta = "+idTicket);
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Producto> p = new ArrayList<>();
            while(rs.next()){
                p.add(buscarProducto(rs.getInt("idProductoVenta")));
            }
            cn.close();
            pst.close();
            return p;
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static Ticket buscarTicket( int idTicket ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM ticket WHERE idTicket = ?");
            pst.setString(1, Integer.toString(idTicket));
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Producto> p;
            
            if(rs.next()){
                p = getVentas(rs.getInt("idTicket"));
                Tatuador t = buscarTatuador(rs.getInt("idTatuadorTicket"));
                Ticket ti = new Ticket(rs.getInt("idTicket"), rs.getBoolean("clip"), 
                        rs.getBoolean("prod"), rs.getDouble("pagado"), 
                        rs.getDouble("total"), t, rs.getBoolean("visita"),
                        rs.getDouble("cambio"), p);
                pst.close();
                cn.close();
                return ti;
            }
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }

    
    public static void modificarTicket(Ticket t){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE ticket SET clip = ?, prod = ?, pagado = ?, total = ?, idTatuadorTicket = ?, visita = ?, cambio = ? WHERE idProveedor = " + t.getId());
            
            if(t.isClip())
                pst.setString(1, "1");
            else
                pst.setString(1, "0");
            
            if(t.isProd())
                pst.setString(2, "1");
            else
                pst.setString(2, "0");

            pst.setString(3, Double.toString(t.getPagado()));
            pst.setString(4, Double.toString(t.getTotal()));
            pst.setString(5, Integer.toString(t.getTatuador().getId()));
            
            if(t.isVisita())
                pst.setString(6, "1");
            else
                pst.setString(6, "0");

            pst.setString(7, Double.toString(t.getCambio()));

            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    /*
    public static void main(String a[]){
        Tatuador t1 = new Tatuador("Marco","Piña","Rossette","5530070601",1,7.4);
        Tatuador t2 = new Tatuador("Marco","Piña","Hernandez","5525636646",2,34.4);
        Tatuador t3 = new Tatuador("Marco","Piña","Martinez","5525648792",3,123.4);
        Tatuador t4 = new Tatuador("Alejandra","Rossette","Meneses","5538934171",1,45.4);
        
        Proveedor pr1 = new Proveedor("BLK","BLK@outlook.com",2.5,67.9);
        Proveedor pr2 = new Proveedor("PLK","PLK@outlook.com",12.2,34.2);
        Proveedor pr3 = new Proveedor("ALK","ALK@outlook.com",6.5,45.2);
        Producto p1 = new Producto(1,"Chamarra","BLK0001",3,2.4,pr1);
        Producto p2 = new Producto(2,"Pantalon","BLK0002",5,2.4,pr2);
        Producto p3 = new Producto(3,"Playera","BLK0003",7,2.4,pr3);
        Producto p4 = new Producto(4,"Gorra","BLK0004",8,2.4,pr1);
        Producto p5 = new Producto(5,"Tennis","BLK0005",1,2.4,pr1);
        /*
        Socio s = new Socio(1,"nombre","contacto",true,234.5);
        Usuario u = new Usuario(1, "nombre","appat","apmat","username","pass");
        Cita c = new Cita("Marco",1,1,1,1,1,1,18);
        
        
        ArrayList<Producto> ps = new ArrayList<>();
        ps.add(p);
        */
        /*
        Model.insertarTatuador(t1);
        Model.insertarTatuador(t2);
        Model.insertarTatuador(t3);
        Model.insertarTatuador(t4);
        */
        /*
        Model.insertarProvedor(pr1);
        Model.insertarProvedor(pr2);
        Model.insertarProvedor(pr3);
        */
        /*
        Model.insertarProducto(p1);
        Model.insertarProducto(p2);
        Model.insertarProducto(p3);
        Model.insertarProducto(p4);
        Model.insertarProducto(p5);
        //Model.insertarCita(c);
        //Model.insertarProducto(p);
        //Model.insertarProvedor(pr);
        //Model.insertarUsuario(u);
        //Model.insertarSocio(s);
        //Ticket t = Model.insertarTicket(new Ticket(true,true,20.3,50.9,ta,true,23.5,ps));
        
        //System.out.println("Id: "+t.getId());
    }
    */
}