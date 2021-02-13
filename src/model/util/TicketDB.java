/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;
import java.sql.*;
import java.util.*;
import model.Model;
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
                            rs.getDouble("pagoTatuador"), rs.getDouble("pagoPerforador"),
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
    
    public static double getTotal(int dia, int mes, int anio){
        try{
            Connection cn = Conexion.getConnection();
            CallableStatement cst = cn.prepareCall("CALL obtener_total(?,?,?)");
            cst.setString(1, Integer.toString(dia));
            cst.setString(2, Integer.toString(mes));
            cst.setString(3, Integer.toString(anio));
            ResultSet rs = cst.executeQuery();
            if(rs.next()){
                double i = rs.getDouble(1);
                cst.close();
                cn.close();
                return i;
            }
            cst.close();
            cn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }
    
    public static Ticket insertar( Ticket t ){
        try{
            Calendar c = Calendar.getInstance();

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tattoo_studio_db", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO ticket VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
            pst.setString(6, Double.toString(t.getPagoTatuador()));
            pst.setString(7, Double.toString(t.getPagoPerforador()));
            pst.setString(8, Double.toString(t.getTotal()));
            
            if(t.isClip()){
                pst.setString(9, Double.toString(t.getTotal()*Model.getClip()));
            } else {
                pst.setString(9, "0");
            }
                
            if(t.isVisita()){
                pst.setString(10, "1");
            }else{
                pst.setString(10, "0");
            }
            pst.setString(11, Integer.toString(c.get(Calendar.DATE)));
            pst.setString(12, Integer.toString(c.get(Calendar.MONTH)+1));
            pst.setString(13, Integer.toString(c.get(Calendar.YEAR)));
            if(t.getTatuador() != null)
                pst.setString(14, Integer.toString(t.getTatuador().getId()));
            else
                pst.setString(14, "0");
            
            if(t.getPerforador() != null)
                pst.setString(15, Integer.toString(t.getPerforador().getId()));
            else
                pst.setString(15, "0");
            pst.executeUpdate();
            
            pst = cn.prepareStatement("SELECT MAX(idTicket) AS max FROM ticket");
            ResultSet rs = pst.executeQuery();
            rs.next();
            Ticket ti = buscar( rs.getInt("max") );
            int idTemp = 0;
            for (Producto p : t.getProductos()) {
                if(idTemp == p.getIdPro()){
                    pst = cn.prepareStatement("UPDATE venta SET cantidad = cantidad + ?, costoTotal = costoTotal + ?, precioTotal = precioTotal + ? WHERE idTicketVenta = ?");
                    pst.setString(1, "1");
                    pst.setString(2, Double.toString(p.getCantidadPro()));
                    pst.setString(3, Double.toString(p.getPrecioPro()));
                    pst.setString(4, Integer.toString(ti.getId()));
                    pst.executeUpdate();
                } else {
                    pst = cn.prepareStatement("INSERT INTO venta VALUES(?,?,?,?,?,?)");
                    pst.setString(1, "0");
                    pst.setString(2, "1");
                    pst.setString(3, Integer.toString(p.getIdPro()));
                    pst.setString(4, Integer.toString(ti.getId()));
                    pst.setString(5, Double.toString(p.getCostoPro()));
                    pst.setString(6, Double.toString(p.getPrecioPro()));
                    pst.executeUpdate();
                    idTemp = p.getIdPro();
                }
            }
            pst.close();
            cn.close();
            return ti;
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public static ArrayList<Object[]> getComisionTatu(int dia, int mes, int anio){
        try{
            Connection cn = Conexion.getConnection();
            CallableStatement cst = cn.prepareCall("CALL obtener_comision_tatuador(?,?,?)");
            cst.setString(1, Integer.toString(dia));
            cst.setString(2, Integer.toString(mes));
            cst.setString(3, Integer.toString(anio));
            ResultSet rs = cst.executeQuery();
            
            ArrayList<Object[]> a = new ArrayList<>();
            if(rs.next()){
                do{
                    Object o[] = {rs.getDouble("suma"), rs.getDouble("total"), rs.getInt("idTatuadorTicket"), rs.getString("nombre"), rs.getString("ap_paterno"), rs.getString("ap_materno")};
                    a.add(o);
                }while(rs.next());
            }
            
            cst.close();
            cn.close();
            return a;
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public static ArrayList<Object[]> getComisionPerfo(int dia, int mes, int anio){
        try{
            Connection cn = Conexion.getConnection();
            CallableStatement cst = cn.prepareCall("CALL obtener_comision_perforadores(?,?,?)");
            cst.setString(1, Integer.toString(dia));
            cst.setString(2, Integer.toString(mes));
            cst.setString(3, Integer.toString(anio));
            ResultSet rs = cst.executeQuery();
            
            ArrayList<Object[]> a = new ArrayList<>();
            if(rs.next()){
                do{
                    Object o[] = {rs.getDouble("suma"), rs.getDouble("total"), rs.getInt("idPerforadorTicket"), rs.getString("nombre")};
                    a.add(o);
                }while(rs.next());
            }
            
            cst.close();
            cn.close();
            return a;
        }catch(SQLException e){
            System.out.println(e);
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
    
    public static int getMaxAnio(){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT MAX(anio) FROM ticket");
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
            PreparedStatement pst = cn.prepareStatement("SELECT cantidad, idProductoVenta FROM venta WHERE idTicketVenta = "+Integer.toString(idTicket));
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Producto> p = new ArrayList<>();
            while(rs.next()){
                Producto prod = ProductoDB.buscar(rs.getInt("idProductoVenta"));
                prod.setCantidadPro(rs.getInt("cantidad"));
                p.add(prod);
            }
            cn.close();
            pst.close();
            return p;
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public static ArrayList<Object[]> getComisionesSocios(int dia, int mes, int anio){
        try{
            Connection cn = Conexion.getConnection();
            CallableStatement cst = cn.prepareCall("CALL obtener_ganancias(?,?,?)");
            cst.setString(1, Integer.toString(dia));
            cst.setString(2, Integer.toString(mes));
            cst.setString(3, Integer.toString(anio));
            ResultSet rs = cst.executeQuery();

            ArrayList<Socio> sl = Model.getSocios();
            ArrayList<Object[]> gananciasList = new ArrayList<>();
            if(rs.next()){
                double ganancias = rs.getDouble(1);
                for(Socio s : sl){
                    if(s.isRango()){
                        Object o[] = {s, ganancias*0.35, true};
                        gananciasList.add(o);
                    } else {
                        Object o[] = {s, ganancias*0.15, true};
                        gananciasList.add(o);
                    }
                }
                Object o[] = {2, ganancias*0.20, false};
                gananciasList.add(o);
            }
            cst.close();
            cn.close();
            return gananciasList;
        }catch(SQLException e){
            System.out.println(e);
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
                        rs.getDouble("pagoTatuador"), rs.getDouble("pagoPerforador"),
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
            
            if(dia == 0 && mes != 0){
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
                            rs.getDouble("pagoTatuador"), rs.getDouble("pagoPerforador"),
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
 
    public static void modificar(Ticket t){
        try{
            Connection cn = Conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("UPDATE ticket SET clip = ?, prod = ?, subtotalTatuaje = ?, subtotalPerforacion = ?, pagoTatuador = ?, pagoPerforador = ?, total = ?, idTatuadorTicket = ?, idPerforadorTicket = ?, visita = ? WHERE idTicket = ?");
            
            if(t.isClip())
                pst.setString(1, "1");
            else
                pst.setString(1, "0");
            
            if(t.isProd())
                pst.setString(2, "1");
            else
                pst.setString(2, "0");

            //System.out.println(t.getSubtotalTatuaje());
            pst.setString(3, Double.toString(t.getSubtotalTatuaje()));
            pst.setString(4, Double.toString(t.getSubtotalPerforacion()));
            System.out.println(t.getPagoTatuador());
            pst.setString(5, Double.toString(t.getPagoTatuador()));
            pst.setString(6, Double.toString(t.getPagoPerforador()));            
            
            pst.setString(7, Double.toString(t.getTotal()));
            
            if(t.getTatuador() != null)
                pst.setString(8, Integer.toString(t.getTatuador().getId()));
            else
                pst.setString(8, "0");
            
            if(t.getPerforador() != null)
                pst.setString(9, Integer.toString(t.getPerforador().getId()));
            else
                pst.setString(9, "0");
            
            if(t.isVisita())
                pst.setString(10, "1");
            else
                pst.setString(10, "0");

            System.out.println(t.getId());
            pst.setString(11, Integer.toString(t.getId()));
            pst.executeLargeUpdate();
            pst.close();
            cn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
