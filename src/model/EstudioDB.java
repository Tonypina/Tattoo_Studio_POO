/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

/**
 *
 * @author Mapina
 */
public class EstudioDB {
    
    protected static void aumentarGanancia( double aumento ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
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
    
    protected static double obtenerGanancia(){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
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
    
    protected static double obtenerReinversion(){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
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
    
    protected static void aumentarReinversion( double aumento ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
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
    
    protected static double obtenerPagoProveedores(){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
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
    
    protected static void aumentarPagoProveedores( double aumento ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
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
    
}
