package objects;

import java.util.ArrayList;

/**
 *
 * @author
 */
public class Cita {
    private int idCita;
    private String nombreCliente;
    private int diaInicio;
    private int mesInicio;
    private int anioInicio;
    private int diaFinal;
    private int mesFinal;
    private int anioFinal;
    private double anticipo;
    private double precio;
    private int duracion; //En minutos
    //Sirven para el metodo Ticket
    private Tatuador NombreTatuador;
    private Producto ProductoComp;
    private boolean Clip;
    private boolean Prod;


    public Cita(int idCita, int diaInicio, int mesInicio, int anioInicio, int diaFinal, int mesFinal, int anioFinal, String nombreCliente, double anticipo, double precio, int duracion) {
        this.idCita = idCita;
        this.diaInicio = diaInicio;
        this.mesInicio = mesInicio;
        this.anioInicio = anioInicio;
        this.diaFinal = diaFinal;
        this.mesFinal = mesFinal;
        this.anioFinal = anioFinal;
        this.nombreCliente = nombreCliente;
        this.anticipo = anticipo;
        this.precio = precio;
        this.duracion = duracion;
    }

    public int getIdCita(){
        return idCita;
    }

    public int getDiaInicio() {
        return diaInicio;
    }

    public int getMesInicio() {
        return mesInicio;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public int getDiaFinal() {
        return diaFinal;
    }

    public int getMesFinal() {
        return mesFinal;
    }

    public int getAnioFinal() {
        return anioFinal;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public double getAnticipo() {
        return anticipo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setIdCita(int idCita){
        this.idCita = idCita;
    }

    public void setDiaInicio(int diaInicio) {
        this.diaInicio = diaInicio;
    }

    public void setMesInicio(int mesInicio) {
        this.mesInicio = mesInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    public void setDiaFinal(int diaFinal) {
        this.diaFinal = diaFinal;
    }

    public void setMesFinal(int mesFinal) {
        this.mesFinal = mesFinal;
    }

    public void setAnioFinal(int anioFinal) {
        this.anioFinal = anioFinal;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setAnticipo(float anticipo) {
        this.anticipo = anticipo;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean CompraClip(){
	    return true;
    }

    public boolean CompraProducto(){
	    return true;
    }

    public Tatuador getNombreTatuador(){
        return NombreTatuador;
    }

    public ArrayList<String> Ticket(Producto PC, String NombreTatuador, double Precio, Cita Datos, boolean Clip){
	    ArrayList<String> Ticket= new ArrayList<>();
	    this.Clip=Clip;
	    Ticket.add(NombreTatuador);
	    // Para Verificar si la compra fue con clip
	    if(Datos.CompraClip()){
		    this.Clip=true;
		    Ticket.add(this.Clip);
	    }
	    else{
		    this.Clip=false;
		    Ticket.add(this.Clip);

	    }
	    // Para Verificar si hubo compra de objeto
	    if(Datos.CompraProducto()){
		    Ticket.add(PC);
	    }

	    Ticket.add(Datos.getPrecio());

	    return Ticket;
    }
}
