package Entity;

import Entity.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-07T11:16:39")
@StaticMetamodel(FormaPago.class)
public class FormaPago_ { 

    public static volatile SingularAttribute<FormaPago, Integer> idFormaPago;
    public static volatile ListAttribute<FormaPago, Factura> lista_facturas;
    public static volatile SingularAttribute<FormaPago, String> nombreFormaPago;

}