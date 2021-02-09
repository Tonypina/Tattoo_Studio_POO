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
public class TicketDB {
    
    public static ArrayList<Ticket> get(){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM ticket");
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Ticket> lti = new ArrayList<>();
            ArrayList<Producto> p;
            
            if(rs.next()){
                do{
                    p = getVentas(rs.getInt("idTicket"));
                    Tatuador t = TatuadorDB.buscar(rs.getInt("idTatuadorTicket"));
                    Proveedor pr = ProveedorDB.buscar(rs.getInt("idPerforadorTicket"));
                    Ticket ti = new Ticket(rs.getInt("idTicket"), rs.getBoolean("clip"), 
                            rs.getBoolean("prod"), rs.getDouble("subtotalTatuaje"), rs.getDouble("subtotalPerforacion"), 
                            rs.getDouble("total"), rs.getInt("dia"),
                            rs.getInt("mes"), rs.getInt("anio"),
                            t, pr, rs.getBoolean("visita"), p);
                    lti.add(ti);
                }while(rs.next());
            }
            
            pst.close();
            cn.close();
            return lti;
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public static Ticket insertar( Ticket t ){
        try{
            Calendar c = Calendar.getInstance();

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO ticket VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, "0");
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
            pst.setString(4, Double.toString(t.getSubtotalTatuaje()));
            pst.setString(5, Double.toString(t.getSubtotalPerforacion()));
            pst.setString(6, Double.toString(t.getTotal()));

            if(t.isVisita()){
                pst.setString(7, "1");
            }else{
                pst.setString(7, "0");
            }
            pst.setString(8, Integer.toString(c.get(Calendar.DATE)));
            pst.setString(9, Integer.toString(c.get(Calendar.MONTH)));
            pst.setString(10, Integer.toString(c.get(Calendar.YEAR)));
            pst.setString(11, Integer.toString(t.getTatuador().getId()));
            pst.setString(12, Integer.toString(t.getPerforador().getId()));
            pst.executeUpdate();
            ResultSet rs = pst.executeQuery("SELECT MAX(idTicket) FROM ticket");
            rs.next();
            Ticket ti = buscar( rs.getInt(1) );
            for (Producto p : t.getProductos()) {
                pst = cn.prepareStatement("INSERT INTO venta VALUES(?,?,?,?)");
                pst.setString(1, "0");
                pst.setString(2, "1");
                pst.setString(3, Integer.toString(p.getIdPro()));
                pst.setString(4, Integer.toString(ti.getId()));
                pst.executeUpdate();
            }
            pst.close();
            cn.close();
            return t;
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static int getMinAnio(){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT MIN(anio) FROM ticket");
            ResultSet rs = pst.executeQuery();
            rs.next();
            int anio = rs.getInt(1);
            return anio;
        }catch(Exception e){
            e.getMessage();
        }
        return 0;
    }

    public static ArrayList<Producto> getVentas( int idTicket ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT idProductoVenta FROM venta WHERE idTicketVenta = "+Integer.toString(idTicket));
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
    
    public static Ticket buscar( int idTicket ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM ticket WHERE idTicket = ?");
            pst.setString(1, Integer.toString(idTicket));
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Producto> p;
            
            if(rs.next()){
                p = getVentas(rs.getInt("idTicket"));
                Tatuador t = TatuadorDB.buscar(rs.getInt("idTatuadorTicket"));
                Proveedor pr = ProveedorDB.buscar(rs.getInt("idPerforadorTicket"));
                Ticket ti = new Ticket(rs.getInt("idTicket"), rs.getBoolean("clip"), 
                        rs.getBoolean("prod"), rs.getDouble("subtotalTatuaje"), rs.getDouble("subtotalPerforacion"), 
                        rs.getDouble("total"), rs.getInt("dia"),
                        rs.getInt("mes"), rs.getInt("anio"),
                        t, pr, rs.getBoolean("visita"), p);
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
    
    public static ArrayList<Ticket> get( int dia, int mes, int anio ){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst;
            
            if(dia == 0){
                pst = cn.prepareStatement("SELECT * FROM ticket WHERE mes  = ? AND anio = ?");
                pst.setString(1, Integer.toString(mes));
                pst.setString(2, Integer.toString(anio));
            } else if(dia == 0 && mes == 0){
                pst = cn.prepareStatement("SELECT * FROM ticket WHERE anio = ?");
                pst.setString(1, Integer.toString(anio));
            } else {
                pst = cn.prepareStatement("SELECT * FROM ticket WHERE dia = ? AND mes = ? AND anio = ?");
                pst.setString(1, Integer.toString(dia));
                pst.setString(2, Integer.toString(mes));
                pst.setString(3, Integer.toString(anio));
            }
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Producto> p;
            ArrayList<Ticket> lti = new ArrayList<>();
            if(rs.next()){
                do{
                    p = getVentas(rs.getInt("idTicket"));
                    Tatuador t = TatuadorDB.buscar(rs.getInt("idTatuadorTicket"));
                    Proveedor pr = ProveedorDB.buscar(rs.getInt("idPerforadorTicket"));
                    Ticket ti = new Ticket(rs.getInt("idTicket"), rs.getBoolean("clip"), 
                            rs.getBoolean("prod"), rs.getDouble("subtotalTatuaje"), rs.getDouble("subtotalPerforacion"), 
                            rs.getDouble("total"), rs.getInt("dia"),
                            rs.getInt("mes"), rs.getInt("anio"),
                            t, pr, rs.getBoolean("visita"), p);
                    lti.add(ti);
                }while(rs.next());
            }
            pst.close();
            cn.close();
            
            return lti;
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
 
    public static void modificar(Ticket t){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("UPDATE ticket SET clip = ?, prod = ?, total = ?, idTatuadorTicket = ?, visita = ? WHERE idTicket = " + t.getId());
            
            if(t.isClip())
                pst.setString(1, "1");
            else
                pst.setString(1, "0");
            
            if(t.isProd())
                pst.setString(2, "1");
            else
                pst.setString(2, "0");

            pst.setString(3, Double.toString(t.getTotal()));
            pst.setString(4, Integer.toString(t.getTatuador().getId()));
            
            if(t.isVisita())
                pst.setString(5, "1");
            else
                pst.setString(5, "0");

            pst.executeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }

}
