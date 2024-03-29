/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.ArrayList;
import model.*;
import objects.*;

public class Controller{
  private static double comiclip = Model.getClip(); //getClip debe regresar la comisión de clip;
  private static Ticket ticket;
  public static Ticket procesoPago(Ticket ticket){
    double monto = 0.0;
    double comision = 0.0;
    double totalMerch = 0.0;
    double montoTatuaje = 0.0;
    double totalProv = 0.0;
    Ticket t;
    t = Model.insertarTicket(ticket);
    double total = t.getTotal();
    if (t.isProd()){
      ArrayList<Proveedor> proveedoresArr = Model.getProveedor();
      ArrayList<Producto> productosArr = t.getProductos();
      totalMerch = sumaProd(productosArr);
      for(Producto prod:productosArr){
        for(Proveedor prov:proveedoresArr){
          if (prod.getProveedor().getNombre().equals(prov.getNombre())){
            if (prod.isPerfo()){
              monto += t.getSubtotalPerforacion()*0.3;
              totalProv = prov.getTotal();
              t.setPagoPerforador(t.getSubtotalPerforacion()*0.7);
              prov.setTotal(totalProv + t.getSubtotalPerforacion()*0.7);
              Model.modificarProveedor(prov);
            }else{
              monto += prod.getPrecioPro()-(prod.getCostoPro());
              totalProv = prov.getTotal();
              prov.setTotal(totalProv + prod.getCostoPro());
              Model.modificarProveedor(prov);
            }
          }
        }
      }
    }
    montoTatuaje = t.getSubtotalTatuaje();
    if (t.getTatuador()==null) {
      Model.aumentarGanancia(monto);
      Model.modificarTicket(t);
    }else{
      switch(t.getTatuador().getRango()){
        case 1:
          comision = 0.6;
          break;
        case 2:
          comision = 0.5;
          break;
        case 3:
          if(t.isVisita()){
            comision = 0.6;
          }else{
            comision = 0.4;
          }
          break;
      }
      monto += montoTatuaje - montoTatuaje*comision;
      Model.aumentarGanancia(monto);
      t.setPagoTatuador(comision*montoTatuaje);
      t.getTatuador().setTotal(t.getTatuador().getTotal()+comision*montoTatuaje);
      Model.modificarTicket(t);
      Model.modificarTatuador(t.getTatuador());
    }
    return t;
  }

  public static void procesoGanancias(){
    double sablazo = 0;
    double pago = 0;
    double comisionS = 0;
    double totalG = 0;
    ArrayList<Socio> socios = Model.getSocios();
    for(Socio s:socios){
      pago = 0;
      totalG = Model.obtenerGanancia();
      if(s.isRango()){
        comisionS = 0.35;
      }else{
        comisionS = 0.15;
      }
      pago += totalG*comisionS;
      s.setTotal(s.getTotal()+pago);
      Model.modificarSocio(s);
      sablazo += pago;
    }
    Model.aumentarReinversion(totalG-sablazo);
    Model.aumentarGanancia(-sablazo);
  }
  //Métodos for dummies :)
  public static double sumaProd(ArrayList<Producto> p){
    double totalMerch = 0.0;
      for(Producto produ:p){
      totalMerch += produ.getPrecioPro();
    }
    return totalMerch;
  }
  public static double sumaTodo(double tatuaje, double productos){
    return tatuaje+productos;
  }
  public static double sumaClip(double total){
    return total + total*Model.getClip();
  }
}
