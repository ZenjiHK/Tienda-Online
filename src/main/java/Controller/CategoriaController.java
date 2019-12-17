package Controller;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "categoriaController")
@RequestScoped
public class CategoriaController implements Serializable{
    
    private String mensaje;
    
    
    
}
