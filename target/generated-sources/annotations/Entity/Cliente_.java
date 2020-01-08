package Entity;

import Entity.DetalleTarjeta;
import Entity.Pais;
import Entity.User;
import Entity.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-08T16:44:18")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile ListAttribute<Cliente, Venta> lista_ventas;
    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, String> nombreCliente;
    public static volatile ListAttribute<Cliente, DetalleTarjeta> lista_detalle_tarjetas;
    public static volatile SingularAttribute<Cliente, String> apellidoCliente;
    public static volatile SingularAttribute<Cliente, String> correo;
    public static volatile SingularAttribute<Cliente, String> direccion;
    public static volatile ListAttribute<Cliente, User> lista_users;
    public static volatile SingularAttribute<Cliente, Pais> pais;

}