package Entity;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.validation.constraints.Min;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "precio_compra")
    @Min(1)
    private double precioCompra;

    @Column(name = "precio_venta")
    @Min(1)
    private double precioVenta;

    @Column(name = "stock")
    private int stock;

    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne
    private Categoria categoria;

    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne
    private Marca marca;

    @JoinColumn(name = "id_talla", referencedColumnName = "id_talla")
    @ManyToOne
    private Talla talla;

    @JoinColumn(name = "id_tipo", referencedColumnName = "id_ropa")
    @ManyToOne
    private TipoRopa tipoRopa;

    @OneToMany(targetEntity=DetalleVenta.class,mappedBy="producto")
    private List<DetalleVenta> lista_detalle_ventas;
    
    @Column(name = "img")
    private String url;

    public Producto() {
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.idProducto;
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
        final Producto other = (Producto) obj;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + '}';
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public TipoRopa getTipoRopa() {
        return tipoRopa;
    }

    public void setTipoRopa(TipoRopa tipoRopa) {
        this.tipoRopa = tipoRopa;
    }

    public List<DetalleVenta> getLista_detalle_ventas() {
        return lista_detalle_ventas;
    }

    public void setLista_detalle_ventas(List<DetalleVenta> lista_detalle_ventas) {
        this.lista_detalle_ventas = lista_detalle_ventas;
    }

      public String getUrl() {
            return url;
      }

      public void setUrl(String url) {
            this.url = url;
      }

}