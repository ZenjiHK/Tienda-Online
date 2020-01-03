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
@Table(name = "categoria")
public class Categoria implements Serializable {
    //cambio
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private int idCategoria;
    
    @Column(name = "nombre_categoria")
    private String nombreCategoria;
    
    @OneToMany
    private List<Producto> lista_productos;
    public Categoria() {
    }
    public Categoria(int id) {
        this.idCategoria = id;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.idCategoria;
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
        final Categoria other = (Categoria) obj;
        if (this.idCategoria != other.idCategoria) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Categoria{" + "idCategoria=" + idCategoria + '}';
    }
    public int getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(int id) {
        this.idCategoria = id;
    }
    public String getNombreCategoria() {
        return nombreCategoria;
    }
    public void setNombreCategoria(String nombre) {
        this.nombreCategoria = nombre;
    }
    public List<Producto> getLista_productos() {
        return lista_productos;
    }
    public void setLista_productos(List<Producto> lista_productos) {
        this.lista_productos = lista_productos;
    }
}