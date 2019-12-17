package Controller;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "marcaController")
@RequestScoped
public class MarcaController implements Serializable{
    
    private String mensaje;
    
}
