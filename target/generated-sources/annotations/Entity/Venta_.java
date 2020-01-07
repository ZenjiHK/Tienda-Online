package Entity;

import Entity.Cliente;
import Entity.DetalleTarjeta;
import Entity.Factura;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-07T11:48:20")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-07T13:08:45")
>>>>>>> 6a2c9fa09cd83a86ec61dd0b4dd5d0c99cd2d785
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Date> fecha;
    public static volatile SingularAttribute<Venta, Cliente> cliente;
    public static volatile SingularAttribute<Venta, Boolean> estado;
    public static volatile SingularAttribute<Venta, DetalleTarjeta> detalleTarjeta;
    public static volatile ListAttribute<Venta, Factura> lista_facturas;
    public static volatile SingularAttribute<Venta, Integer> idVenta;

}