package Controller;

import EJB.TipoRopaFacadeLocal;
import Entity.TipoRopa;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "tipoRopaController")
@SessionScoped
public class TipoRopaController implements Serializable{

    @EJB
    private TipoRopaFacadeLocal tipoRopaFacade;
    private TipoRopa tipoRopa;
    private List<TipoRopa> listaTipoRopa;
    private String mensaje = "";
    
    public TipoRopa getTipoRopa() {
        return tipoRopa;
    }

    public void setTipoRopa(TipoRopa tipoRopa) {
        this.tipoRopa = tipoRopa;
    }

    public List<TipoRopa> getListaTipoRopa() {
        this.listaTipoRopa = tipoRopaFacade.findAll();
        return listaTipoRopa;
    }

    public void setListaTipoRopa(List<TipoRopa> listaTipoRopa) {
        this.listaTipoRopa = listaTipoRopa;
    }

    @PostConstruct
    public void init() {
        this.tipoRopa = new TipoRopa();
        this.listaTipoRopa=tipoRopaFacade.findAll();
        this.mensaje="";
    }

    //Metodo insertar
    public void insertar() {
        try {
            this.tipoRopaFacade.create(tipoRopa);
            this.tipoRopa = new TipoRopa();
            this.mensaje = "Nueva tipo de ropa ingresada";
        } catch (Exception e) {
            this.mensaje = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    //Metodo para cargar datos
    public void cargarDatos(TipoRopa t) {
        this.tipoRopa = t;
    }

    //Metodo editar
    public void editar() {
        try {
            this.tipoRopaFacade.edit(tipoRopa);
            this.mensaje = "Editado con éxito";
        } catch (Exception e) {
            this.mensaje = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    //Metodo limpiar
    public void limpiar() {
        this.tipoRopa = new TipoRopa();
        this.listaTipoRopa=tipoRopaFacade.findAll();
        this.mensaje="";
    }

    //Metodo eliminar
    public void eliminar(TipoRopa t) {
        try {
            this.tipoRopaFacade.remove(t);
            this.tipoRopa = new TipoRopa();
            this.mensaje = "Tipo de ropa eliminada";
        } catch (Exception e) {
            this.mensaje = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }
}