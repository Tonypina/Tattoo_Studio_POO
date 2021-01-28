package objects;
import java.util.*;
/**
 *
 * @author
 */
public class Ticket {
    private int id;
    private boolean clip;
    private boolean prod;
    private double pagado;
    private double total;
    private Tatuador tatuador;
    private boolean visita;
    private ArrayList<Producto> productos;
    private double cambio;
    
    public Ticket(int id, boolean clip, boolean prod, double pagado, double total, Tatuador tatuador, ArrayList<Producto> productos) {
        this.id = id;
        this.clip = clip;
        this.prod = prod;
        this.pagado = pagado;
        this.total = total;
        this.tatuador = tatuador;
        this.productos=productos;
        this.cambio=cambio;
    }

    // Sobrecarga de constructor para la Base de Datos.
    public Ticket(boolean clip, boolean prod, double pagado, double total, Tatuador tatuador, ArrayList<Producto> productos) {
        this.clip = clip;
        this.prod = prod;
        this.pagado = pagado;
        this.total = total;
        this.tatuador = tatuador;
        this.productos=productos;
        this.cambio=cambio;
    }

    public int getId() {
        return id;
    }

    public boolean isClip() {
        return clip;
    }

    public boolean isProd() {
        return prod;
    }

    public double getPagado() {
        return pagado;
    }

    public double getTotal() {
        return total;
    }

    public Tatuador getTatuador() {
        return tatuador;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public double getCambio(){
        return cambio;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setClip(boolean clip) {
        this.clip = clip;
    }

    public void setProd(boolean prod) {
        this.prod = prod;
    }

    public void setPagado(double pagado) {
        this.pagado = pagado;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTatuador(Tatuador tatuador) {
        this.tatuador = tatuador;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    public void setCambio(double cambio) {
        this.cambio = cambio;
    }
}
