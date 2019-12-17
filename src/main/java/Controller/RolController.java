
package Controller;

import EJB.RolFacadeLocal;
import Entity.Rol;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

@Named(value = "rolController")
@RequestScoped
public class RolController implements Serializable{

    private String mensaje;
    
    @EJB
    private RolFacadeLocal rolFacade;
    private Rol rol;
    private List<Rol> listaRol;

    public List<Rol> getListaRol() {
        this.listaRol = rolFacade.findAll();
        return listaRol;
    }

    public void setListaRol(List<Rol> listaRol) {
        this.listaRol = listaRol;
    }
    
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @PostConstruct
    public void init(){
        
    }
    
    
}
