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
@Table(name = "forma_pago")
public class FormaPago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private int id_pago;
    
    @Column(name = "forma")
    private String forma;
    
    @OneToMany(mappedBy = "pago")
    private List<Venta> ventaList;

    public FormaPago() {
    }

    public FormaPago(int id_pago) {
        this.id_pago = id_pago;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id_pago;
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
        final FormaPago other = (FormaPago) obj;
        if (this.id_pago != other.id_pago) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Entity.FormaPago[ id=" + id_pago + " ]";
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }
    
    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }   
}