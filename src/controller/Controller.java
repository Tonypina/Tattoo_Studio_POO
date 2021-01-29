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
    double monto;
    double comision;
    double proveedor;
    double total = t.getTotal();
    if (t.isClip()){
      t.setTotal(total-total*comiclip);
    }
    if (t.isProd()){
      ArrayList<Proveedor> proveedoresArr = Model.getProveedor();
      ArrayList<Producto> productosArr = t.getProductos();
      double totalProv;
      for(int count = 0; count < productosArr.size(); count++){
        for(int i = 0; i < proveedoresArr.size(); i++){
          if (productosArr[count].getProveedor().getNombre().equals(proveedoresArr[i].getNombre())){ //El objeto Producto aún no contiene un objeto Proveedor.
            t.setTotal(total-productosArr[count].getPrecioPro());  //Reducir Stock
            monto += productosArr[count].getPrecioPro()*(proveedoresArr[i].getMargen()); //Se registra el margen de ganancia para BabaYaga
            totalProv = proveedoresArr[i].getTotal();
            proveedoresArr[i].setTotal(totalProv + productosArr[count].getPrecioPro()*(1-proveedoresArr[i].getMargen())); //Es necesario registrar los márgenes como 50, 60, etc. y mandarlos como 0.5, 0.6, etc.
            Model.modificarProveedor(proveedoresArr[i]);
            actualizarStock(productosArr[count].getIdPro(), productosArr[count].getCantidadPro()-1);
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
    double pago;
    double comisiones;
    double totales = Model.obtenerGanancia();
    ArrayList<Socio> socios = Model.getSocios();
    for(int counter = 0; counter < socios.size(); counter++){
      if(socios[counter].isRango()){
        comisiones = 0.35;
      }else{
        comisiones = 0.15;
      }
      pago += pago*comisiones;
      pago -= pago;
      socios[counter].setTotal(socios[counter].getTotal()+pago);
      Model.modificarSocio(socios[counter]);
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
