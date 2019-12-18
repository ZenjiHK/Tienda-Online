
package Controller;

import EJB.DescuentoFacadeLocal;
import Entity.Descuento;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jose.cortezusam
 */
@ManagedBean
@SessionScoped
public class DescuentoController {
    
    @EJB
    private DescuentoFacadeLocal descuentoEJB;
    private Descuento descuento;
    private List<Descuento> lista;

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public List<Descuento> getLista() {
        return lista;
    }

    public void setLista(List<Descuento> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void init(){
        descuento = new Descuento();
    }
    
    public void insertar(){
        try {
            descuentoEJB.create(descuento);
        } catch (Exception e) {
        }
    }
    
    public void listar(){
        try {
            lista = descuentoEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public void leerid(Descuento d){
        try {
            this.descuento = d;
        } catch (Exception e) {
        }
    }
    
    public void modificar(){
        try {
            descuentoEJB.edit(descuento);
        } catch (Exception e) {
        }
    }
    
    public void eliminar(Descuento d){
        try {
            this.descuento = d;
            descuentoEJB.remove(descuento);
            lista = descuentoEJB.findAll();
        } catch (Exception e) {
        }
    }
}
