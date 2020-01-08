
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jose.cortezusam
 */

@Entity 
@Table(name="contrasenaGenerada")
public class Generador implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_contra;
    
    @Column(name = "contrasena")
    private String contrasena;

    public int getId_contra() {
        return id_contra;
    }

    public void setId_contra(int id_contra) {
        this.id_contra = id_contra;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id_contra;
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
        final Generador other = (Generador) obj;
        if (this.id_contra != other.id_contra) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Generador{" + "id_contra=" + id_contra + '}';
    }

    
}
