package controller;
import Model.*;
import view.*;
import objects.*;

class Controladora{
  private double comiclip = 0.0417; //Debe ser versátil. Preguntar si el IVA está incluído en los costos, que pedo con el IVA

  public void ProcesoTicket(Ticket t){ //Ticket.costo debe ser la suma del monto correspondiente a la suma del costo del tatuaje y de la mercancía
    double monto;
    double comision;
    double proveedor;
    if (t.clip) {
      t.costo -= t.costo*comiclip;
    }
    if (t.merch){
      for(int count = 0; count < t.productos.size(); count++){
//Necesitamos un método getProveedores que regrese un ArrayList de proveedores
        if (t.productos[count].proveedor.equals("BLK")){ //Comentar en reunión
          t.costo -= t.productos[count].precioPro;  //Reducir Stock
          monto += t.productos[count].precioPro*(1-margen);
          proveedorBLK += t.productos[count].precioPro*margen; //Es neceseria una clase proveedor que contenga un String name, double total, double margen.
          t.productos[count].cantidadPro -= 1;
        }
      }
    }
    switch(t.Tatuador.rangoInt){
      case 1:
        comision = 0.6;
        break;
      case 2:
        comision = 0.5;
        break;
      case 3:         //Comentar con Vista
        if(t.visita){ //Solo el tatuador secundario tiene la opción de cobrar más por llevar clientes.
          comision = 0.6;
        }else{
          comision = 0.4;
        }
        break;
    }
    monto += t.costo - t.costo*comision;
    Model.aumentarGanancia(monto);
    t.tatuador.total += comision*t.costo;
    Model.modificarTatuador(t.Tatuador);
    Model.aumentarPagoProveedores(proveedorBLK); //Comentar con Modelo. Se puede pasar proveedor y monto
  }

  public void procesoGanancias(){
    private double pago;
    private double total = Model.obtenerGanancias();
    private ArrayList<Socio> socios = Model.getSocios();
    for(int counter = 0; counter < socios.size(); counter++){
      if(socios[counter].rango){
        comision = 0.35; //¿qué pasaría si un socio se añade y se va?
      }else{
        comision = 0.15;
      }
      pago += total*comision;
      total -= pago;
      socios[counter].total += pago;
      Model.modificarSocio(socios[counter]);
      Model.aumentarGanancias(-pago);
    }
    Model.aumentarReinversion(total);
  }
/*Para hacer el programa dinámico, debemos pedir el porcentaje de cada socio.
También necesitamos el margen de utilidad de cada proveedor si es que se desea
registrar más de 2.
