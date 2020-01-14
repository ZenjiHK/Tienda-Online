package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forma_pago")
public class FormaPago implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forma_pago")
    private int idFormaPago;

    @Column(name = "nombre_forma_pago")
    private String nombreFormaPago;

    public FormaPago() {
    }

    public FormaPago(int id) {
        this.idFormaPago = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idFormaPago;
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
        if (this.idFormaPago != other.idFormaPago) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "FormaPago[ idFormaPago=" + idFormaPago + " ]";
    }

    public int getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(int id) {
        this.idFormaPago = id;
    }

    public String getNombreFormaPago() {
        return nombreFormaPago;
    }

    public void setNombreFormaPago(String nombreFormaPago) {
        this.nombreFormaPago = nombreFormaPago;
    }

}