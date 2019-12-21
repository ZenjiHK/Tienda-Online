package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int idCliente;
    
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    
    @Column(name = "apellido_cliente")
    private String apellidoCliente;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "direccion")
    private String direccion;
    
    @OneToMany(targetEntity=Venta.class,mappedBy="cliente")
    private List<Venta> lista_ventas;
    
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais")
    @ManyToOne
    private Pais pais;
    
    @OneToMany(targetEntity=DetalleTarjeta.class,mappedBy="cliente")
    private List<DetalleTarjeta> lista_detalle_tarjetas;
    
    @OneToMany(targetEntity=User.class,mappedBy="cliente")
    private List<User> lista_users;

    public Cliente() {
    }

    public Cliente(int id) {
        this.idCliente = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.idCliente;
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
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Categoria{" + "idCliente=" + idCliente + '}';
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int id) {
        this.idCliente = id;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellido) {
        this.apellidoCliente = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombre) {
        this.nombreCliente = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Venta> getLista_ventas() {
        return lista_ventas;
    }

    public void setLista_ventas(List<Venta> lista_ventas) {
        this.lista_ventas = lista_ventas;
    }

    public List<DetalleTarjeta> getLista_detalle_tarjetas() {
        return lista_detalle_tarjetas;
    }

    public void setLista_detalle_tarjetas(List<DetalleTarjeta> lista_detalle_tarjetas) {
        this.lista_detalle_tarjetas = lista_detalle_tarjetas;
    }

    public List<User> getLista_users() {
        return lista_users;
    }

    public void setLista_users(List<User> lista_users) {
        this.lista_users = lista_users;
    }
}