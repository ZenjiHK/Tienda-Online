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
@Table(name = "pais")
public class Pais implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais")
    private int idPais;
    
    @Column(name = "nombre_pais")
    private String nombrePais;
        
    @OneToMany(targetEntity=Cliente.class,mappedBy="pais")
    private List<Cliente> lista_clientes;

    public Pais() {
    }

    public Pais(int idPais) {
        this.idPais = idPais;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.idPais;
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
        if (this.idPais != other.idPais) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pais{" + "idPais=" + idPais + '}';
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public List<Cliente> getLista_clientes() {
        return lista_clientes;
    }

    public void setLista_clientes(List<Cliente> lista_clientes) {
        this.lista_clientes = lista_clientes;
    }
}