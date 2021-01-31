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
  private static double comiclip = Model.getClip(); //getClip debe regresar la comisión de clip;
  private static Ticket ticket;
  public static void ProcesoTicket(Ticket ticket, Double pago){
    double pagado = ticket.getPagado();
    Ticket ti;
    ti = Model.insertarTicket(ticket);
    pagado += pago;
    ti.setPagado(pagado);
    Model.modificarTicket(ti);
    if (ti.getTotal()-pagado > 0){
      ti.setTotal(pago);
      ProcesoPago(ti, pago);
    }
    if (ti.getTotal()-pagado < 0){
      ti.setCambio((ti.getTotal()-pagado)*(-1));
      Model.modificarTicket(ti);
      ti.setTotal(pago);
      ProcesoPago(ti, pago);
    }
    if (ti.getTotal()-pagado == 0){
      ti.setTotal(pago);
      ProcesoPago(ti, pago);
    }
  }

  public static void ProcesoPago(Ticket t){
    double monto=0;
    double comision=0;
    double totalMerch=0;
    double montoTatuaje=0;
    double totalProv=0;
    double total = t.getTotal();
    if (t.isProd()){
      ArrayList<Proveedor> proveedoresArr = Model.getProveedor();
      ArrayList<Producto> productosArr = t.getProductos();
      for(Producto produ:productosArr){
        totalMerch += produ.getPrecioPro();
      }
      if (t.isClip()) {
        montoTatuaje = (float)(t.getTotal()/(1+comiclip))-totalMerch;
        montoTatuaje = (double)montoTatuaje;
      }else{
        montoTatuaje = (t.getTotal()/1)-totalMerch;
      }
      for(Producto prod:productosArr){
        for(Proveedor prov:proveedoresArr){
          if (prod.getProveedor().getNombre().equals(prov.getNombre())){
            monto += prod.getPrecioPro()*(prov.getMargen());
            totalProv = prov.getTotal();
            prov.setTotal(totalProv + prod.getPrecioPro()*(1-prov.getMargen()));
            Model.modificarProveedor(prov);
            Model.actualizarStock(prod.getIdPro(), prod.getCantidadPro()-1);
          }
        }
      }
    }else{
      if (t.isClip()) {
        montoTatuaje = (float)(t.getTotal()/(1+comiclip));
        montoTatuaje = (double)montoTatuaje;
      }else{
        montoTatuaje = t.getTotal();
      }
    }
    if (montoTatuaje==0) {
      Model.aumentarGanancia(monto);
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
      t.getTatuador().setTotal(t.getTatuador().getTotal()+comision*montoTatuaje);
      Model.modificarTatuador(t.getTatuador());
    }
  }

  public static void procesoGanancias(){
    double sablazo=0;
    double pago=0;
    double comisionS=0;
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
      sablazo+=pago;
    }
    Model.aumentarReinversion(totalG-sablazo);
    Model.aumentarGanancia(-sablazo);
  }
}
