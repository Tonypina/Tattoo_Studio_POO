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
public class UsuarioDB {
    
    public static ArrayList<Usuario> get(){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM usuario ORDER BY nombre");
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Usuario> us = new ArrayList<>();
            
            while(rs.next()){
                us.add(new Usuario(rs.getInt("idUsuario"), rs.getString("nombre"), 
                                   rs.getString("ap_paterno"), rs.getString("ap_materno"), 
                                   rs.getBoolean("super"), rs.getString("username")));
            }
            pst.close();
            cn.close();
            return us;
            
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static void insertar(Usuario u){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO usuario VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, "0");
            pst.setString(2, u.getNombre());
            pst.setString(3, u.getAp_paterno());
            pst.setString(4, u.getAp_materno());
            if(u.getRango()){
                pst.setString(5, "1");
            } else {
                pst.setString(5, "0");
            }
            pst.setString(6, u.getPass());
            pst.setString(7, u.getUsername());
            System.out.println("Antes del update.");
            pst.executeUpdate();
            
            pst.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("No se pudo insertar");
            e.getMessage();
        }
    }
    
    public static Usuario buscar(int id) {  
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM usuario WHERE idUsuario = ?");
            pst.setString(1, Integer.toString(id));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Usuario u = new Usuario(rs.getInt("idUsuario"), rs.getString("nombre"), 
                                   rs.getString("ap_paterno"),rs.getString("ap_paterno"), 
                                   rs.getBoolean("super"), rs.getString("username"));
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
    
    public static Usuario buscar(String username) {  
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM usuario WHERE username = ?");
            pst.setString(1, username);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Usuario u = new Usuario(rs.getInt("idUsuario"), rs.getString("nombre"), 
                                   rs.getString("ap_paterno"),rs.getString("ap_paterno"), 
                                   rs.getBoolean("super"), rs.getString("username"), rs.getString("pass"));
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

    public static void modificar(Usuario u){
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
    
    public static void eliminar(int id){
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
    
    public static boolean autenticacion( String username, String pass ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM usuario WHERE username = ?"); 
            pst.setString(1, username);
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
}
