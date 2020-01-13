package Controller;

import EJB.TallaFacadeLocal;
import Entity.Talla;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "tallaController")
@SessionScoped
public class TallaController implements Serializable{

    @EJB
    private TallaFacadeLocal tallaFacade;
    private Talla talla;
    private List<Talla> listaTalla;
    private String mensaje = "";

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public List<Talla> getListaTalla() {
        this.listaTalla = this.tallaFacade.findAll();
        return listaTalla;
    }

    public void setListaTalla(List<Talla> listaTalla) {
        this.listaTalla = listaTalla;
    }

    @PostConstruct
    public void init() {
        this.talla = new Talla();
        this.listaTalla=tallaFacade.findAll();
        this.mensaje="";
    }

    //Metodo insertar
    public void insertar() {
        try {
            this.tallaFacade.create(talla);
            this.talla = new Talla();
            this.mensaje = "Nueva talla ingresada";
        } catch (Exception e) {
            this.mensaje = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    //Metodo para cargar datos
    public void cargarDatos(Talla t) {
        this.talla = t;
    }

    //Metodo editar
    public void editar() {
        try {
            this.tallaFacade.edit(talla);
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
        this.talla = new Talla();
        this.listaTalla=tallaFacade.findAll();
        this.mensaje="";
    }

    //Metodo eliminar
    public void eliminar(Talla t) {
        try {
            this.tallaFacade.remove(t);
            this.talla = new Talla();
            this.mensaje = "Talla eliminada";
        } catch (Exception e) {
            this.mensaje = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }
}
