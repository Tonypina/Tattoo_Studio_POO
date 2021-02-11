/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import model.util.*;
import objects.*;
import java.util.*;

/**
 *
 * @author
 */
public class Model {
    
    // Estudio
    
    public static void aumentarGanancia( double aumento ){
        EstudioDB.aumentarGanancia(aumento);
    }
    
    public static double obtenerGanancia(){
        return EstudioDB.obtenerGanancia();
    }
    
    public static double obtenerReinversion(){
        return EstudioDB.obtenerReinversion();
    }
    
    public static void aumentarReinversion( double aumento ){
        EstudioDB.aumentarReinversion(aumento);
    }
    
    public static double obtenerPagoProveedores(){
        return EstudioDB.obtenerPagoProveedores();
    }
    
    public static void aumentarPagoProveedores( double aumento ){
        EstudioDB.aumentarPagoProveedores(aumento);
    }
    
    public static double getClip(){
        return EstudioDB.getClip();
    }
    
    public static void setClip( double clip ){
        EstudioDB.setClip(clip);
    }
    
    // Tatuador
    
    public static ArrayList<Tatuador> getTatuadores(){
        return TatuadorDB.get();
    }
    
    public static void insertarTatuador( Tatuador t ){
        TatuadorDB.insertar(t);
    }
    
    public static Tatuador buscarTatuador( int id ){
        return TatuadorDB.buscar(id);
    }
    
    public static ArrayList<Tatuador> buscarTatuador( String nombre ){
        return TatuadorDB.buscar(nombre);
    }
    
    public static void modificarTatuador( Tatuador t ){
        TatuadorDB.modificar(t);
    }
    
    public static void eliminarTatuador( int id ){
        TatuadorDB.eliminar(id);
    }
    
    // Citas
    
    public static ArrayList<Cita> getCitas( int idTatuador ){
        return CitaDB.get(idTatuador);
    }
    
    public static ArrayList<Cita> getCitas( int dia, int mes, int anio ){
        return CitaDB.get(dia, mes, anio);
    }
    
    public static ArrayList<Cita> getCitas( ){
        return CitaDB.get();
    }
    
    public static void insertarCita( Cita c ){
        CitaDB.insertar(c);
    }
    
    public static void modificarCita( Cita c ){
        CitaDB.modificar(c);
    }
    
    public static void eliminarCita( int id ){
        CitaDB.eliminar(id);
    }
    
    // Producto
    
    public static ArrayList<Producto> getProductos(){
        return ProductoDB.get();
    }
    
    public static ArrayList<Producto> getProductos( int idProveedor ){
        return ProductoDB.get(idProveedor);
    }
    
    public static ArrayList<Producto> getTipos( String tipoPro ){
        return ProductoDB.get(tipoPro);
    }
    
    public static void insertarProducto( Producto pro ){
        ProductoDB.insertar(pro);
    }

    public static Producto buscarProducto( int idPro ){
        return ProductoDB.buscar(idPro);
    }
        
    public static void modificarProducto(Producto p){
        ProductoDB.modificar(p);
    }
    
    public static void eliminarProducto( int idPro ){
        ProductoDB.eliminar(idPro);
    }
    
    public static void actualizarStock(int idPro, int cantidadPro){
        ProductoDB.actualizarStock(idPro, cantidadPro);
    }
    
    //Usuario
    
    public static ArrayList<Usuario> getUsuarios(){
        return UsuarioDB.get();
    }
    
    public static void insertarUsuario(Usuario u){
        UsuarioDB.insertar(u);
    }
    
    public static Usuario buscarUsuario(int id) {  
        return UsuarioDB.buscar(id);
    }
    
    public static Usuario buscarUsuario(String username) {  
        return UsuarioDB.buscar(username);
    }

    public static void modificarUsuario(Usuario u){
        UsuarioDB.modificar(u);
    }
    
    public static void eliminarUsuario(int id){
        UsuarioDB.eliminar(id);
    }
    
    public static boolean autetnicacion( String username, String pass ){
        return UsuarioDB.autenticacion(username, pass);
    }
    
    //Socio
    
    public static ArrayList<Socio> getSocios(){
        return SocioDB.get();
    }

    public static void insertarSocio( Socio s ){
        SocioDB.insertar(s);
    }

    public static Socio buscarSocio( int id ){
        return SocioDB.buscar(id);
    }

    public static void modificarSocio( Socio s ){
        SocioDB.modificar(s);
    }

    public static void eliminarSocio( int id ){
        SocioDB.eliminar(id);
    }
    
     //Proveedor
    public static void insertarProveedor( Proveedor p ){
        ProveedorDB.insertar(p);
    }
    
    public static Proveedor buscarProveedor( int idProveedor ){
        return ProveedorDB.buscar(idProveedor);
    }
    
    public static Proveedor buscarProveedor( String nombre ){
        return ProveedorDB.buscar(nombre);
    }

    public static void modificarProveedor(Proveedor p){
        ProveedorDB.modificar(p);
    }
    
    public static ArrayList<Proveedor> getProveedor(){
        return ProveedorDB.get();
    }

    public static void eliminarProveedor( int id ){
        ProveedorDB.eliminar(id);
    }

    //Ticket
    public static ArrayList<Ticket> getTickets(){
        return TicketDB.get();
    }

    public static ArrayList<Ticket> getTickets( int dia, int mes, int anio ){
        return TicketDB.get(dia, mes, anio);
    }
    
    public static Ticket insertarTicket( Ticket t ){
        return TicketDB.insertar(t);
    }

    public static Ticket buscarTicket( int idTicket ){
        return TicketDB.buscar(idTicket);
    }

    public static void modificarTicket(Ticket t){
        TicketDB.modificar(t);
    }
}