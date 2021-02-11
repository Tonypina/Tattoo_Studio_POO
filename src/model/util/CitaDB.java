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
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM cita WHERE idTatuadorCita = " + Integer.toString(idTatuador) + " ORDER BY nomClienteCita");
            
            ResultSet rs = pst.executeQuery();

            ArrayList<Cita> ac = new ArrayList<>();

            if(rs.next()){
                do{
                    ac.add(new Cita(rs.getInt("idCita"), rs.getString("nomClienteCita"), 
                            rs.getInt("dia"), rs.getInt("mes"), 
                            rs.getInt("anio"), rs.getInt("hora"), 
                            rs.getInt("minutos"), rs.getInt("idTatuadorCita")));
                }while(rs.next());
            }
            
            pst.close();
            cn.close();
            return ac;
            
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static ArrayList<Cita> get(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM cita");

            ResultSet rs = pst.executeQuery();

            ArrayList<Cita> ac = new ArrayList<>();

            if(rs.next()){
                do{
                    ac.add(new Cita(rs.getInt("idCita"), rs.getString("nomClienteCita"), 
                            rs.getInt("dia"), rs.getInt("mes"), 
                            rs.getInt("anio"), rs.getInt("hora"), 
                            rs.getInt("minutos"), rs.getInt("idTatuadorCita")));
                }while(rs.next());
            }
            
            pst.close();
            cn.close();
            return ac;
            
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static ArrayList<Cita> get( int dia, int mes, int anio ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM cita WHERE dia = ? AND mes = ? AND anio = ?");
            pst.setString(1, Integer.toString(dia));
            pst.setString(2, Integer.toString(mes));
            pst.setString(3, Integer.toString(anio));
            ResultSet rs = pst.executeQuery();

            ArrayList<Cita> ac = new ArrayList<>();

            if(rs.next()){
                do{
                    ac.add(new Cita(rs.getInt("idCita"), rs.getString("nomClienteCita"), 
                            rs.getInt("dia"), rs.getInt("mes"), 
                            rs.getInt("anio"), rs.getInt("hora"), 
                            rs.getInt("minutos"), rs.getInt("idTatuadorCita")));
                }while(rs.next());
            }
            
            pst.close();
            cn.close();
            return ac;
        
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static void insertar( Cita c ){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO cita VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, "0");
            pst.setString(2, c.getNombreCliente());
            pst.setString(3, Integer.toString(c.getDiaInicio()));
            pst.setString(4, Integer.toString(c.getMesInicio()));
            pst.setString(5, Integer.toString(c.getAnioInicio()));
            pst.setString(6, Integer.toString(c.getHora()));
            pst.setString(7, Integer.toString(c.getMinutos()));
            pst.setString(8, Integer.toString(c.getIdTatuador()));
            pst.executeUpdate();
            
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static void modificar( Cita c ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("UPDATE cita SET nomClienteCita = ?, "
                                    + "dia = ?, mes = ?, anio = ?, hora = ?, minutos = ?, idTatuadorCita = ? "
                                    + "WHERE idCita = ?");
            pst.setString(1, c.getNombreCliente());
            pst.setString(2, Integer.toString(c.getDiaInicio()));
            pst.setString(3, Integer.toString(c.getMesInicio()));
            pst.setString(4, Integer.toString(c.getAnioInicio()));
            pst.setString(5, Integer.toString(c.getHora()));
            pst.setString(6, Integer.toString(c.getMinutos()));
            pst.setString(7, Integer.toString(c.getIdTatuador()));
            pst.setString(8, Integer.toString(c.getIdCita()));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void eliminar( int id ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("DELETE FROM cita WHERE idCita = ?");
            pst.setString(1, Integer.toString(id));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
}
