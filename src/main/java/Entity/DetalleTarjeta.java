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
@Table(name = "detalle_tarjeta")
public class DetalleTarjeta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_tarjeta")
    private int idDetalleTarjeta;
    
    @Column(name="numero")
    private String numero_tarjeta;
    
    @Column(name = "expiracion")
    @Temporal(TemporalType.DATE)
    private Date expiracion;
    
    @Column(name = "ping")
    private int ping;
    
    @OneToMany(targetEntity=Venta.class,mappedBy="detalleTarjeta")
    private List<Venta> lista_ventas;
    
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente cliente;
    
    @Column(name="estado")
    private boolean estado=true;
    
    @JoinColumn(name = "id_forma_pago", referencedColumnName = "id_forma_pago")
    @ManyToOne
    private FormaPago formapago;

    public DetalleTarjeta() {
    }

    public DetalleTarjeta(int id) {
        this.idDetalleTarjeta = id;
    }

    public DetalleTarjeta(int idDetalleTarjeta, String numero_tarjeta, Date expiracion, List<Venta> lista_ventas, Cliente cliente, FormaPago formapago) {
        this.idDetalleTarjeta = idDetalleTarjeta;
        this.numero_tarjeta = numero_tarjeta;
        this.expiracion = expiracion;
        this.lista_ventas = lista_ventas;
        this.cliente = cliente;
        this.formapago = formapago;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idDetalleTarjeta;
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
        if (this.idDetalleTarjeta != other.idDetalleTarjeta) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "DetalleTarjeta{" + "idDetalleTarjeta=" + idDetalleTarjeta + '}';
    }

    public int getIdDetalleTarjeta() {
        return idDetalleTarjeta;
    }

    public void setIdDetalleTarjeta(int id) {
        this.idDetalleTarjeta = id;
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

    public List<Venta> getLista_ventas() {
        return lista_ventas;
    }

    public void setLista_ventas(List<Venta> lista_ventas) {
        this.lista_ventas = lista_ventas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

      public boolean isEstado() {
            return estado;
      }

      public void setEstado(boolean estado) {
            this.estado = estado;
      }

      public String getNumero_tarjeta() {
            return numero_tarjeta;
      }

      public void setNumero_tarjeta(String numero_tarjeta) {
            this.numero_tarjeta = numero_tarjeta;
      }
    
      public FormaPago getFormapago() {
        return formapago;
    }

    public void setFormapago(FormaPago formapago) {
        this.formapago = formapago;
    }
}
