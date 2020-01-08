package Entity;

import Entity.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-08T11:25:21")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, Integer> idCategoria;
    public static volatile ListAttribute<Categoria, Producto> lista_productos;
    public static volatile SingularAttribute<Categoria, String> nombreCategoria;

}