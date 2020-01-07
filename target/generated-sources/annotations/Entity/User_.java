package Entity;

import Entity.Cliente;
import Entity.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-07T11:48:20")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-07T13:08:45")
>>>>>>> 6a2c9fa09cd83a86ec61dd0b4dd5d0c99cd2d785
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Cliente> cliente;
    public static volatile SingularAttribute<User, Integer> clave;
    public static volatile SingularAttribute<User, Boolean> estado;
    public static volatile SingularAttribute<User, String> nombreUsuario;
    public static volatile SingularAttribute<User, Rol> rol;

}