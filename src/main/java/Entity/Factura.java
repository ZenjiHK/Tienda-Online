package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author alex.lemususam
 */
@Entity
@Table(name = "factura")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private int id_factura;
    
    @JoinColumn(name = "venta", referencedColumnName = "id_venta")
    @ManyToOne
    private Venta venta;

    public Factura() {
    }

    public Factura(int id_factura) {
        this.id_factura = id_factura;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id_factura;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Factura other = (Factura) obj;
        if (this.id_factura != other.id_factura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Factura[ id=" + id_factura + " ]";
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }
     
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}