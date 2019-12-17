package Controller;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "tiporopaController")
@RequestScoped
public class TipoRopaController implements Serializable{
    
    private String mensaje;
    
    
}
