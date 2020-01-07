package Entity;

import Entity.Categoria;
import Entity.DetalleVenta;
import Entity.Marca;
import Entity.Talla;
import Entity.TipoRopa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-07T11:48:20")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-07T13:08:45")
>>>>>>> 6a2c9fa09cd83a86ec61dd0b4dd5d0c99cd2d785
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Marca> marca;
    public static volatile SingularAttribute<Producto, Talla> talla;
    public static volatile SingularAttribute<Producto, Double> precioCompra;
    public static volatile SingularAttribute<Producto, Categoria> categoria;
    public static volatile SingularAttribute<Producto, TipoRopa> tipoRopa;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile SingularAttribute<Producto, Double> precioVenta;
    public static volatile SingularAttribute<Producto, Integer> stock;
    public static volatile ListAttribute<Producto, DetalleVenta> lista_detalle_ventas;
    public static volatile SingularAttribute<Producto, String> url;
    public static volatile SingularAttribute<Producto, String> nombreProducto;

}