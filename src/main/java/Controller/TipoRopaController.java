package Controller;

import EJB.TipoRopaFacadeLocal;
import Entity.TipoRopa;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "tipoRopaController")
@RequestScoped
public class TipoRopaController implements Serializable{
    
    private String mensaje;
     @EJB
    private TipoRopaFacadeLocal tipoRopaFacade;
    private TipoRopa tipoRopa;
    private List<TipoRopa> listaTipoRopa;

    public TipoRopa getTipoRopa() {
        this.listaTipoRopa = tipoRopaFacade.findAll();
        return tipoRopa;
    }

    public void setTipoRopa(TipoRopa tipoRopa) {
        this.tipoRopa = tipoRopa;
    }

    public List<TipoRopa> getListaTipoRopa() {
        return listaTipoRopa;
    }

    public void setListaTipoRopa(List<TipoRopa> listaTipoRopa) {
        this.listaTipoRopa = listaTipoRopa;
    }
    
    

    
}
