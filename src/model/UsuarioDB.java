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
public class UsuarioDB {
    
    protected static ArrayList<Usuario> get(){
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
    
    protected static void insertar(Usuario u){
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
    
    protected static Usuario buscar(int id) {  
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

    protected static void modificar(Usuario u){
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
    
    protected static void eliminar(int id){
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
    
    protected static boolean autenticacion( String username, String pass ){
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
}
