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

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_venta")
    private int idDetalleVenta;
    
    @Column(name = "cantidad")
    private int cantidad;
        
    @JoinColumn(name = "id_descuento", referencedColumnName = "id_descuento")
    @ManyToOne
    private Descuento descuento;
    
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private Producto producto;
    
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    @ManyToOne
    private Venta venta;
    
    @Column(name = "total")
    private double total;

    public DetalleVenta() {
    }

    public DetalleVenta(int id) {
        this.idDetalleVenta = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idDetalleVenta;
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
        final DetalleVenta other = (DetalleVenta) obj;
        if (this.idDetalleVenta != other.idDetalleVenta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + '}';
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int id) {
        this.idDetalleVenta = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setIdProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}