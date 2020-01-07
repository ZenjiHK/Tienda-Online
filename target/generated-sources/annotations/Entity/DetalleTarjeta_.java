package Entity;

import Entity.Cliente;
import Entity.Venta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-07T14:53:44")
@StaticMetamodel(DetalleTarjeta.class)
public class DetalleTarjeta_ { 

    public static volatile SingularAttribute<DetalleTarjeta, Cliente> cliente;
    public static volatile SingularAttribute<DetalleTarjeta, Boolean> estado;
    public static volatile ListAttribute<DetalleTarjeta, Venta> lista_ventas;
    public static volatile SingularAttribute<DetalleTarjeta, Integer> ping;
    public static volatile SingularAttribute<DetalleTarjeta, Integer> idDetalleTarjeta;
    public static volatile SingularAttribute<DetalleTarjeta, Date> expiracion;

}