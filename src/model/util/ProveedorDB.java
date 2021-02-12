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
public class ProveedorDB {
    
    public static void insertar( Proveedor p ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("INSERT INTO proveedor VALUES(?,?,?,?,?)");
            pst.setString(1, "0");
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getContacto());
            pst.setString(4, Double.toString(p.getTotal()));
            pst.setString(5, "0");
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static Proveedor buscar( int idProveedor ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM proveedor WHERE idProveedor = ?");
            pst.setString(1, Integer.toString(idProveedor));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Proveedor p = new Proveedor(rs.getInt("idProveedor"), rs.getString("nombre"), 
                        rs.getString("contacto"), rs.getDouble("total"));
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
    
    public static Proveedor buscar( String nombre ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM proveedor WHERE nombre = ?");
            pst.setString(1, nombre);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Proveedor p = new Proveedor(rs.getInt("idProveedor"), rs.getString("nombre"), 
                        rs.getString("contacto"), rs.getDouble("total"));
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

    public static void modificar(Proveedor p){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("UPDATE proveedor SET nombre = ?, contacto = ?, total = ? WHERE idProveedor = " + p.getId());
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getContacto());
            pst.setString(3, Double.toString(p.getTotal()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static ArrayList<Proveedor> get(){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM proveedor WHERE eliminado = 0");
            ResultSet rs = pst.executeQuery();
            ArrayList<Proveedor> p = new ArrayList<>();

            if(rs.next()){
                do{
                    p.add(new Proveedor(rs.getInt("idProveedor"), rs.getString("nombre"), 
                            rs.getString("contacto"), rs.getDouble("total")));
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

    public static void eliminar( int id ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("UPDATE proveedor SET eliminado =10 WHERE idProveedor = ?");
            pst.setString(1, Integer.toString(id));
            pst.executeUpdate();
            pst = cn.prepareStatement("UPDATE producto SET eliminado = 1 WHERE idProveedorProducto = ?");
            pst.setString(1, Integer.toString(id));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
}
