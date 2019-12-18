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
@Table(name = "pais")
public class Pais implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais")
    private int id_pais;
    
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "pais")
    private List<Cliente> clienteList;

    public Pais() {
    }

    public Pais(int id_pais) {
        this.id_pais = id_pais;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.id_pais;
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
        final Pais other = (Pais) obj;
        if (this.id_pais != other.id_pais) {
            return false;
        }
        return true;
    }   
    
    @Override
    public String toString() {
        return "Entity.Pais[ id=" + id_pais + " ]";
    }   

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }
}