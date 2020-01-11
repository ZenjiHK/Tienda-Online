package Entity;

import Entity.Cliente;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-11T11:45:19")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile SingularAttribute<Pais, Integer> idPais;
    public static volatile ListAttribute<Pais, Cliente> lista_clientes;
    public static volatile SingularAttribute<Pais, String> nombrePais;

}