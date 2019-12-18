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
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private int id_categoria;
    
    @Column(name = "categoria")
    private String categoria;
    
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productoList;

    public Categoria() {
    }

    public Categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id_categoria;
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
        if (this.id_categoria != other.id_categoria) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Categoria{" + "id=" + id_categoria + '}';
    }

    public int getId() {
        return id_categoria;
    }

    public void setId(int id) {
        this.id_categoria = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
     
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }
}