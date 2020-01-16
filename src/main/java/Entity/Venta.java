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

@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private int idVenta;
    
    @Column(name = "fecha")
    private String fecha;
    
    @Column(name = "estado")
    private String estado;
    
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_detalle_tarjeta", referencedColumnName = "id_detalle_tarjeta")
    private DetalleTarjeta detalleTarjeta;
    
    @OneToMany(targetEntity=Factura.class,mappedBy="venta")
    private List<Factura> lista_facturas;

    public Venta() {
    }

    public Venta(int idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idVenta;
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
        if (this.idVenta != other.idVenta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + '}';
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Factura> getLista_facturas() {
        return lista_facturas;
    }

    public void setLista_facturas(List<Factura> lista_facturas) {
        this.lista_facturas = lista_facturas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DetalleTarjeta getDetalleTarjeta() {
        return detalleTarjeta;
    }

    public void setDetalleTarjeta(DetalleTarjeta detalleTarjeta) {
        this.detalleTarjeta = detalleTarjeta;
    }
}