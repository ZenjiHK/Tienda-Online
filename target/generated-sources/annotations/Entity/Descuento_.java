package Entity;

import Entity.DetalleVenta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-09T15:56:21")
@StaticMetamodel(Descuento.class)
public class Descuento_ { 

    public static volatile SingularAttribute<Descuento, Integer> idDescuento;
    public static volatile SingularAttribute<Descuento, Double> descuento;
    public static volatile ListAttribute<Descuento, DetalleVenta> lista_detalle_ventas;

}