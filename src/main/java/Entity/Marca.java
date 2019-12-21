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
@Table(name = "marca")
public class Marca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private int idMarca;   

    @Column(name = "nombre_marca")
    private String nombreMarca; 

    @OneToMany(targetEntity=Producto.class,mappedBy="marca")
    private List<Producto> lista_productos;

    public Marca() {
    }

    public Marca(int idMarca) {
        this.idMarca = idMarca;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idMarca;
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

        final Marca other = (Marca) obj;
        if (this.idMarca != other.idMarca) {
     return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "Marca{" + "idMarca=" + idMarca + '}';
    }



    public int getIdMarca() {
       return idMarca;
    }


    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }


    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
       this.nombreMarca = nombreMarca;
    }

    public List<Producto> getLista_productos() {
        return lista_productos;
    }

    public void setLista_productos(List<Producto> lista_productos) {
        this.lista_productos = lista_productos;
    }

}