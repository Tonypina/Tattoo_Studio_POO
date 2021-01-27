package controller;
import objects.*;

class Tatuador{
  public boolean[] Rango = [Principal, Aprendiz, Secundario];
  public String Nombre;
  Tatuador(String[] Nombre, int Rango){
    this.Nombre = Nombre
    switch (Rango) {
      case 1:
        this.Principal=1;
      case 2:
        this.Secundario=1;
      case 3:
        this.Aprendiz=1;
    }
    public int getPortencaje(){

    }
  }
}

class Socio{
  public boolean Rango; //0 para minoritario, 1 para mayoritario
}
class Gestor extends Controladora{
    
}

class Controladora{ //Todo lo público es realizable por el gestor. Los métodos privados son ezclusivos del dueño
  ArrayList<Tatuador> Tatuadores = new ArrayList<Tatuador>(); //
  private void RegistroSocio(){

  }
  private void RegistroTatuador(String[] Nombre, int Rango){
    Tatuador temp = new Tatuador(Nombre, Rango);
    Tatuadores.add(temp);
  }
  private void EliminarSocio(){

  }
  private void EliminarTatuador(Tatuador funado){

  }
  private MostrarReporte(){ //Solo le pasamos la información a la vista

  }
  public MostrarCitas(){ //Solo le pasamos la información a la vista

  }
  public void Ingresar(){ //Solo le pasamos la información a la vista?

  }
  public Tatuador[] ListaTatuadores(){

  }
  public void ProcesoTicket(Ticket){
    if (Tatuador.equals(Jose)) {

    }
}
