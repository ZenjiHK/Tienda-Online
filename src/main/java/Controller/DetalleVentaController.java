
package Controller;

import EJB.DetalleVentaFacadeLocal;
import Entity.DetalleVenta;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author jose.cortezusam
 */
@Named(value = "detalleVentaController")
@SessionScoped
public class DetalleVentaController implements Serializable{
    
    @EJB
    private DetalleVentaFacadeLocal detalleVentaEJB;
    private DetalleVenta detalleVenta;
    private List<DetalleVenta> lista;

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public List<DetalleVenta> getLista() {
        return lista;
    }

    public void setLista(List<DetalleVenta> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void init(){
        detalleVenta = new DetalleVenta();
    }
    
    public void insertar(){
        try {
            detalleVentaEJB.create(detalleVenta);
        } catch (Exception e) {
        }
    }
    
    public void listar(){
        try {
            lista = detalleVentaEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public void leerid(DetalleVenta dv){
        try {
            this.detalleVenta = dv;
        } catch (Exception e) {
        }
    }
    
    public void modificar(){
        try {
            detalleVentaEJB.edit(detalleVenta);
        } catch (Exception e) {
        }
    }
    
    public void eliminar(DetalleVenta dv){
        try {
            this.detalleVenta = dv;
            detalleVentaEJB.remove(detalleVenta);
            lista = detalleVentaEJB.findAll();
        } catch (Exception e) {
        }
    }
    
}
