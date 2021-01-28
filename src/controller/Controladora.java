package controller;
import model.*;
import view.*;
import objects.*;

class Controladora{
  private double comiclip = getClip; //getClip debe regresar la comisión de clip;
  public ProcesoTicket(Ticket ti, Double Pago){
    private double pagado = ti.getPagado();
    model.insertarTicket(ti);
    pagado += pago;
    ti.setPagado(pagado);
    model.modificarTicket(ti);
    if (ti.getTotal()-pagado > 0){
      ti.setTotal(pago);
      ProcesoPago(ti);
    }
    if (ti.getTotal()-pagado < 0){
      ti.setCambio((ti.getTotal()-pagado)*(-1));
      model.modificarTicket(ti);
      ti.setTotal(pago);
      ProcesoPago(ti);
    }
    if (ti.getTotal()-pagado == 0){
      ti.setTotal(pago);
      ProcesoPago(ti);
    }
  }

  public void ProcesoPago(Ticket t){ //Ticket.costo debe ser la suma del monto correspondiente a la suma del costo del tatuaje y de la mercancía
    private double monto;
    private double comision;
    private double proveedor;
    private double total = t.getTotal();
    if (t.isClip()){
      t.setTotal(total-total*comiclip);
    }
    if (t.isProd()){
      private Arraylist<Proveedor> proveedoresArr = model.getProveedor();
      private Arraylist<Producto> productosArr = t.getProductos();
      private double totalProv;
      for(int count = 0; count < productosArr.size(); count++){
        for(int i = 0; i < proveedoresArr.size(); i++){
          if (productosArr[count].getProveedor().getNombre().equals(proveedoresArr[i].getNombre())){ //El objeto Producto aún no contiene un objeto Proveedor.
            t.setTotal(total-productosArr[count].getPrecioPro());  //Reducir Stock
            monto += productosArr[count].getPrecioPro()*(proveedoresArr[i].getMargen()); //Se registra el margen de ganancia para BabaYaga
            totalProv = proveedoresArr[i].getTotal();
            proveedoresArr[i].setTotal(totalProv + productosArr[count].getPrecioPro()*(1-proveedoresArr[i].getMargen())); //Es necesario registrar los márgenes como 50, 60, etc. y mandarlos como 0.5, 0.6, etc.
            model.modificarProveedor(proveedoresArr[i]);
            actualizarStock(productosArr[count].getIdPro(), productosArr[count].getCantidadPro()-1);
          }
        }
      }
    }
    switch(t.getTatuador().getRangoInt()){
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
    model.aumentarGanancia(monto);
    t.getTatuador().setTotal(t.getTatuador().getTotal()+comision*t.getTotal());
    model.modificarTatuador(t.getTatuador());
  }

  public void procesoGanancias(){
    private double pago;
    private double comision;
    private double total = model.obtenerGanancia();
    private ArrayList<Socio> socios = model.getSocios();
    for(int counter = 0; counter < socios.size(); counter++){
      if(socios[counter].isRango()){
        comision = 0.35;
      }else{
        comision = 0.15;
      }
      pago += total*comision;
      total -= pago;
      socios[counter].setTotal(socios[counter].getTotal()+pago);
      model.modificarSocio(socios[counter]);
      model.aumentarGanancia(-pago);
    }
    model.aumentarReinversion(total);
  }
/*Para hacer el programa dinámico, debemos pedir el porcentaje de cada socio.
También necesitamos el margen de utilidad de cada proveedor si es que se desea
registrar más de 2.
