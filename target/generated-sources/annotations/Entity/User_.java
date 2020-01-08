package Entity;

import Entity.Cliente;
import Entity.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-08T09:37:23")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Cliente> cliente;
    public static volatile SingularAttribute<User, Integer> clave;
    public static volatile SingularAttribute<User, Boolean> estado;
    public static volatile SingularAttribute<User, String> nombreUsuario;
    public static volatile SingularAttribute<User, Rol> rol;

}