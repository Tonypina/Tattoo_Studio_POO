/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;
import java.sql.*;
import java.util.*;
import objects.*;
/**
 *
 * @author
 */
public class TatuadorDB {
    
    public static ArrayList<Tatuador> get(){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM tatuador WHERE eliminado = 0 ORDER BY idTatuador");
            
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
    
    public static void insertar( Tatuador t ){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");            
            PreparedStatement pst = cn.prepareStatement("INSERT INTO tatuador VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, "0");
            pst.setString(2, t.getNombre());
            pst.setString(3, t.getAp_pat());
            pst.setString(4, t.getAp_mat());
            pst.setString(5, t.getContacto());
            pst.setString(6, Integer.toString(t.getRango()));
            pst.setString(7, Double.toString(t.getTotal()));
            pst.setString(8, "0");
            pst.executeUpdate();
            
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static Tatuador buscar( int id ){
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
    
    public static ArrayList<Tatuador> buscar( String nombre ){
        try{
            Connection cn = Conexion.getConnection();
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
    
    public static void modificar( Tatuador t ){
        try{
            Connection cn = Conexion.getConnection();
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
    
    public static void eliminar( int id ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("UPDATE tatuador SET eliminado = 1 WHERE idTatuador = " + id);
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
}
