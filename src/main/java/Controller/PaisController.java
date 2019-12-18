package Controller;

import EJB.PaisFacadeLocal;
import Entity.Pais;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author maynor.menjivarusam
 */
@ManagedBean
@SessionScoped
public class PaisController implements Serializable{
    @EJB
    private PaisFacadeLocal paisEJB;
    private Pais pais;
    private List<Pais> listaPais;
//asdasdasdasdas
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Pais> getListaPais() {
        this.listaPais=this.paisEJB.findAll();
        return listaPais;
    }

    public void setListaPais(List<Pais> listaPais) {
        this.listaPais = listaPais;
    }
    
    @PostConstruct
    public void init(){
    pais=new Pais();
    }
    
    
}
