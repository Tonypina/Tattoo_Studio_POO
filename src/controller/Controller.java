/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.ArrayList;

import model.*;
import view.*;
import objects.*;

class Controller{
  private static double getClip;
  private static double comiclip = getClip; //getClip debe regresar la comisión de clip;
  private static Ticket ticket;
  public static void ProcesoTicket(Ticket ticket, Double Pago){
    double pagado = ticket.getPagado();
    Ticket ti;
    ti = Model.insertarTicket(ticket);
    pagado += Pago;
    ti.setPagado(pagado);
    Model.modificarTicket(ti);
    if (ti.getTotal()-pagado > 0){
      ti.setTotal(Pago);
      ProcesoPago(ti);
    }
    if (ti.getTotal()-pagado < 0){
      ti.setCambio((ti.getTotal()-pagado)*(-1));
      Model.modificarTicket(ti);
      ti.setTotal(Pago);
      ProcesoPago(ti);
    }
    if (ti.getTotal()-pagado == 0){
      ti.setTotal(Pago);
      ProcesoPago(ti);
    }
  }

  public static void ProcesoPago(Ticket t){
    double monto=0;
    double comision=0;
    double proveedor=0;
    double total = t.getTotal();
    if (t.isClip()){
      t.setTotal(total-total*comiclip);
    }
    if (t.isProd()){
      ArrayList<Proveedor> proveedoresArr = Model.getProveedor();
      ArrayList<Producto> productosArr = t.getProductos();
      double totalProv;
      for(Producto prod:productosArr){
        for(Proveedor prov:proveedoresArr){
          if (prod.getProveedor().getNombre().equals(prov.getNombre())){ //El objeto Producto aún no contiene un objeto Proveedor.
            t.setTotal(total-prod.getPrecioPro());  //Reducir Stock
            monto += prod.getPrecioPro()*(prov.getMargen()); //Se registra el margen de ganancia para BabaYaga
            totalProv = prov.getTotal();
            prov.setTotal(totalProv + prod.getPrecioPro()*(1-prov.getMargen())); //Es necesario registrar los márgenes como 50, 60, etc. y mandarlos como 0.5, 0.6, etc.
            Model.modificarProveedor(prov);
            Model.actualizarStock(prod.getIdPro(), prod.getCantidadPro()-1);
          }
        }
      }
    }
    switch(t.getTatuador().getRango()){
      case 1:
        comision = 0.6;
        break;
      case 2:
        comision = 0.5;
        break;
      case 3:         //Comentar con Vista
        if(t.isVisita()){ //Necesitamos este booleano.
          comision = 0.6;
        }else{
          comision = 0.4;
        }
        break;
    }
    monto += t.getTotal() - t.getTotal()*comision;
    Model.aumentarGanancia(monto);
    t.getTatuador().setTotal(t.getTatuador().getTotal()+comision*t.getTotal());
    Model.modificarTatuador(t.getTatuador());
  }

  public static void procesoGanancias(){
    double pago=0;
    double comisiones=0;
    double totales = Model.obtenerGanancia();
    ArrayList<Socio> socios = Model.getSocios();
    for(Socio s:socios){
      if(s.isRango()){
        comisiones = 0.35;
      }else{
        comisiones = 0.15;
      }
      pago += pago*comisiones;
      pago -= pago;
      s.setTotal(s.getTotal()+pago);
      Model.modificarSocio(s);
      Model.aumentarGanancia(-pago);
    }
    Model.aumentarReinversion(pago);
  }

public static Ticket getTicket() {
	return ticket;
}

public static void setTicket(Ticket ticket) {
	Controller.ticket = ticket;
}
}