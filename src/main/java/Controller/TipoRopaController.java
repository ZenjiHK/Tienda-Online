package Controller;

import EJB.TipoRopaFacadeLocal;
import Entity.Talla;
import Entity.TipoRopa;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "tipoRopaController")
@RequestScoped
public class TipoRopaController implements Serializable {

    private String mensaje = "";
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

    @PostConstruct
    public void init() {
        this.tipoRopa = new TipoRopa();
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
            this.tipoRopa = new TipoRopa();
            this.mensaje = "Tipo de ropa editada correctamente";
        } catch (Exception e) {
            this.mensaje = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    //Metodo limpiar
    public void limpiar() {
        this.tipoRopa = new TipoRopa();
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
