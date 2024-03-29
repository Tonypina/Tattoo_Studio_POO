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
 * @author Mapina
 */
public class ProductoDB {
    public static ArrayList<Producto> get(){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM producto WHERE eliminado = 0 ORDER BY modeloPro");
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Producto> pd = new ArrayList<>();
            
            if(rs.next()){
                Proveedor p = ProveedorDB.buscar(rs.getInt("idProveedorProducto"));
                do{
                    pd.add(new Producto(rs.getInt("idProducto"), rs.getString("modeloPro"), 
                            rs.getString("tipoPro"), rs.getInt("cantidadPro"), 
                            rs.getDouble("precioPro"), p, rs.getDouble("costoPro"), rs.getBoolean("perfo")));
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
    
    public static ArrayList<Producto> get( String tipoPro ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM producto WHERE tipoPro = ? AND eliminado = 0 ORDER BY tipoPro");
            pst.setString(1, tipoPro);
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Producto> pd = new ArrayList<>();
            
            if(rs.next()){
                Proveedor p = ProveedorDB.buscar(rs.getInt("idProveedorProducto"));
                do{
                    pd.add(new Producto(rs.getInt("idProducto"), rs.getString("modeloPro"), 
                            rs.getString("tipoPro"), rs.getInt("cantidadPro"), 
                            rs.getDouble("precioPro"), p, rs.getDouble("costoPro"), rs.getBoolean("perfo")));
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
    
    public static ArrayList<Producto> get( int idProveedor ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM producto WHERE eliminado = 0 AND idProveedorProducto = ?");
            pst.setString(1, Integer.toString(idProveedor));
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Producto> pd = new ArrayList<>();
            
            if(rs.next()){
                Proveedor p = ProveedorDB.buscar(rs.getInt("idProveedorProducto"));
                do{
                    pd.add(new Producto(rs.getInt("idProducto"), rs.getString("modeloPro"), 
                            rs.getString("tipoPro"), rs.getInt("cantidadPro"), 
                            rs.getDouble("precioPro"), p, rs.getDouble("costoPro"), rs.getBoolean("perfo")));
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
    
    public static void insertar( Producto pro ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, "0");
            pst.setString(2, pro.getModeloPro());
            pst.setString(3, pro.getTipoPro());
            pst.setString(4, Integer.toString(pro.getCantidadPro()));
            pst.setString(5, Double.toString(pro.getPrecioPro()));
            pst.setString(6, Double.toString(pro.getCostoPro()));
            if(pro.isPerfo())
                pst.setString(7, "1");
            else
                pst.setString(7, "0");
            
            pst.setString(8, Integer.toString(pro.getProveedor().getId()));
            pst.setString(9, "0");
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }

    public static Producto buscar( int idPro ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM producto WHERE idProducto = ?");
            pst.setString(1, Integer.toString(idPro));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Proveedor p = ProveedorDB.buscar(rs.getInt("idProveedorProducto"));
                Producto pr = new Producto(rs.getInt("idProducto"), rs.getString("modeloPro"),
                        rs.getString("tipoPro"), rs.getInt("cantidadPro"), 
                        rs.getDouble("precioPro"), p, rs.getDouble("costoPro"), rs.getBoolean("perfo"));
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
        
    public static void modificar(Producto p){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("UPDATE producto SET modeloPro = ?, tipoPro = ?, cantidadPro = ?, precioPro = ?, costoPro = ?, perfo = ?, idProveedorProducto = ? WHERE idProducto = ?");
            pst.setString(1, p.getModeloPro());
            pst.setString(2, p.getTipoPro());
            pst.setString(3, Integer.toString(p.getCantidadPro()));
            pst.setString(4, Double.toString(p.getPrecioPro()));
            pst.setString(5, Double.toString(p.getCostoPro()));

            if(p.isPerfo())
                pst.setString(6, "1");
            else
                pst.setString(6, "0");
            
            pst.setString(7, Integer.toString(p.getProveedor().getId()));
            pst.setString(8, Integer.toString(p.getIdPro()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void eliminar( int idPro ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("UPDATE producto SET eliminado = 1 WHERE idProducto = ?");
            pst.setString(1, Integer.toString(idPro));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void actualizarStock(int idPro, int cantidadPro){
        try {
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("UPDATE producto SET cantidadPro = ? WHERE idProducto = ?");
            
            pst.setString(1, Integer.toString(cantidadPro));
            pst.setString(2, Integer.toString(idPro));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e ){
            e.getMessage();
        }
    }
}
