package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alex.lemususam
 */
@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "estado")
    private boolean estado;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne
    private Cliente cliente;
    
    @JoinColumn(name = "pago", referencedColumnName = "id")
    @ManyToOne
    private FormaPago pago;
    
    @JoinColumn(name = "tarjeta", referencedColumnName = "id")
    @ManyToOne
    private DetalleTarjeta tarjeta;
    
    @OneToMany(mappedBy = "venta")
    private List<DetalleVenta> detalleVentaList;
    
    @OneToMany(mappedBy = "venta")
    private List<Factura> facturaList;

    public Venta() {
    }

    public Venta(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
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
        final Venta other = (Venta) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Entity.Venta[ id=" + id + " ]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FormaPago getPago() {
        return pago;
    }

    public void setPago(FormaPago pago) {
        this.pago = pago;
    }

    public DetalleTarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(DetalleTarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }    
}
