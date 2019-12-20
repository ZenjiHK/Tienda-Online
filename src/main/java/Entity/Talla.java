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
@Table(name = "talla")
public class Talla implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_talla")
    private int idTalla;
    
    @Column(name = "talla")
    private String talla;
    
    @OneToMany(targetEntity=Producto.class,mappedBy="talla")
    private List<Producto> lista_productos;

    public Talla() {
    }

    public Talla(int idTalla) {
        this.idTalla = idTalla;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idTalla;
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
        final Talla other = (Talla) obj;
        if (this.idTalla != other.idTalla) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Talla{" + "idTalla=" + idTalla + '}';
    }

    public int getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(int idTalla) {
        this.idTalla = idTalla;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public List<Producto> getLista_productos() {
        return lista_productos;
    }

    public void setLista_productos(List<Producto> lista_productos) {
        this.lista_productos = lista_productos;
    }
}