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
@Table(name = "tipo_ropa")
public class TipoRopa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ropa")
    private int idTipoRopa;
    
    @Column(name = "nombre_ropa")
    private String nombreTipoRopa;
    
    @OneToMany(targetEntity=Producto.class,mappedBy="tipoRopa")
    private List<Producto> lista_productos;

    public TipoRopa() {
    }

    public TipoRopa(int idTipoRopa) {
        this.idTipoRopa = idTipoRopa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idTipoRopa;
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
        final TipoRopa other = (TipoRopa) obj;
        if (this.idTipoRopa != other.idTipoRopa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoRopa{" + "idTipoRopa=" + idTipoRopa + '}';
    }

    public int getIdTipoRopa() {
        return idTipoRopa;
    }

    public void setIdTipoRopa(int idTipoRopa) {
        this.idTipoRopa = idTipoRopa;
    }

    public String getNombreTipoRopa() {
        return nombreTipoRopa;
    }

    public void setNombreTipoRopa(String nombreTipoRopa) {
        this.nombreTipoRopa = nombreTipoRopa;
    }

    public List<Producto> getLista_productos() {
        return lista_productos;
    }

    public void setLista_productos(List<Producto> lista_productos) {
        this.lista_productos = lista_productos;
    }
}