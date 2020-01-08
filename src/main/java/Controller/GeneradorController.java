
package Controller;

import EJB.GeneradorFacadeLocal;
import Entity.Generador;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author jose.cortezusam
 */
@ManagedBean
@SessionScoped
public class GeneradorController implements Serializable {

    @EJB
    private GeneradorFacadeLocal generadorEJB;
    private Generador generador;
    private List<Generador> lista;

    public Generador getGenerador() {
        return generador;
    }

    public void setGenerador(Generador generador) {
        this.generador = generador;
    }

    public List<Generador> getLista() {
        return lista = this.generadorEJB.findAll();
    }

    public void setLista(List<Generador> lista) {
        this.lista = lista;
    }

    
    @PostConstruct
    public void init(){
        generador = new Generador();
    }
    
    public void insertar(){
        try {
           generadorEJB.create(generador);
        } catch (Exception e) {
        }
    }
    
    public void listar(){
        try {
            lista = generadorEJB.findAll();
        } catch (Exception e) {
        }
    }
}
