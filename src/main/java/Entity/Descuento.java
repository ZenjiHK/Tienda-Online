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

@Entity
@Table(name = "descuento")
public class Descuento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_descuento")
    private int idDescuento;

    @Column(name = "descuento")
    private double descuento;
    
    @OneToMany(targetEntity=DetalleVenta.class,mappedBy="descuento")
    private List<DetalleVenta> lista_detalle_ventas;

    public Descuento() {
    }

    public Descuento(int id) {
        this.idDescuento = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idDescuento;
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
        if (this.idDescuento != other.idDescuento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Descuento{" + "idDescuento=" + idDescuento + '}';
    }
    
    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int id) {
        this.idDescuento = id;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public List<DetalleVenta> getLista_detalle_ventas() {
        return lista_detalle_ventas;
    }

    public void setLista_detalle_ventas(List<DetalleVenta> lista_detalle_ventas) {
        this.lista_detalle_ventas = lista_detalle_ventas;
    }
}