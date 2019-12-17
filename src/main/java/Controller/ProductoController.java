
package Controller;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "ProductoController")
@RequestScoped
public class ProductoController implements Serializable{
    
    private String mensaje;


}
