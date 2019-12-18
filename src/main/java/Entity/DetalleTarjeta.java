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
@Table(name = "detalle_tarjeta")
public class DetalleTarjeta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarjeta")
    private int id_tarjeta;
    
    @Column(name = "expiracion")
    @Temporal(TemporalType.DATE)
    private Date expiracion;
    
    @Column(name = "ping")
    private int ping;
    
    @OneToMany(mappedBy = "tarjeta")
    private List<Venta> ventaList;
    
    @JoinColumn(name = "cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente cliente;

    public DetalleTarjeta() {
    }

    public DetalleTarjeta(int id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id_tarjeta;
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
        final DetalleTarjeta other = (DetalleTarjeta) obj;
        if (this.id_tarjeta != other.id_tarjeta) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Entity.DetalleTarjeta[ id=" + id_tarjeta + " ]";
    }

    public int getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(int id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }
    
    public Date getExpiracion() {
        return expiracion;
    }

    public void setExpiracion(Date expiracion) {
        this.expiracion = expiracion;
    }

    public int getPing() {
        return ping;
    }

    public void setPing(int ping) {
        this.ping = ping;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }   
}