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
    private double anticipo;
    private double total;
    private Tatuador tatuador;
    private boolean visita;
    private ArrayList<Producto> productos;
    

    public Ticket(int id, boolean clip, boolean prod, double anticipo, double total, Tatuador tatuador) {
        this.id = id;
        this.clip = clip;
        this.prod = prod;
        this.anticipo = anticipo;
        this.total = total;
        this.tatuador = tatuador;
        this.productos=productos;
    }

    // Sobrecarga de constructor para la Base de Datos.
    public Ticket(boolean clip, boolean prod, double anticipo, double total, Tatuador tatuador) {
        this.clip = clip;
        this.prod = prod;
        this.anticipo = anticipo;
        this.total = total;
        this.tatuador = tatuador;
        this.productos=productos;
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

    public double getAnticipo() {
        return anticipo;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setClip(boolean clip) {
        this.clip = clip;
    }

    public void setProd(boolean prod) {
        this.prod = prod;
    }

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTatuador(Tatuador tatuador) {
        this.tatuador = tatuador;
    }

    public void setProductos() {
        this.productos = productos;
    }
}
