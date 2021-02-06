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
public class CitaDB {
    
    public static ArrayList<Cita> get( int idTatuador ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM cita WHERE idTatuadorCita = " + idTatuador + " ORDER BY nomClienteCita");
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                ArrayList<Cita> ac = new ArrayList<>();
                while(rs.next()){
                    ac.add(new Cita(rs.getInt("idCita"), rs.getString("nomClienteCita"), 
                            rs.getInt("diaInicio"), rs.getInt("mesInicio"), 
                            rs.getInt("anioInicio"), rs.getInt("idTatuador")));
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
    
    public static ArrayList<Cita> get( ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM cita ORDER BY nomClienteCita");
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                ArrayList<Cita> ac = new ArrayList<>();
                while(rs.next()){
                    ac.add(new Cita(rs.getInt("idCita"), rs.getString("nomClienteCita"), 
                            rs.getInt("diaInicio"), rs.getInt("mesInicio"), 
                            rs.getInt("anioInicio"), rs.getInt("idTatuador")));
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
    
    public static ArrayList<Cita> get( int dia, int mes, int anio ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM cita WHERE diaInicio = ? AND mesInicio = ? AND anioInicio = ?");
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                ArrayList<Cita> ac = new ArrayList<>();
                while(rs.next()){
                    ac.add(new Cita(rs.getInt("idCita"), rs.getString("nomClienteCita"), 
                            rs.getInt("dia"), rs.getInt("mes"), 
                            rs.getInt("anio"), rs.getInt("idTatuador")));
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
    
    public static void insertar( Cita c ){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO cita VALUES(?,?,?,?,?,?)");
            pst.setString(1, "0");
            pst.setString(2, c.getNombreCliente());
            pst.setString(3, Integer.toString(c.getDiaInicio()));
            pst.setString(4, Integer.toString(c.getMesInicio()));
            pst.setString(5, Integer.toString(c.getAnioInicio()));
            pst.setString(6, Integer.toString(c.getIdTatuador()));
            pst.executeUpdate();
            
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void modificar( Cita c ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE cita SET nomClienteCita = ?, "
                                    + "diaInicio = ?, mesInicio = ?, anioInicio = ? "
                                    + "WHERE idCita = "+c.getIdCita());
            pst.setString(1, c.getNombreCliente());
            pst.setString(2, Integer.toString(c.getDiaInicio()));
            pst.setString(3, Integer.toString(c.getMesInicio()));
            pst.setString(4, Integer.toString(c.getAnioInicio()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void eliminar( int id ){
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
}
