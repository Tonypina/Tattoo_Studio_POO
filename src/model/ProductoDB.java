/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.*;
import objects.*;

/**
 *
 * @author Mapina
 */
public class ProductoDB {
    protected static ArrayList<Producto> get(){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM producto ORDER BY tipoPro");
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Producto> pd = new ArrayList<>();
            
            if(rs.next()){
                Proveedor p = ProveedorDB.buscar(rs.getInt("idProveedorProducto"));
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
    
    protected static ArrayList<Producto> get( String tipoPro ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM producto WHERE tipoPro = " + tipoPro + " ORDER BY tipoPro");
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Producto> pd = new ArrayList<>();
            
            if(rs.next()){
                Proveedor p = ProveedorDB.buscar(rs.getInt("idProveedorProducto"));
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
    
    protected static void insertar( Producto pro ){
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

    protected static Producto buscar( int idPro ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM producto WHERE idProducto = ?");
            pst.setString(1, Integer.toString(idPro));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Proveedor p = ProveedorDB.buscar(rs.getInt("idProveedorProducto"));
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
        
    protected static void modificar(Producto p){
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
    
    protected static void eliminar( int idPro ){
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
    
    protected static void actualizarStock(int idPro, int cantidadPro){
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
}
