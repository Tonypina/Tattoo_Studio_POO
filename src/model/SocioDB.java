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
public class SocioDB {
    
    protected static ArrayList<Socio> get(){
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

    protected static void insertar( Socio s ){
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

    protected static Socio buscar( int id ){
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

    protected static void modificar( Socio s ){
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

    protected static void eliminar( int id ){
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
}
