package Entity;

import Entity.Cliente;
import Entity.Venta;
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
@StaticMetamodel(DetalleTarjeta.class)
public class DetalleTarjeta_ { 

    public static volatile SingularAttribute<DetalleTarjeta, Cliente> cliente;
    public static volatile ListAttribute<DetalleTarjeta, Venta> lista_ventas;
    public static volatile SingularAttribute<DetalleTarjeta, Integer> ping;
    public static volatile SingularAttribute<DetalleTarjeta, Integer> idDetalleTarjeta;
    public static volatile SingularAttribute<DetalleTarjeta, Date> expiracion;

}