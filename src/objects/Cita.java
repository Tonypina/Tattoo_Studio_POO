package objects;

/**
 *
 * @author
 */
public class Cita {
    private int id;
    private String nombreCliente;
    private int diaInicio;
    private int mesInicio;
    private int anioInicio;
    private int diaFinal;
    private int mesFinal;
    private int anioFinal;

    public Cita(int id, String nombreCliente, int diaInicio, int mesInicio, int anioInicio, int diaFinal, int mesFinal, int anioFinal) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.diaInicio = diaInicio;
        this.mesInicio = mesInicio;
        this.anioInicio = anioInicio;
        this.diaFinal = diaFinal;
        this.mesFinal = mesFinal;
        this.anioFinal = anioFinal;
    }
    
    // Sobrecarga de constructor para la base de datos.
    public Cita(String nombreCliente, int diaInicio, int mesInicio, int anioInicio, int diaFinal, int mesFinal, int anioFinal, int duracion, Ticket ticket) {
        this.nombreCliente = nombreCliente;
        this.diaInicio = diaInicio;
        this.mesInicio = mesInicio;
        this.anioInicio = anioInicio;
        this.diaFinal = diaFinal;
        this.mesFinal = mesFinal;
        this.anioFinal = anioFinal;
    }

    public int getIdCita() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
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

    public void setIdCita(int id) {
        this.id = id;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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
    
}
