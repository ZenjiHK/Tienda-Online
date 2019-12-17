package Controller;

import EJB.TallaFacadeLocal;
import EJB.UserFacadeLocal;
import Entity.Talla;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "tallaController")
@RequestScoped
public class TallaController {         
    private String mensaje;
    
    @EJB
    private TallaFacadeLocal tallaFacade;
    private Talla talla;
    private List<Talla> listaTalla;

    public Talla getTalla() {
        this.listaTalla = this.tallaFacade.findAll();
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public List<Talla> getListaTalla() {
        return listaTalla;
    }

    public void setListaTalla(List<Talla> listaTalla) {
        this.listaTalla = listaTalla;
    }
    
    @PostConstruct
    public void init(){
        talla = new Talla();
    }
    
}
