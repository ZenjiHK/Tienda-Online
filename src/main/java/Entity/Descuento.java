package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alex.lemususam
 */
@Entity
@Table(name = "descuento")
public class Descuento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_descuento")
    private int id_descuento;

    @Column(name = "descuento")
    private double descuento;
    
    @OneToMany(mappedBy = "descuento")
    private List<DetalleVenta> detalleVentaList;

    public Descuento() {
    }

    public Descuento(int id_descuento) {
        this.id_descuento = id_descuento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id_descuento;
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
        final Descuento other = (Descuento) obj;
        if (this.id_descuento != other.id_descuento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Descuento{" + "id=" + id_descuento + '}';
    }

    public int getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(int id_descuento) {
        this.id_descuento = id_descuento;
    }
    
    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }
}