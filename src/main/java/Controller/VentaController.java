package Controller;

import EJB.VentaFacadeLocal;
import Entity.Venta;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "ventaController")
@SessionScoped
public class VentaController implements Serializable {
    
    @EJB
    private VentaFacadeLocal ventaEJB;
    private List<Venta> lista_ventas;
    private Venta venta;
    private String msg;

    @PostConstruct
    public void init(){
        this.venta = new Venta();
        this.msg = "";
    }
    
    public void guardar(){
        try{
            this.ventaEJB.create(venta);
            limpiar();
            this.msg = "Exito";
        }catch(Exception e){
            this.msg = "Error "+e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msg);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    public void actualizar(){
        try{
            this.ventaEJB.edit(venta);
            limpiar();
            this.msg = "Exito";
        }catch(Exception e){
            this.msg = "Error "+e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msg);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    public void eliminar(Venta v){
        try{
            this.ventaEJB.remove(v);
            limpiar();
            this.msg = "Exito";
        }catch(Exception e){
            this.msg = "Error "+e.getMessage();
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(this.msg);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    public void cargar(Venta v){
        this.venta=v;
    }
    public void limpiar(){
        this.venta = new Venta();
        this.lista_ventas = ventaEJB.findAll();
        this.msg = "";
    }
}