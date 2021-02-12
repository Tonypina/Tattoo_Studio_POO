/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

import java.sql.*;

/**
 *
 * @author Mapina
 */
public class EstudioDB {
    
    public static void aumentarGanancia( double aumento ){
        try{
            Connection cn = Conexion.getConnection();
            double ganancia = obtenerGanancia();
            PreparedStatement pst = cn.prepareStatement("UPDATE estudio SET ganancia = ? WHERE idEstudio = 1");
            pst.setString(1, Double.toString(aumento+ganancia));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static double obtenerGanancia(){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM estudio WHERE idEstudio = 1");
            ResultSet rs = pst.executeQuery();
            Double ganancia = rs.getDouble("ganancia");
            cn.close();
            pst.close();
            return ganancia;
        }catch(SQLException e){
            e.getMessage();
        }
        return 0.0;
    }
    
    public static double obtenerReinversion(){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM estudio WHERE idEstudio = 1");
            ResultSet rs = pst.executeQuery();
            Double reinversion = rs.getDouble("reinversion");
            cn.close();
            pst.close();
            return reinversion;
        }catch(SQLException e){
            e.getMessage();
        }
        return 0.0;
    }
    
    public static void aumentarReinversion( double aumento ){
        try{
            Connection cn = Conexion.getConnection();
            double reinversion = obtenerReinversion();
            PreparedStatement pst = cn.prepareStatement("UPDATE estudio SET reinversion = ? WHERE idEstudio = 1");
            pst.setString(1, Double.toString(reinversion+aumento));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static double obtenerPagoProveedores(){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM estudio WHERE idEstudio = 1");
            ResultSet rs = pst.executeQuery();
            Double pagoProveedores = rs.getDouble("pagoProveedores");
            cn.close();
            pst.close();
            return pagoProveedores;
        }catch(SQLException e){
            e.getMessage();
        }
        return 0.0;
    }
    
    public static void aumentarPagoProveedores( double aumento ){
        try{
            Connection cn = Conexion.getConnection();
            double pagoProveedores = obtenerPagoProveedores();
            PreparedStatement pst = cn.prepareStatement("UPDATE estudio SET pagoProveedores = ? WHERE idEstudio = 1");
            pst.setString(1, Double.toString(pagoProveedores+aumento));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public static double getClip(){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT clip FROM estudio");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                double clip = rs.getDouble(1);
                pst.close();
                cn.close();
                return clip;
            }
            pst.close();
            cn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0.0;
    }
    
    public static void setClip(double clip){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("UPDATE estudio SET clip = ? WHERE idEstudio = 1");
            pst.setString(1, Double.toString(clip));
            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
}
