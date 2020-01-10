package Entity;

import Entity.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-10T11:15:43")
@StaticMetamodel(TipoRopa.class)
public class TipoRopa_ { 

    public static volatile SingularAttribute<TipoRopa, Integer> idTipoRopa;
    public static volatile SingularAttribute<TipoRopa, String> nombreTipoRopa;
    public static volatile ListAttribute<TipoRopa, Producto> lista_productos;

}