package Controller;

import EJB.DescuentoFacadeLocal;
import Entity.Descuento;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author jose.cortezusam
 */
@Named(value = "descuentoController")
@SessionScoped
public class DescuentoController implements Serializable{
    
    @EJB
    private DescuentoFacadeLocal descuentoEJB;
    private Descuento descuento;
    private List<Descuento> listaDescuento;

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public List<Descuento> getLista() {
        return listaDescuento;
    }

    public void setLista(List<Descuento> lista) {
        this.listaDescuento = lista;
    }
    
    @PostConstruct
    public void init(){
        descuento = new Descuento();
        listaDescuento= descuentoEJB.findAll();
    }
    
    public void insertar(){
        try {
            descuentoEJB.create(descuento);
        } catch (Exception e) {
        }
    }
    
    public void listar(){
        try {
            listaDescuento = descuentoEJB.findAll();
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
            listaDescuento = descuentoEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public void limpiar(){
        descuento = new Descuento();
        listaDescuento= descuentoEJB.findAll();
    }
}
