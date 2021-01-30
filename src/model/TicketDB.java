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
public class TicketDB {
    
    protected static Ticket insertar( Ticket t ){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO ticket VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, "");
            if(t.isClip()){
                pst.setString(2, "1");
            }else{
                pst.setString(2, "0");
            }
            if(t.isProd()){
                pst.setString(3, "1");
            }else{
                pst.setString(3, "0");
            }
            pst.setString(4, Double.toString(t.getPagado()));
            pst.setString(5, Double.toString(t.getTotal()));
            pst.setString(6, Integer.toString(t.getTatuador().getId()));
            if(t.isVisita()){
                pst.setString(7, "1");
            }else{
                pst.setString(7, "0");
            }
            pst.setString(8, Double.toString(t.getCambio()));
            pst.executeUpdate();
            ResultSet rs = pst.executeQuery("SELECT MAX(idTicket) FROM ticket");
            rs.next();
            t = buscar( rs.getInt(1) );
            pst.close();
            cn.close();
            return t;
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }

    protected static ArrayList<Producto> getVentas( int idTicket ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT idProductoVenta FROM venta WHERE idTicketVenta = "+idTicket);
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Producto> p = new ArrayList<>();
            while(rs.next()){
                p.add(ProductoDB.buscar(rs.getInt("idProductoVenta")));
            }
            cn.close();
            pst.close();
            return p;
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    protected static Ticket buscar( int idTicket ){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM ticket WHERE idTicket = ?");
            pst.setString(1, Integer.toString(idTicket));
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Producto> p;
            
            if(rs.next()){
                p = getVentas(rs.getInt("idTicket"));
                Tatuador t = TatuadorDB.buscar(rs.getInt("idTatuadorTicket"));
                Ticket ti = new Ticket(rs.getInt("idTicket"), rs.getBoolean("clip"), 
                        rs.getBoolean("prod"), rs.getDouble("pagado"), 
                        rs.getDouble("total"), t, rs.getBoolean("visita"),
                        rs.getDouble("cambio"), p);
                pst.close();
                cn.close();
                return ti;
            }
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
 
    protected static void modificar(Ticket t){
        try{
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE ticket SET clip = ?, prod = ?, pagado = ?, total = ?, idTatuadorTicket = ?, visita = ?, cambio = ? WHERE idProveedor = " + t.getId());
            
            if(t.isClip())
                pst.setString(1, "1");
            else
                pst.setString(1, "0");
            
            if(t.isProd())
                pst.setString(2, "1");
            else
                pst.setString(2, "0");

            pst.setString(3, Double.toString(t.getPagado()));
            pst.setString(4, Double.toString(t.getTotal()));
            pst.setString(5, Integer.toString(t.getTatuador().getId()));
            
            if(t.isVisita())
                pst.setString(6, "1");
            else
                pst.setString(6, "0");

            pst.setString(7, Double.toString(t.getCambio()));

            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
}
