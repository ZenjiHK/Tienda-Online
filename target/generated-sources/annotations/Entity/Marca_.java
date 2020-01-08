package Entity;

import Entity.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-08T16:44:18")
@StaticMetamodel(Marca.class)
public class Marca_ { 

    public static volatile SingularAttribute<Marca, Integer> idMarca;
    public static volatile SingularAttribute<Marca, String> nombreMarca;
    public static volatile ListAttribute<Marca, Producto> lista_productos;

}