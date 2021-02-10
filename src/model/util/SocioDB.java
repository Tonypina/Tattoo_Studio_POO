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
public class SocioDB {
    
    public static ArrayList<Socio> get(){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM socio");
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Socio> so = new ArrayList<>();
            
            if(rs.next()){                
                do{
                    so.add(new Socio( rs.getInt("idSocio"), rs.getString("nombre"), 
                                      rs.getString("contacto"), rs.getBoolean("rango"), rs.getDouble("total")));
                }while(rs.next());
            }
            
            pst.close();
            cn.close();
            return so;
            
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }

    public static void insertar( Socio s ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("INSERT INTO socio VALUES(?,?,?,?,?)");
            pst.setString(1, "0");
            pst.setString(2, s.getNombre());
            pst.setString(3, s.getContacto());
            if( s.isRango() ){
                pst.setString(4, "1");
            } else {
                pst.setString(4, "0");
            }
            pst.setString(5, Double.toString(s.getTotal()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }

    public static Socio buscar( int id ){
        try{
            Connection cn = Conexion.getConnection();
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

    public static void modificar( Socio s ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("UPDATE socio SET nombre = ?, contacto = ?, rango = ?, total = ? WHERE idSocio = ?");
            pst.setString(1, s.getNombre());
            pst.setString(2, s.getContacto());
            if( s.isRango() ){
                pst.setString(3, "0");
            } else {
                pst.setString(3, "1");
            }
            
            pst.setString(4, Double.toString(s.getTotal()));
            pst.setString(5, Integer.toString(s.getId()));
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
            PreparedStatement pst = cn.prepareStatement("DELETE FROM socio WHERE idSocio = ?");
            pst.setString(1, Integer.toString(id));
            pst.executeUpdate();
            pst.close();
            cn.close(); 
        }catch(SQLException e){
            e.getMessage();
        }
    }
}
