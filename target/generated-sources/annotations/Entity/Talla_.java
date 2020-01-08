package Entity;

import Entity.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-08T15:47:23")
@StaticMetamodel(Talla.class)
public class Talla_ { 

    public static volatile SingularAttribute<Talla, String> talla;
    public static volatile SingularAttribute<Talla, Integer> idTalla;
    public static volatile ListAttribute<Talla, Producto> lista_productos;

}